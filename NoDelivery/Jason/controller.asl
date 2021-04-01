{ include("settings.asl") }

/* ----------------- Initial Beliefs ----------------- */

cnp1(false).

/* ----------------- Rules ----------------- */

allClientsWaiting(NC) :- .count(allOrdersPlaced[source(_)], NF) &								//all clients placed the orders if NC = NF
						  NC = NF.
 
/* ----------------- Initial Goals ----------------- */
!checkAllClientsWaiting. 													


/* ----------------- Plans ----------------- */

//client tells that all his orders were placed
+allOrdersPlaced[source(A)] 
	<-  .print(A," placed all its orders.").
	   
//if all clients are waiting for their orders
+!checkAllClientsWaiting
	: nClients(NC) &															//given number of clients
	  allClientsWaiting(NC)														//if all clients are waiting for their orders
	<- .print(" ------------------------ CNP 1 COMPLETED ------------------------ ");
	   -+cnp1(true).
	   //.stopMAS.
	
//if not
+!checkAllClientsWaiting 
	: cnp1(false)
	<- .wait(10);
	   !checkAllClientsWaiting.
	

