{ include("settings.asl") }

/* ----------------- Initial Beliefs ----------------- */

finishedOrders(0). 																//number of finished orders
placedOrders(0).																//number of placed orders
typesOfFood(10). 																//number of different types of food
count(0). 																		//auxiliar counter

// food(Id, Name)
food(0, pizza).
food(1, hamburger).
food(2, burrito).
food(3, pastel).
food(4, pasta).
food(5, sushi).
food(6, seafood).
food(7, hotdog).
food(8, salad).
food(9, sfiha).


/* ----------------- Rules ----------------- */

all_proposals_received(OrderId, NT) :-              							//number of participantes (restaurants)
     .count(propose(OrderId,_,_,_,_)[source(_)], NP) &   						//number of proposes received
     .count(refuse(OrderId)[source(_)], NR) &      								//number of refusals received
     NT = NP + NR.																//number of participants must be the sum of proposes and refusals

	 
/* ----------------- Initial Goals ----------------- */
!init. 																			//add the goal chooseFood for each order
!getLocation. 																	//get the client's house location
!getStrategy. 																	//get the order strategy (price or stars)


/* ----------------- Plans ----------------- */
//add the goal chooseFood for each order
+!init 
	:  count(C) &																//counter
	   nOrders(O) &																//number of orders
	   C < O 																	//if counter is less than number of orders
	<- -+count(C+1);				     										//update counter
	   .wait(100);  															//wait to place another order
	   !chooseFood(C+1) |&| !init.												//choose food for order and repeat

//finished choosing foods to order
+!init 
	<- .print("I have finished choosing food."); 									//
	   -count(_); 																//clear memory
	   -typesOfFood(_); 											     		//clear memory
	   .abolish(food(_,_)).														//clear memory
	   
//get the client's house location
+!getLocation 
	:  .random(XClient) &														//random X coordinate
	   .random(YClient)															//random Y coordinate
	<- +location(XClient*100, YClient*100); 									//add belief location(X,Y)
	   .print("Hi, I am a client.\nI live in (", XClient*100, ", ", YClient*100, ").").				//
	   
//get the order strategy (price or stars)
+!getStrategy 
	:  .random(R) &																//random R
       S = math.round(R)														//S is 0 or 1
	<- +strategy(S).															//add belief strategy(S)
	
//choosing the food for the order
+!chooseFood(X) 
	:  .random(R) &																//random R
	   typesOfFood(TOF) &														//number of types of food
	   N = math.floor(TOF*R) &													// 0 <= N <= 9
	   food(N,F) & 																//get food name for Id
       .my_name(A)																//get client's name
    <- .concat(A, ".Order", X, ".", F, OrderId); 							//generate OrderId
       +wantToEat(OrderId);  													//add belief of what the client wants to eat
       .print("I want to eat some ", F,"."); 									//
       !searchRestaurant(OrderId, F).											//add the goal to search restaurants
	   
//checking all available restaurants for the type of food
+!searchRestaurant(OrderId, F)
	:  location(XClient,YClient)												//given location of the client
	<- .wait(100); 																//wait for restaurants to register
	   .df_search(F ,LR); 														//search all restaurants that serve that kind of food
	   //.print("Searching ",F," restaurants..."); 								//
	   .send(LR, tell, order(OrderId, XClient, YClient)); 						//send order for all restaurants that serve that kind of food
	   .wait(all_proposals_received(OrderId, .length(LR)), 4000, _); 			//wait for all the restaurants to send their proposes
	   !chooseStrategy(OrderId).												//add the goal to choose order strategy
	   
//choosing order strategy
+!chooseStrategy(OrderId)
	:  strategy(S) &															//given strategy S
	   S = 0																	//if S == 0
	<- !chooseRestaurantByPrice(OrderId).										//add the goal to choose the restaurant by min price
	
//choosing order strategy
+!chooseStrategy(OrderId)														//if S \== 0
	<- !chooseRestaurantByStar(OrderId).										//add the goal to choose restaurant by max rating
	
//choosing cheapest restaurant	
+!chooseRestaurantByPrice(OrderId) 
	:  .findall(offer(T, A), propose(OrderId, T, _, _, _)[source(A)], L) &      //put all offers into a list
	   L \== []																	//if the list is not empty
	<- //.print("Prices for ", OrderId, " are ", L,"."); 						//
	   .min(L, offer(WOf,WAg));													//find the cheapest restaurant
	   //.print("[",WAg,"] The cheapest restaurant for ",OrderId," is ",WAg," for ",WOf, "$."); //
	   +choose(OrderId, WAg);													//add= the belief of indicating chosen restaurant for the roder
	   .abolish(propose(OrderId,_,_,_,_)); 										//clear memory
	   .abolish(refuse(OrderId)); 												//clear memory
	   !answerRestaurants(OrderId, L, WAg).										//add the goal to announce the result

//no restaurant found
+!chooseRestaurantByPrice(OrderId)												//if the list is empty, there is no restaurant that serves this kind of food nearby
	:  finishedOrders(FO) &														//given the number of finished orders
	   placedOrders(PO)															//given the number of placed orders
    <- .print("No restaurant for ", OrderId," nearby."); 						//
	   .abolish(refuse(OrderId)); 												//clear memory
	   .abolish(propose(OrderId,_,_,_,_));										//clear memory
       -wantToEat(OrderId);														//clear memory	
	   +noRestaurant(OrderId);													//add the belief that there is no resturant for this kind of food
	   -+placedOrders(PO+1);													//update placed orders (the client did not find a restaurant, but you have to count it)
	   -+finishedOrders(FO+1).													//update finished orders (the client did not find a restaurant, but you have to count it)
	   
