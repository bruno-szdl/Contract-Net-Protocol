/* ----------------- Initial Beliefs ----------------- */

typeOfFood(10).																	//number of different types of food
thinking(false).																//thinking abbout the proposals
sells(0).																		//number of sells
searching(false).																//searching delivery men

//food(Id, Name, MinPrice, MaxPrice)
food(0, pizza, 20, 100).
food(1, hamburger, 10, 50).
food(2, burrito, 18, 50).
food(3, pastel, 5, 35).
food(4, pasta, 20, 140).
food(5, sushi, 70, 200).
food(6, seafood, 20, 120).
food(7, hotdog, 8, 30).
food(8, salad, 15, 40).
food(9, sfiha, 20, 40).


/* ----------------- Rules ----------------- */

all_proposals_received(OrderId, NT) :-              							//number of participants (delivery men)
     .count(availableDeliveryMan(_)[source(_)], NP) &   						//number of proposes received
     .count(notAvailableDeliveryMan[source(_)], NR) &      						//number of refusals received
     NT = NP + NR.																//number of participants must be the sum of proposes and refusals
	

/* ----------------- Initial Goals ----------------- */

!init.																			//choose the type of restaurant
!getLocation.																	//get the location fo the restaurant
!getRate.


/* ----------------- Plans ----------------- */

//choose the type of restaurant
+!init
	:  .random(Ra) & 
	   .random(R) &																//random R
	   typeOfFood(TOF) &														//number of different types of food
	   N = math.floor(TOF*R) &													// 0 <= N <= 9
	   food(N, F, Min, Max)														//get the food information
	<- +myFoodType(F, Min, Max);												//add belief of the type of restaurant
	   .print("I am a restaurant and I serve ", F,".");							//
	   .abolish(food(_,_,_,_));													//clear memory
	   .wait(R*2000);
	   .df_register(F);
	   -typeOfFood(_);															//clear memory
	   !getFoodPrice.															//add goal to get the food price

//Get the price of the food
+!getFoodPrice
	:  myFoodType(F, Min, Max) &												//given food type information
	   .random(R) &																//random R
	   FP = math.round(Min + (Max - Min)*R)										//get food price
	<- +foodPrice(FP).															//add belief of the food price

//Get location
+!getLocation
	:  .random(XRestaurant) &													//random X coordinate
	   .random(YRestaurant)	&													//random Y coordinate
	   .random(R)																//given random R
	<- +location(XRestaurant*100, YRestaurant*100);								//add belief of the location
		DR = 60 - 50*R;															//calculate delivery radius
	   +deliveryRadius(DR)														//add belief delivery radius
	   .print("I am located in (", XRestaurant*100, ", ", YRestaurant*100, ")."). //

//Get rate
+!getRate
	:  .random(R) &																//given random R
	   S = math.ceil(5*R)
	<- +stars(S)
	   .print("I have ", S, "stars."). //

			
/* ----------------- Plans as participant ----------------- */

//answer client's order with price and rating
+order(OrderId, XClient, YClient)[source(Client)] 
	:  foodPrice(FP) &															//given food price
	   stars(S) &																//given rating
	   location(XRestaurant,YRestaurant) &										//given location
	   deliveryRadius(DR) &														//given delivery radius
	   D = math.abs(XRestaurant - XClient) + math.abs(YRestaurant - YClient) &  //calculate manhattan distance from client to restaurant
	   D < DR																	//if distance is less than delivery radius
	<- Total = D/2 + FP;														//calculate total price (food + delivery)
	   +orderAdress(OrderId, Client, XClient, YClient, D);						//add belief of the client's adress
	   //.print("[",Client,"] proposing ",Total, " for Order: ", OrderId,"."); 	//
	   .send(Client, tell, propose(OrderId, Total, FP, D, S));					//send proposal to the client
	   -order(OrderId,_,_).            											//clear memory
	   
//client is too far
+order(OrderId,_,_)[source(Client)] 
	<- .send(Client, tell, refuse(OrderId));									//refuse order						
	  //.print("[",Client,"] refusing ", OrderId,".");							//
	  -order(OrderId,_,_).      											    //clear memory

//Client has confirmed the order
+confirm_order(OrderId)[source(Client)] 
	: .random(R) &
	  orderAdress(OrderId, Client, XClient, YClient, D)							//given order's adress
   <- .send(Client, tell, inform_preparing(OrderId));							//tell client the food is being prepared
      //.print("[",Client,"] preparing ", OrderId,".");							//
	  -confirm_order(OrderId)[source(Client)];									//clear memory
	  .wait(R*2000);
	  +needToDeliver(OrderId, Client, XClient, YClient, D);						//add belief that a deliver must be made to the client
	  -orderAdress(OrderId, _, _, _, _).										//clear memory

