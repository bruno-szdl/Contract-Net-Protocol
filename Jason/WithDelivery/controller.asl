{ include("settings.asl") }

/* ----------------- Initial Beliefs ----------------- */

cnp1(false).
cnp2(false).

/* ----------------- Rules ----------------- */

allClientsWaiting(NC) :- .count(allOrdersPlaced[source(_)], NF) &								//all clients placed the orders if NC = NF
						  NC = NF.

allClientsFinished(NC) :- .count(allOrdersReceived[source(_)], NF) &								//all clients finished the orders if NC = NF
						  NC = NF.
						  
 
/* ----------------- Initial Goals ----------------- */
!checkAllClientsWaiting.


/* ----------------- Plans ----------------- */


//client tells that all his orders were placed
+allOrdersPlaced[source(A)] 
	<-  .count(allOrdersPlaced[source(_)], N);  
	   .print(A," placed all its orders. [", N, "]").   
	   
//client tells that all his orders were received
+allOrdersReceived[source(A)] 
	<- .count(allOrdersReceived[source(_)], N);  
	   .print(A," received all its orders. [", N, "]").

//if all clients are waiting for their orders
+!checkAllClientsWaiting
	: nClients(NC) &															//given number of clients
	  allClientsWaiting(NC)														//if all clients are waiting for their orders
	<- .print(" ------------------------ CNP 1 COMPLETED ------------------------ ");
	   -+cnp1(true);
	   !checkAllClientsFinished.
	
//if not
+!checkAllClientsWaiting 
	: cnp1(false)
	<- .wait(10);
	   !checkAllClientsWaiting.

//if all clients are waiting for their orders
+!checkAllClientsFinished
	: nClients(NC) &															//given number of clients
	  allClientsFinished(NC)													//if all clients are waiting for their orders
	<- .print(" ------------------------ CNP 2 COMPLETED ------------------------ ");
	   -+cnp2(true);
	   .stopMAS.
	
//if not
+!checkAllClientsFinished 
	: cnp2(false)
	<- .wait(10);
	   !checkAllClientsFinished.
	