//choosing best rated restaurant
+!chooseRestaurantByStar(OrderId) 
	:  .findall(offer(S, A), propose(OrderId, _, _, _, S)[source(A)], L) &      //put all offers into a list
	   L \== []																	//if the list is not empty
	<- .print("Rates for ", OrderId, " are ", L,".");							//
	   .max(L, offer(WOf,WAg));													//find the best rated restaurant
	   //.print("[",WAg,"] The best rated restaurant for ",OrderId," is ",WAg," with ",WOf, " stars."); //
	   +choose(OrderId, WAg);													//add the belief of indicating chosen restaurant for the roder
	   .abolish(propose(OrderId,_,_,_,_)); 										//clear memory
	   .abolish(refuse(OrderId)); 												//clear memory
	   !answerRestaurants(OrderId, L, WAg).										//add the goal to announce the result

//no restaurant found
+!chooseRestaurantByStar(OrderId) 												//if the list is empty, there is no restaurant that serves this kind of food nearby
	:  finishedOrders(FO) &														//given the number of finished orders
	   placedOrders(PO)															//given the number of placed orders
    <- .print("No restaurant for ", OrderId," nearby.");  						//
	   .abolish(refuse(OrderId)); 												//clear memory
	   .abolish(propose(OrderId,_,_,_,_));										//clear memory
       -wantToEat(OrderId);														//clear memory	
	   +noRestaurant(OrderId);													//add the belief that there is no resturant for this kind of food
	   -+placedOrders(PO+1);													//update placed orders (the client did not find a restaurant, but you have to count it)
	   -+finishedOrders(FO+1).													//update finished orders (the client did not find a restaurant, but you have to count it)

//confirm order to the chosen restaurant
+!answerRestaurants(OrderId, [offer(_,WAg)|T], WAg) 
	<- .wait(50);															    //wait to confirm order of the chosen restaurant
	   .send(WAg, tell, confirm_order(OrderId));								//confirm order		
	   //.print("[",WAg,"] waiting ",OrderId,".");								//
	   +waiting(OrderId, WAg);													//add the belief (waiting order)
	   !answerRestaurants(OrderId , T, WAg).								    //add the goal to answer other restaurants

//cancelling orders of the other restaurants
+!answerRestaurants(OrderId, [offer(_,LAg)|T], WAg) 
	<- .send(LAg, tell, cancel_order(OrderId));									//announce the result to other restaurant
	   //.print("[",LAg,"] cancelling ",OrderId,".");							//
	   !answerRestaurants(OrderId, T, WAg).								        //add the goal to answer other restaurants

+!answerRestaurants(_,[],_).	   												//all restaurants have been warned

//restaurant has confirmed the order and it's preparing the food
+inform_preparing(OrderId)[source(A)]
	:   placedOrders(PO)														//given the number of placed orders
	<- //.print("[",A,"] is preparing the Order: ", OrderId, ".");				//
	   -+placedOrders(PO+1).													//update placed orders

//restaurant has confirmed the cancellation of the order
+inform_cancel(OrderId)[source(A)]												
    <- //.print("[",A,"] has confirmed the cancel of Order: ", OrderId, ".");	//
	   -inform_cancel(OrderId)[source(W)].										//clear memory

//delivery man delivered the food
+orderDelivered(OrderId, Restaurant)[source(DM)]
	:  finishedOrders(FO)														//given the number of finished orders
	<- .print("[",Restaurant,"][",DM,"] I received the Order: ", OrderId, " from ", Restaurant, ".");//
	   -+finishedOrders(FO+1);													//update finished orders
	   +received(OrderId, Restaurant);											//add belief this order has been received
	   .abolish(inform_preparing(OrderId));										//clear memory
	   .abolish(waiting(OrderId,_));											//clear memory
	   .abolish(orderDelivered(OrderId,_));										//clear memory
	   .abolish(wantToEat(OrderId));											//clear memory
	   .abolish(choose(OrderId,_));												//clear memory
	   !rate(OrderId, Restaurant).												//add the goal to rate the restaurant

//rating the restaurant
+!rate(OrderId, Restaurant)
	:  .random(R) &																//random R
	   Star = math.ceil(R*5)													// 1 <= Star <= 5
	<- //.print("[",Restaurant,"] Rating ",Restaurant," with ",Star," stars.").	//
	   .send(Restaurant, tell, avaliation(Star)).								//rate the restaurant	
	   

//all the orders have finished
+placedOrders(PO)
	:  nOrders(NO) &															//given number of orders
	   PO = NO	&																//if number of placed orders is equal to the number of orders
	   .random(R)
	<- .print(" ---------------------------- Placed all my orders ---------------------------- "); //
		+allOrdersPlaced
	   .wait(10*R);																//wait
	   .send("controller", tell, allOrdersPlaced).										//tell controller all orders were placed
	   
//all the orders have finished
+finishedOrders(FO)
	:  nOrders(NO) &															//given number of orders
	   FO = NO	&																//if number of finished orders is equal to the number of orders
	   .random(R)
	<- .print(" ---------------------------- Received all my orders ---------------------------- "); //
		+allOrdersReceived
	   .wait(10*R)																	//wait
	   .send("controller", tell, allOrdersReceived).										//tell controller all orders were received