//Client has cancelled the order
+cancel_order(OrderId)[source(Client)]
   <- .send(Client, tell, inform_cancel(OrderId));								//confirm to the client the order has been cancelled
      //.print("[",Client,"]", Client, " cancelled order ",OrderId, ".");		//
	  -orderAdress(OrderId,_,_,_,_);											//clear memory
      -cancel_order(OrderId)[source(Client)].									//clear memory

	  
/* ----------------- Plans as initiator ----------------- */

//when the restaurant need to deliver
+needToDeliver(OrderId,_,_,_,_)
	<- !searchDeliveryMan(OrderId).														//add goal to search for a delivery man

//search all delivery men
+!searchDeliveryMan(OrderId)
	:  location(XRestaurant, YRestaurant)										//given restaurant's location
    <- .abolish(availableDeliveryMan(OrderId,_));             							//clear memory
       .abolish(notAvailableDeliveryMan(OrderId)); 										//clear memory
       .df_search(delivery_man, LD);                               				//search all delivery men
       .send(LD, tell, distanceDeliveryMan(OrderId, XRestaurant, YRestaurant)); 			//ask for the delivery men their locations
       .wait(all_proposals_received(OrderId ,.length(LD)), 4000, _);			//wait delivery men to send their positions
	   //.print("Searching available delivery men...");							//
       !chooseDeliveryMan(OrderId).														//add plan to choose a delivery man

//choose a delivery man
+!chooseDeliveryMan(OrderId)
   :  .findall(distance(D, A), availableDeliveryMan(OrderId, D)[source(A)], L) & 		//put all delivery men's distances into a list
       L \== []																	//if the list is not empty
   <- //.print("Distances are: ",L,".");											//
      .min(L, distance(WD, WAg));                                        		//choose closest delivery man
      //.print("[",WAg,"] Closest delivery man is ",WAg," with ",WD,".");			//
      !answerDeliveryMen(OrderId, L, WAg).												//tell delivery men restaurant's decision

//no delivery man available
+!chooseDeliveryMan(OrderId)
   <- //.print("No available delivery men, waiting to search again.");			//
	  .wait(1000);																//wait to search for another delivery man
      !searchDeliveryMan(OrderId).														//add goal to answer delivery men

//answer the closest delivery man
+!answerDeliveryMen(OrderId, [distance(_,WAg)|T], WAg)
   : .random(R) &
     needToDeliver(OrderId, Client, XClient, YClient, D)
   <- .abolish(availableDeliveryMan(OrderId,_));             							//clear memory
	  .abolish(notAvailableDeliveryMan(OrderId));										//clear memory
      .wait(R*100);
	  .send(WAg, tell, accept_proposal(OrderId, Client, XClient, YClient, D));									//tell the closest delivery man he is the closest one
      //.print("[",WAg,"] Telling ", WAg, ", he is the closest delivery man."); 	//
      !answerDeliveryMen(OrderId, T, WAg).												//answer the others

//answer the others
+!answerDeliveryMen(OrderId, [distance(_,LAg)|T], WAg)
   <- .send(LAg, tell, reject_proposal(OrderId));										//answer the others delivery men
      !answerDeliveryMen(OrderId, T, WAg).												//answer the others

//stop answering
+!answerDeliveryMen(OrderId, [],_).

//the delivery man tells he is making the delivery
+inform_done(OrderId)[source(DeliveryMan)]
	<- //.print("[",DeliveryMan,"] is delivering ",OrderId,".");                  //
	   -inform_done(OrderId)[source(DeliveryMan)];								//clear memory
	   .abolish(orderAdress(OrderId,_,_,_,_)).			 						//clear memory

//the delivery man tells he is no loinger available
+inform_ref(OrderId)[source(DeliveryMan)]
            <- //.print("[",DeliveryMan,"] is no longer available. Searching another delivery man."); //
			   -inform_ref[source(DeliveryMan)];								//clear memory
			   .wait(100);														//wait to search for another delivery man				
               !searchDeliveryMan(OrderId).												//add goal to search a delivery man

//the delivery man tells the order has been delivered
+orderDelivered(OrderId, _)
	<-  -orderDelivered(OrderId, _);											//clear memonry
		.abolish(needToDeliver(OrderId, _, _, _, _)).							//clear memory

//update the rating
+avaliation(ClientStar)[source(A)]
	: stars(S) &																//given rating
	  sells(J) &																//given number of sells
	  NewStar = (ClientStar + S*(J+1))/(J+2)									//calculate new rating
	<- -+stars(NewStar);														//update rating
	   -+sells(J+1).															//update number of sells
