

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
	:  .random(R)
	<- .wait(R*2000);
	   .print("Hi, I am a Delivery Man.");										//
	   .df_register(delivery_man).												//register as a delivery man

//Get location
+!getLocation
	:  .random(XDelivery) &														//random X coordinate
	   .random(YDelivery)														//random Y coordinate
	<- +location(XDelivery*100, YDelivery*100).									//add belief for the delivery man's location

//send location to restaurant
+distanceDeliveryMan(OrderId, XRestaurant, YRestaurant)[source(Restaurant)]
	:   working(false) &														//if delivery man is not working
		location(XDelivery, YDelivery) &										//given location
		thinking(false)	&														//if delivery man is not thinking
		DToRestaurant = math.abs(XDelivery - XRestaurant) + math.abs(YDelivery - YRestaurant) //calculate distance from restaurant
	<- -+thinking(true);														//update state
	   .send(Restaurant, tell, availableDeliveryMan(OrderId, DToRestaurant)); 			//tell location to restaurant
	   //.print("[",Restaurant,"]I am available, my distance to ", Restaurant, " is ", DToRestaurant,"."); //
	   -distanceDeliveryMan(OrderId,_,_)[source(Restaurant)]; 							//clear memory
	   -+thinking(false).														//update state
		
//if delivery man is working
+distanceDeliveryMan(OrderId, _)[source(Restaurant)]
	<- .send(Restaurant, tell, notAvailableDeliveryMan(OrderId));						//tell restaurant delivery man is not available
	  //.print("[",Restaurant,"]Sorry, I am not available.");					//
	  -distanceDeliveryMan(OrderId,_)[source(Restaurant)]. 							//clear memory
	  

//restaurant tells delivery man is the closest one
+accept_proposal(OrderId, Client, XClient, YClient, D)[source(Restaurant)]
   :   working(false) &
       money(M) &																//given money
	   deliveries(J)	&									   						//given number of deliveries
	   location(X,Y)	&															//given location
	  .random(R)															//if delivery man is not working
   <- -+working(true);															//update state
   	   +workingFor(Restaurant);													//add belief working for
	   -accept_proposal(OrderId, _, _, _, _)[source(Restaurant)];								//clear memory
	    .wait(D*1);																//wait to get to client
	    -+money(M + D/5);														//update money
		-+deliveries(J+1);														//update number of deliveries
		-+location(XClient, YClient);											//update location
		.wait(R);															//wait to deliver order
		//.print("[",Restaurant,"][",Client,"] Order ", OrderId, " has been delivered --------------------------- "); //
		.send(Client, tell, orderDelivered(OrderId, Restaurant));				//tell restaurant the order has been delivered
		.send(Restaurant, tell, orderDelivered(OrderId, Client));				//tell client the order has been delivered
		-+working(false);														//update state
   	    -workingFor(Restaurant).													//clear memory
		  
//if restaurant chooses delivery man but he is working
+accept_proposal(OrderId, _, _, _, _)[source(Restaurant)]
   :   working(true)															//if delivery man is working
   <- //.print("[",Restaurant,"] Sorry, I am not available anymore.");			//
      .send(Restaurant, tell, inform_ref(OrderId));                     					//tell restaurant delivery man is working
      -accept_proposal(OrderId, _, _, _, _)[source(Restaurant)]. 								//clear memory

//if restaurant has not chosen the delivery man
+reject_proposal(OrderId)[source(Restaurant)]
   <- -reject_proposal(OrderId)[source(Restaurant)].										//clear memory'