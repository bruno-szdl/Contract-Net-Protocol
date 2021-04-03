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
    private double rate = 5.0;
    private int jobs = 0;
    private int money = 0;
    public int X = 0;
    public int Y = 0;
    public int R = 0;

    enum Steps{
        START,
        CFP,
        OFFERS,
        ANSWER,
        CONFIRMATION,
        END
      }
    
    @Override
    protected void setup() {
        Object[] args = getArguments();
        myNumber = Integer.valueOf(args[0].toString());
        myFood = new Foods();
        price = myFood.getPrice();
        X = getLocation();
        Y = getLocation();
        R = getRadius();
        System.out.println("[restaurant"+myNumber+"] Hello, I am restaurant and I serve " + myFood.getFood() + "\n\t\t. I am located in " + X + ", " + Y + ".\n\t\tMy delivery radius is " + R + "m.");                

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

        addBehaviour(new OfferRequestsServer());

        addBehaviour(new PurchaseOrdersServer());

    }

    protected void takeDown() {
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

    private class OfferRequestsServer extends CyclicBehaviour {
        public void action(){          
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);
            ACLMessage msg = myAgent.receive(mt);

            if(msg != null){
                String req = msg.getContent();
                String[] splitArray = req.split("\\.");
                String reqMsg = splitArray[0];
                int clientX = Integer.valueOf(splitArray[1]);
                int clientY = Integer.valueOf(splitArray[2]);
                ACLMessage reply = msg.createReply();
                int distance = Math.abs(X - clientX) + Math.abs(Y - clientY);               
                if(distance < R){
                    if(reqMsg.equals("I would like to order a " + myFood.getFood() + "by price")){
                    
                        reply.setPerformative(ACLMessage.PROPOSE);
                        reply.setContent(String.valueOf(price));
                        //System.out.println("[restaurant"+myNumber+"] Proposing "+price+"$ for " + msg.getSender().getName());
                    } 
                    else if(reqMsg.equals("I would like to order a " + myFood.getFood() + "by rate")){
                        reply.setPerformative(ACLMessage.PROPOSE);
                        reply.setContent(String.valueOf(rate));
                        //System.out.println("[restaurant"+myNumber+"] Proposing "+price+"$ for " + msg.getSender().getName());
                    }
                    else{
                        reply.setPerformative(ACLMessage.REFUSE);
                        reply.setContent("not-myFood");
                    }
                }
                else {
                    reply.setPerformative(ACLMessage.REFUSE);
                    reply.setContent("Too far");
                    //System.out.println("[restaurant"+myNumber+"] Refusing "+ msg.getSender().getName()+ "cause he is too far");
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
                int clientX = Integer.valueOf(splitArray[1]);
                int clientY = Integer.valueOf(splitArray[2]);
                ACLMessage reply = msg.createReply();
                reply.setPerformative(ACLMessage.INFORM);
                reply.setContent("preparing");
                jobs++;
                money += price;
                System.out.println("[restaurant"+myNumber+"] Preparing "+myFood.getFood()+" for " + msg.getSender().getName());
                Random rand = new Random();
                int newStar =(int)(5 * rand.nextFloat());
                rate = (newStar + rate*(jobs+1))/(jobs+2);
                myAgent.send(reply);
                addBehaviour(new RequestDeliveryMan(clientX, clientY, msg.getSender().getName()));

            } else {
                block();
            }
        }
    }   // End of inner class OfferRequestsServer

    //-------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------
    
    private class RequestDeliveryMan extends Behaviour {  
        private MessageTemplate mt;     // The template to receive replies
        private AID closestDeliveryMan;         // The agent who provides the best offer
        private AID[] deliveryMenAgents;     // Possible workers to be contracted
        private double closestDistance;          // The best offered price
        private int repliesCnt = 0;     // The counter of replies from seller agents
        private Steps step = Steps.START;
        private AID controller;
        private int clientX_d;
        private int clientY_d;
        private String clientName;
        
        //Constructor to define Workers that are capable to do the desired need
        RequestDeliveryMan(int clientx, int clienty, String clientname){
            this.clientX_d = clientx;
            this.clientY_d = clienty;
            this.clientName = clientname;
        }

        public void action() {   
            switch (step) {
            case START:
                DFAgentDescription template = new DFAgentDescription();
                ServiceDescription sd = new ServiceDescription();
                sd.setType("deliveryman");
                template.addServices(sd);

                try {
                    DFAgentDescription[] result = DFService.search(myAgent, template); 
                    if(result.length > 0){
                        deliveryMenAgents = new AID[result.length];
                        for (int i = 0; i < result.length; ++i) {
                            deliveryMenAgents[i] = result[i].getName();
                        }   
                        step = Steps.CFP;                         
                    }
                    else{
                       // System.out.println("[restaurant"+myNumber+"] No deliveryman found.");
                        try{
                            step = Steps.END;
                        } catch(Exception e){
                        } 
                    }
                    
                } catch (FIPAException fe) {
                    fe.printStackTrace();
                } 
                break;

            case CFP:     
                ACLMessage cfp = new ACLMessage(ACLMessage.CFP);
                
                for (int i = 0; i < deliveryMenAgents.length; ++i) {
                    cfp.addReceiver(deliveryMenAgents[i]);
                } 
                cfp.setContent("Need you." + X + "." + Y);
                cfp.setConversationId("contract");
                cfp.setReplyWith("cfp" + System.currentTimeMillis()); // Unique value
                myAgent.send(cfp);
                //System.out.println("[restaurant"+myNumber+"] Sending CFP...");
                
                mt = MessageTemplate.and(MessageTemplate.MatchConversationId("contract"),
                                        MessageTemplate.MatchInReplyTo(cfp.getReplyWith()));
                step = Steps.OFFERS;
                break;

            case OFFERS:
                ACLMessage reply = myAgent.receive(mt);

                if (reply != null) {
                    if (reply.getPerformative() == ACLMessage.PROPOSE) {
                        
                        double distance = Double.parseDouble(reply.getContent());
                        if (closestDeliveryMan == null || distance < closestDistance) {
                            closestDistance = distance;
                            closestDeliveryMan = reply.getSender();
                        }
                    }
                    repliesCnt++;
                    if (repliesCnt >= deliveryMenAgents.length) {
                        step = Steps.ANSWER; 
                    }
                } else {
                    block();
                }
                break;

            case ANSWER:                
                ACLMessage order = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
                order.addReceiver(closestDeliveryMan);
                order.setContent("Need you." + X + "." + Y + "." + this.clientX_d + "." + this.clientY_d);
                order.setConversationId("contract");
                order.setReplyWith("order" + System.currentTimeMillis());
                myAgent.send(order);
                
                // Prepare the template to get the purchase order reply
                mt = MessageTemplate.and(MessageTemplate.MatchConversationId("contract"),
                                        MessageTemplate.MatchInReplyTo(order.getReplyWith()));
                step = Steps.CONFIRMATION;
                break;

            case CONFIRMATION:      
                reply = myAgent.receive(mt);
                if (reply != null) {
                    if (reply.getPerformative() == ACLMessage.INFORM) {
                        //System.out.println("[restaurant"+myNumber+"] "+ reply.getSender().getName()+ " is delivering a "  + myFood.getFood() + " to " + this.clientName);
                    } else {
                        try{
                            Thread.sleep(100);
                        } catch(Exception e){
                            System.out.println("[controller] sleep error");
                        }
                        myAgent.addBehaviour(new RequestDeliveryMan(this.clientX_d, this.clientY_d, this.clientName));
                    }
                    step=Steps.END;
                } else {
                    block();
                }
                break;  
            }              
        }

        public boolean done() {
            if(step == Steps.START){
                //End intention
                try{
                    System.out.println("[restaurant"+myNumber+"] Error - No deliveryMan");
                    myAgent.removeBehaviour(this);  
                }catch(NullPointerException ex){
                    System.out.println("!!!!! Error removing intention !!!!!");
                }
            }
            
            if (step == Steps.ANSWER && closestDeliveryMan == null) {
                //restart intention
                try{
                    //System.out.println("[restaurant"+myNumber+"] No delivery man available, trying again...");
                    try{
                        Thread.sleep(500);
                    } catch(Exception e){
                        System.out.println("[restaurant] sleep error");
                        Thread.currentThread().interrupt();
                    }
                    myAgent.addBehaviour(new RequestDeliveryMan(this.clientX_d, this.clientY_d, this.clientName));
                    myAgent.removeBehaviour(this);  
                }catch(NullPointerException ex){
                    System.out.println("!!!!! Error restarting intention !!!!!");
                }
                           
            }
            else if(step == Steps.END){
                try{
                    myAgent.removeBehaviour(this);
                }catch(NullPointerException ex){
                    System.out.println("!!!!! Error removing intention !!!!!");
                }
                
            }   
            return ((step == Steps.ANSWER && closestDeliveryMan == null) || step == Steps.END); 
        }
    }  // End of inner class RequestDeliveryMan

}
