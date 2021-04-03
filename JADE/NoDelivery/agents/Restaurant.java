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
    
    @Override
    protected void setup() {
        Object[] args = getArguments();
        myNumber = Integer.valueOf(args[0].toString());
        myFood = new Foods();
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
                        price = myFood.getPrice();
                        reply.setContent(String.valueOf(price));
                        System.out.println("[restaurant"+myNumber+"] Proposing "+price+"$ for " + msg.getSender().getName());
                    } 
                    else if(reqMsg.equals("I would like to order a " + myFood.getFood() + "by rate")){
                        reply.setPerformative(ACLMessage.PROPOSE);
                        reply.setContent(String.valueOf(rate));
                        System.out.println("[restaurant"+myNumber+"] Proposing "+price+"$ for " + msg.getSender().getName());
                    }
                    else{
                        reply.setPerformative(ACLMessage.REFUSE);
                        reply.setContent("not-myFood");
                    }
                }
                else {
                    reply.setPerformative(ACLMessage.REFUSE);
                    reply.setContent("Too far");
                    System.out.println("[restaurant"+myNumber+"] Refusing "+ msg.getSender().getName()+ "cause he is too far");
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
            } else {
                block();
            }
        }
    }   // End of inner class OfferRequestsServer



}
