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


enum Steps{
    START,
    CFP,
    OFFERS,
    ANSWER,
    CONFIRMATION,
    END
  }

public class Client extends Agent {
    private int myNumber = -1;
    private int nCNPs = 3;          
    private int nContracts = 0;
    public int X = 0;
    public int Y = 0;
    public int strategy = 1;

    @Override
    protected void setup() {
        // gets the argument
        Set<String> placedOrdersSet = new HashSet<String>();
        Object[] args = getArguments();
        myNumber = Integer.valueOf(args[0].toString());
        nCNPs = Integer.valueOf(args[1].toString());
        X = getLocation();
        Y = getLocation();
        System.out.println("[client"+myNumber+"] Hello, I am a client.\n\t  I live in (" + X + ", " + Y +").");

        // Register the client service in the yellow pages
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("client");
        sd.setName("client" + myNumber);
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }

        // create a simple behavior 
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                while(nContracts < nCNPs){
      
                    Foods f = new Foods();
                    String wantToEat = f.getFood();    
                                        
                    System.out.println("[client"+myNumber+"][Order"+nContracts+"] I want to eat "+ wantToEat + ".\n\t\t  Searching " + wantToEat + " restaurants...");
                    
                    myAgent.addBehaviour(new RequestRestaurant(nContracts, wantToEat));
                    nContracts++;                                              
                } 
                
            }
        });
        //doDelete();
    }

    protected void takeDown() {
        // Printout a dismissal message
        System.out.println("[client"+myNumber+"] terminating.");
    }

    private int getLocation(){
        Random rand = new Random();
        return (int)((100) * rand.nextFloat()); 
    }


    private class RequestRestaurant extends Behaviour {  
        private MessageTemplate mt;     
        private AID chosenRestaurant;
        private AID[] possibleRestaurants;
        private String wantToEat;
        private int lowerPrice;
        private double higherRate;
        private int repliesCnt = 0;
        private Steps step = Steps.START;
        private int OrderId;
        private AID controller;
        private boolean notFound = false;
        
        //Constructor to define Workers that are capable to do the desired need
        RequestRestaurant(int CNP, String foodName){
            this.OrderId = CNP;
            wantToEat = foodName;
        }

        public void action() {   
            switch (step) {
            case START:
                // Update the list of worker agents that do the required service
                DFAgentDescription template = new DFAgentDescription();
                ServiceDescription sd = new ServiceDescription();
                sd.setType(wantToEat);
                template.addServices(sd);

                try {
                    DFAgentDescription[] result = DFService.search(myAgent, template); 
                    if(result.length > 0){
                        //System.out.println("[client"+myNumber+"][Order"+OrderId+"] Found the following "+wantToEat+" restaurants:");
                        possibleRestaurants = new AID[result.length];
                        for (int i = 0; i < result.length; ++i) {
                            possibleRestaurants[i] = result[i].getName();
                            //System.out.println("\t\t  -> " + possibleRestaurants[i].getName());
                        }   
                        step = Steps.CFP;                         
                    }
                    else{
                        //System.out.println("[client"+myNumber+"][Order"+OrderId+"] No " + wantToEat +" restaurants found.");
                        this.notFound = true;
                    }
                    
                } catch (FIPAException fe) {
                    fe.printStackTrace();
                } 
                break;
            case CFP:     
                // Send the cfp to all sellers
                ACLMessage cfp = new ACLMessage(ACLMessage.CFP);
                
                //Insert all intended workers to receive the message
                for (int i = 0; i < possibleRestaurants.length; ++i) {
                    cfp.addReceiver(possibleRestaurants[i]);
                } 
                if(strategy == 0){
                    cfp.setContent("I would like to order a " + wantToEat + "by price." + X + "." + Y);
                } else{
                    cfp.setContent("I would like to order a " + wantToEat + "by rate." + X + "." + Y);
                }
                cfp.setConversationId("contract");
                cfp.setReplyWith("cfp" + System.currentTimeMillis());
                myAgent.send(cfp);
                //System.out.println("[client"+myNumber+"][Order"+OrderId+"] Sending CFP...");
                mt = MessageTemplate.and(MessageTemplate.MatchConversationId("contract"),
                                        MessageTemplate.MatchInReplyTo(cfp.getReplyWith()));
                step = Steps.OFFERS;
                break;

            case OFFERS:
                ACLMessage reply = myAgent.receive(mt);

                if (reply != null) {
                    if (reply.getPerformative() == ACLMessage.PROPOSE) {
                        if (strategy == 0){
                            int price = Integer.parseInt(reply.getContent());
                            if (chosenRestaurant == null || price < lowerPrice) {
                                lowerPrice = price;
                                chosenRestaurant = reply.getSender();
                            }
                        } else{
                            double rate = Double.parseDouble(reply.getContent());
                            if (chosenRestaurant == null || higherRate < rate) {
                                higherRate = rate;
                                chosenRestaurant = reply.getSender();
                            }
                        }
                    }
                    repliesCnt++;
                    if (repliesCnt >= possibleRestaurants.length) {
                        step = Steps.ANSWER; 
                    }
                } else {
                    block();
                }
                break;
                
            case ANSWER:                
                // Send the purchase order to the seller that provided the best offer
                ACLMessage order = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
                order.addReceiver(chosenRestaurant);
                order.setContent("I would like to order a " + wantToEat);
                order.setConversationId("contract");
                order.setReplyWith("order" + System.currentTimeMillis());
                myAgent.send(order);
                //System.out.println("[client"+myNumber+"][Order"+OrderId+"] Ordering " +wantToEat+ " from " +chosenRestaurant+".");
                // Prepare the template to get the purchase order reply
                mt = MessageTemplate.and(MessageTemplate.MatchConversationId("contract"),
                                        MessageTemplate.MatchInReplyTo(order.getReplyWith()));
                step = Steps.CONFIRMATION;
                break;
            
            case CONFIRMATION:      
                reply = myAgent.receive(mt);
                if (reply != null) {
                    if (reply.getPerformative() == ACLMessage.INFORM) {
                        if (strategy == 0){
                           // System.out.println("[client"+myNumber+"][Order"+OrderId+"] Successfully ordered a " + wantToEat + " from " + reply.getSender().getName() + "for " + lowerPrice + "$\n");
                        } else {
                            //System.out.println("[client"+myNumber+"][Order"+OrderId+"] Successfully ordered a " + wantToEat + " from " + reply.getSender().getName() + "with " + higherRate + " Stars\n"); 
                        }
                    }else {
                        System.out.println("Failure");
                    }
                    step=Steps.END;
                } else {
                    block();
                }
                break;  
            }              
        }

        public boolean done() {
            if((step == Steps.START && this.notFound) || (step == Steps.ANSWER && chosenRestaurant == null)){
                try{
                    placedOrdersSet.add(OrderId);
                    if(placedOrdersSet.size() == nCNPs){
    
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
                        msg.setContent("Ending");
                        msg.setConversationId("END");
                        myAgent.send(msg);
                    }
                    if(step ==Steps.START){
                        System.out.println("[client"+myNumber+"][Order"+OrderId+"] Could not find a " + wantToEat + " Restaurant");
                    } else {
                        System.out.println("[client"+myNumber+"][Order"+OrderId+"] Could not find a " + wantToEat + " Restaurant nearby");
                    }
                    myAgent.removeBehaviour(this);  
                }catch(NullPointerException ex){
                    System.out.println("!!!!! Error removing intention !!!!!");
                }
            }

            else if(step == Steps.END){
                try{
                    placedOrdersSet.add(OrderId);
                    if(placedOrdersSet.size() == nCNPs){
    
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
                        msg.setContent(OrderId);
                        msg.setConversationId("END");
                        myAgent.send(msg);
                    }
                    myAgent.removeBehaviour(this);
                }catch(NullPointerException ex){
                    System.out.println("!!!!! Error removing intention !!!!!");
                }
                
            }   
            return ((step == Steps.ANSWER && chosenRestaurant == null) || step == Steps.END); 
        }
    }  // End of inner class RequestPerformer
}
