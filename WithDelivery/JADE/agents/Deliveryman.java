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

public class Deliveryman extends Agent {
    private int myNumber = -1;
    private Boolean working = false;
    private int jobs = 0;
    private int money = 0;
    private int X;
    private int Y;
    
    @Override
    protected void setup() {
        Object[] args = getArguments();
        myNumber = Integer.valueOf(args[0].toString());
        X = getLocation();
        Y = getLocation();
        System.out.println("[deliveryman"+myNumber+"] I am a delivery man");                

        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("deliveryman");
        sd.setName("deliveryman" + myNumber);
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }

        addBehaviour(new OfferRequestsServer());

        addBehaviour(new PurchaseOrdersServer());
    }

    protected void takeDown() {
        System.out.println("[deliveryman"+myNumber+"] terminating.");
    }

    private int getLocation(){
        Random rand = new Random();
        return (int)(100 * rand.nextFloat()); 
    }

    private class OfferRequestsServer extends CyclicBehaviour {
        public void action(){          
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);
            ACLMessage msg = myAgent.receive(mt);

            if(msg != null){
                String req = msg.getContent();
                String[] splitArray = req.split("\\.");
                String reqMsg = splitArray[0];
                int restaurantX = Integer.valueOf(splitArray[1]);
                int restaurantY = Integer.valueOf(splitArray[2]);
                ACLMessage reply = msg.createReply();
                int distance = Math.abs(X - restaurantX) + Math.abs(Y - restaurantY);               
                
                if(reqMsg.equals("Need you")){
                    
                    if(!working){
                        reply.setPerformative(ACLMessage.PROPOSE);
                        reply.setContent(String.valueOf(distance));
                    } else {
                        reply.setPerformative(ACLMessage.REFUSE);
                        reply.setContent("not-available");
                        System.out.println("[deliveryman"+myNumber+"] Not available");
                    }
                }
                else{
                    System.out.println("ERROR Restaurant get deliveryman");
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
                String req = msg.getContent();
                String[] splitArray = req.split("\\.");
                String reqMsg = splitArray[0];
                int restaurantX = Integer.valueOf(splitArray[1]);
                int restaurantY = Integer.valueOf(splitArray[2]);
                int clientX = Integer.valueOf(splitArray[3]);
                int clientY = Integer.valueOf(splitArray[4]);
                ACLMessage reply = msg.createReply();
                int distance_restaurant = Math.abs(X - restaurantX) + Math.abs(Y - restaurantY);               
                int distance_client = Math.abs(restaurantX - clientX) + Math.abs(restaurantY - clientY);               

                if(reqMsg.equals("Need you")){
                    if(!working){
                        reply.setPerformative(ACLMessage.INFORM);
                        
                        working = true;
                        jobs++;
                        money += distance_client/5;
                        myAgent.addBehaviour(new agentWorking(distance_restaurant + distance_client));
                        System.out.println("[deliveryman"+myNumber+"] Delivering for: " + msg.getSender().getName());
                    } 
                    else{
                        reply.setPerformative(ACLMessage.FAILURE);
                        reply.setContent("not-available");
                        System.out.println("[deliveryman"+myNumber+"] Not available anymore");

                    }
                    myAgent.send(reply);
                }
            } else {
                block();
            }
        }
    }   // End of inner class OfferRequestsServer

    /**
       Inner class agentWorking.
       This is the behaviour used by Worker agents to simulate an 
       service being done.
  */

    private class agentWorking extends CyclicBehaviour {
        private int cont=0;
        private int time;
        private AID controller;


        agentWorking(int t){
            this.time = t*10;
            System.out.println("[deliveryman"+myNumber+"] working time: " + t);
        }

        public void action(){
            try{
                Thread.sleep(10);
                cont++;
            } catch(Exception e){
                System.out.println("[deliveryman"+myNumber+"] Error in 'sleep'.");
            }   
            if (cont>=this.time){
                working = false;
                System.out.println("[deliveryman"+myNumber+"] Finished delivery");

                ACLMessage msg = new ACLMessage(ACLMessage.CFP);

                DFAgentDescription template = new DFAgentDescription();
                ServiceDescription sd = new ServiceDescription();
                sd.setType("controller");
                template.addServices(sd);

                try{
                    DFAgentDescription[] result = DFService.search(myAgent, template);
                    controller = result[0].getName();
                } catch (FIPAException fe) {
                    fe.printStackTrace();
                } 

                msg.addReceiver(controller);
                msg.setContent("Ending_delivery");
                msg.setConversationId("END_delivery");
                try { Thread.sleep (10); } catch (InterruptedException ex) {}
                myAgent.send(msg);
                System.out.println("[deliveryman"+myNumber+"] I did this number of deliveries:" + jobs);
                myAgent.removeBehaviour(this);

            }   
        } 

    }// End of inner class agentWorking 

}