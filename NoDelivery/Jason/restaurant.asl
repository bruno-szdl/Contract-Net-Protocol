/* ----------------- Initial Beliefs ----------------- */

typeOfFood(10).																	//number of different types of food
sells(0).																		//number of sells

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

/* ----------------- Initial Goals ----------------- */

!init.																			//choose the type of restaurant
!getLocation.																	//get the location fo the restaurant
!getRate.


/* ----------------- Plans ----------------- */

//choose the type of restaurant
+!init
	:  .random(R) &																//random R
	   typeOfFood(TOF) &														//number of different types of food
	   N = math.floor(TOF*R) &													// 0 <= N <= 9
	   food(N, F, Min, Max)														//get the food information
	<- +myFoodType(F, Min, Max);												//add belief of the type of restaurant
	   .print("I am a restaurant and I serve ", F,".");							//
	   .abolish(food(_,_,_,_));													//clear memory
	   -typeOfFood(_);															//clear memory
	   !getFoodPrice;															//add goal to get the food price
	   !register.																//add goal to register

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
		DR = 80 - 60*R;															//calculate delivery radius
	   +deliveryRadius(DR)														//add belief delivery radius
	   .print("I am located in (", XRestaurant*100, ", ", YRestaurant*100, ")."). //

//Get rate
+!getRate
	:  .random(R) &																//given random R
	   S = math.ceil(5*R)
	<- +stars(S)
	   .print("I have ", S, "stars."). //

//Register as restaurant that sells some kind of food
+!register
	:  myFoodType(F,_,_)														//given food type
	<- .wait(10);
	   .df_register(F).															//register food type
			
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
	: orderAdress(OrderId, Client, XClient, YClient, D)							//given order's adress
   <- .send(Client, tell, inform_preparing(OrderId));							//tell client the food is being prepared
      //.print("[",Client,"] preparing ", OrderId,".");							//
	  -confirm_order(OrderId)[source(Client)];									//clear memory
	  -orderAdress(OrderId, _, _, _, _).										//clear memory

//Client has cancelled the order
+cancel_order(OrderId)[source(Client)]
   <- .send(Client, tell, inform_cancel(OrderId));								//confirm to the client the order has been cancelled
      //.print("[",Client,"]", Client, " cancelled order ",OrderId, ".");		//
	  -orderAdress(OrderId,_,_,_,_);											//clear memory
      -cancel_order(OrderId)[source(Client)].									//clear memory

//update the rating
+avaliation(ClientStar)[source(A)]
	: stars(S) &																//given rating
	  sells(J) &																//given number of sells
	  NewStar = (ClientStar + S*(J+1))/(J+2)									//calculate new rating
	<- -+stars(NewStar);														//update rating
	   -+sells(J+1).															//update number of sells