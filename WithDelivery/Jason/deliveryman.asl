

/* ----------------- Initial Beliefs ----------------- */

working(false).																	//if delivery man is working
money(0).																		//delivery man's money
deliveries(0).																	//number of deliveries
thinking(false).																//thinking about the proposals
count(0).																		//counter


/* ----------------- Initial Goals ----------------- */

!register.																		//register as a delivery man
!getLocation.																	//get the delivery man's location


/* ----------------- Plans ----------------- */

//register as a delivery man
+!register
	<- .wait(1);
	   .print("Hi, I am a Delivery Man.");										//
	   .df_register(delivery_man).												//register as a delivery man

//Get location
+!getLocation
	:  .random(XDelivery) &														//random X coordinate
	   .random(YDelivery)														//random Y coordinate
	<- +location(XDelivery*100, YDelivery*100).									//add belief for the delivery man's location

//send location to restaurant
+distanceDeliveryMan(XRestaurant, YRestaurant)[source(Restaurant)]
	:   working(false) &														//if delivery man is not working
		location(XDelivery, YDelivery) &										//given location
		thinking(false)	&														//if delivery man is not thinking
		DToRestaurant = math.abs(XDelivery - XRestaurant) + math.abs(YDelivery - YRestaurant) //calculate distance from restaurant
	<- -+thinking(true);														//update state
	   .send(Restaurant, tell, availableDeliveryMan(DToRestaurant)); 			//tell location to restaurant
	   //.print("[",Restaurant,"]I am available, my distance to ", Restaurant, " is ", DToRestaurant,"."); //
	   -distanceDeliveryMan(_,_)[source(Restaurant)]; 							//clear memory
	   -+thinking(false).														//update state
		
//if delivery man is working
+distanceDeliveryMan(_, _)[source(Restaurant)]
	<- .send(Restaurant, tell, notAvailableDeliveryMan);						//tell restaurant delivery man is not available
	  //.print("[",Restaurant,"]Sorry, I am not available.");					//
	  -distanceDeliveryMan(_,_)[source(Restaurant)]. 							//clear memory
	  

//restaurant tells delivery man is the closest one
+accept_proposal(LC)[source(Restaurant)]
   :   working(false)															//if delivery man is not working
   <- -+working(true);															//update state
   	   +workingFor(Restaurant);													//add belief working for
	   -accept_proposal(LC)[source(Restaurant)];								//clear memory
	   !deliver(LC, Restaurant).												//deliver the orders

//deliver an order
+!deliver([delivery(OrderId, Client, XClient, YClient, D)|T], Restaurant)
	: money(M) &																//given money
	  deliveries(J)	&									   						//given number of deliveries
	  location(X,Y)	&															//given location
	  .random(R)
	 <- .send(Restaurant, tell, inform_done(OrderId));							//tell restaurant delivery man is delivering
	    //.print("[",Restaurant,"][",Client,"] I am delivering Order: ", OrderId, " from ", Restaurant, " to ", Client, "."); //
	 	.wait(D*100);																//wait to get to client
	    -+money(M + D/5);														//update money
		-+deliveries(J+1);														//update number of deliveries
		-+location(XClient, YClient);											//update location
		.wait(R*2000);															//wait to deliver order
		//.print("[",Restaurant,"][",Client,"] Order ", OrderId, " has been delivered --------------------------- "); //
		.send(Client, tell, orderDelivered(OrderId, Restaurant));				//tell restaurant the order has been delivered
		.send(Restaurant, tell, orderDelivered(OrderId, Client));				//tell client the order has been delivered
		!deliver(T, Restaurant).                              					//deliver another order

//when all orders have been delivered
+!deliver([], Restaurant)
	: .random(R)																//given random R
	<- .wait(R*1000)																//wait
	   .send(Restaurant, tell, allDeliveriesDone);								//tell restaurant all deliveries are done
	   //.print("Finished deliveries");											//
	   -+working(false);														//update state
   	   -workingFor(Restaurant).													//clear memory
		  
//if restaurant chooses delivery man but he is working
+accept_proposal(LC)[source(Restaurant)]
   :   working(true)															//if delivery man is working
   <- //.print("[",Restaurant,"] Sorry, I am not available anymore.");			//
      .send(Restaurant, tell, inform_ref);                     					//tell restaurant delivery man is working
      -accept_proposal(LC)[source(Restaurant)]. 								//clear memory

//if restaurant has not chosen the delivery man
+reject_proposal[source(Restaurant)]
   <- -reject_proposal[source(Restaurant)].										//clear memory
