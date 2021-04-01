package agents;

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import java.util.Random;
import java.lang.*;
import java.util.Arrays;

public class Restaurant extends Agent {
    private int myNumber = -1;
    Foods myFood; 
    private int price = 0;
    private int jobs = 0;
    private int money = 0;
    public int X = 0;
    public int Y = 0;
    public int R = 0;
    
    @Override
    protected void setup() {
        // gets the argument
        Object[] args = getArguments();
        myNumber = Integer.valueOf(args[0].toString());
        myFood = new Foods();
        X = this.getLocation();
        Y = this.getLocation();
        R = this.getRadius();
        System.out.println("[restaurant"+myNumber+"] Hello, I am restaurant and I serve " + myFood.getFood() + "\n\t\t. I am located in " + X + ", " + Y + ".\n\t\tMy delivery radius is " + R + "m.");                

        // Register the restaurant service in the yellow pages
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType(myFood.getFood());
        sd.setName("restaurant" + myNumber);
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }

        // Add the behaviour for evaluating clients agents
        addBehaviour(new OfferRequestsServer());

        // Add the behaviour for serving clients agents
        addBehaviour(new PurchaseOrdersServer());
    }

    protected void takeDown() {
        // Printout a dismissal message
        System.out.println("[restaurant"+myNumber+"] terminating.");
    }

    private int getLocation(){
        Random rand = new Random();
        return (int)(100 * rand.nextFloat()); 
    }

    private int getRadius(){
        Random rand = new Random();
        return (30 + (int)(30 * rand.nextFloat())); 
    }
    /**
       Inner class OfferRequestsServer.
       This is the behaviour used by Restaurant agents to serve incoming requests 
       for offer from Client agents.
       If the requested function is the offered by this restaurant, agent replies 
       with a PROPOSE message specifying the price. Otherwise a REFUSE message is
       sent back.
  */
    private class OfferRequestsServer extends CyclicBehaviour {
        public void action(){          
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);
            ACLMessage msg = myAgent.receive(mt);

            if(msg != null){
                // CFP Message received. Process it
                String req = msg.getContent();
                String[] splitArray = req.split("\\.");
                String reqMsg = splitArray[0];
                int clientX = Integer.valueOf(splitArray[1]);
                int clientY = Integer.valueOf(splitArray[2]);
                ACLMessage reply = msg.createReply();
                int distance = Math.abs(X - clientX) + Math.abs(Y - clientY);               
                
                //Verify if the required service is the Function of this Restaurant
                if(reqMsg.equals("I would like to order a " + myFood.getFood())){
                    //Verify if this restaurant is available
                    if(distance < R){
                        reply.setPerformative(ACLMessage.PROPOSE);
                        price = myFood.getPrice();
                        reply.setContent(String.valueOf(price));
                    } else {
                        // The requested restaurant is NOT available.
                        reply.setPerformative(ACLMessage.REFUSE);
                        reply.setContent("Too far");
                    }
                }
                else{
                    // The requested function not available for this restaurant.
                    reply.setPerformative(ACLMessage.REFUSE);
                    reply.setContent("not-myFood");
                }
                myAgent.send(reply);
            } 
            else {
                block();
            }
        }
    }  // End of inner class OfferRequestsServer
    

    private class PurchaseOrdersServer extends CyclicBehaviour {
        public void action() {
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.ACCEPT_PROPOSAL);
            ACLMessage msg = myAgent.receive(mt);
            
            if (msg != null) {
                // ACCEPT_PROPOSAL Message received. Process it
                String req = msg.getContent();
                ACLMessage reply = msg.createReply();

                //Verify if the required service is the Function of this Restaurant
                //if(req.equals("I would like to order a " + myFood.getFood())){
                reply.setPerformative(ACLMessage.INFORM);
                reply.setContent("preparing");
                    // Add the behaviour for agent working
                jobs++;
                money += price;
                System.out.println("[restaurant"+myNumber+"] \tPreparing order for " + msg.getSender().getName());
                //}
                //else{
                    // The requested action is not the Workers function
                //reply.setPerformative(ACLMessage.FAILURE);
                //reply.setContent("not-myFood");
                //}
                myAgent.send(reply);
            } else {
                block();
            }
        }
    }   // End of inner class OfferRequestsServer



}
