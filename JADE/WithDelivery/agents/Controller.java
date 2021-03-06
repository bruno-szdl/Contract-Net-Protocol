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
import jade.wrapper.ContainerController;

public class Controller extends Agent {
    ContainerController cc;
    private int nClients = 1;
    private int nOrders = 0;
    private int nTotalOrders = 0;
    private int allOrdersPlaced = 0;
    private int allOrdersFinished = 0;
    private int n;

    @Override
    protected void setup() {
        // gets the argument
        Object[] args = getArguments();
        cc = (ContainerController)args[0];
        nOrders = Integer.valueOf(args[1].toString());
        
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sdv = new ServiceDescription();
        sdv.setType("controller");
        sdv.setName("controller");
        dfd.addServices(sdv);
        try {
            DFService.register(this, dfd);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }


        System.out.println("[controller] Hello, I am the controller");
        try{
            Thread.sleep(2000);
        } catch(Exception e){
            System.out.println("[controller] sleep error");
        }
        DFAgentDescription template = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        sd.setType("client");
        template.addServices(sd);

        DFAgentDescription template_delivery = new DFAgentDescription();
        ServiceDescription sd_delivery = new ServiceDescription();
        sd_delivery.setType("deliveryman");
        template_delivery.addServices(sd_delivery);
        template_delivery.addServices(sd);

        

        

        try{
            DFAgentDescription[] result = DFService.search(this, template);
            nClients = result.length;
            nTotalOrders = nClients*nOrders;
            System.out.println("[controller] Total orders: "+nTotalOrders);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        } 
    
        MessageTemplate mt = MessageTemplate.MatchConversationId("END");
        MessageTemplate mt_delivery = MessageTemplate.MatchConversationId("END_delivery");

        addBehaviour(new OneShotBehaviour() {
            public void action() {
                while(allOrdersPlaced < nClients){

                    try{
                        Thread.sleep(100);
                    } catch(Exception e){
                        System.out.println("[controller] sleep error");
                    }

                    try{
                        DFAgentDescription[] result = DFService.search(myAgent, template);  
                        nClients = result.length;   
                    } catch (FIPAException fe) {
                        fe.printStackTrace();
                    } 
                    
                    ACLMessage reply = myAgent.receive(mt);

                    if (reply != null) {
                        allOrdersPlaced++;
                        System.out.println("[controller] placed orders: "+allOrdersPlaced);
                    } else {
                        block();
                    }                                    
                }
                
                System.out.println("\n------------------------------ CNP1 ------------------------------\n");

                // try{
                //     Thread.sleep(100);
                // } catch(Exception e){
                //     System.out.println("[controller] sleep error");
                // }
                
                
                while(allOrdersFinished < nTotalOrders){

                    try{
                        Thread.sleep(100);
                    } catch(Exception e){
                        System.out.println("[controller] sleep error");
                    }

                    try{
                        DFAgentDescription[] result_delivery = DFService.search(myAgent, template_delivery);           
                    } catch (FIPAException fe) {
                        fe.printStackTrace();
                    } 

                    
                    ACLMessage reply_delivery = myAgent.receive(mt_delivery);
                    String req = reply_delivery.getContent();

                    if (reply_delivery != null) {
                        allOrdersFinished++;
                        System.out.println("[controller] finished orders: "+allOrdersFinished);
                        System.out.println("Received Smoething " + reply_delivery.getContent() + reply_delivery.getSender());
                    } else {
                        block();
                    }                                    
                }

                System.out.println("\n------------------------------ CNP2 ------------------------------\n");

                for(int i = 0; i < Foods.nFoods(); i++){
                    sd.setType(Foods.num2food(i));
                    template.addServices(sd);
                    try{
                        DFAgentDescription[] result = DFService.search(myAgent, template);  
                        n = result.length;                  
                    } catch (FIPAException fe) {
                        fe.printStackTrace();
                    } 
                    System.out.println("Quantity of " + Foods.num2food(i) + " restaurants: " + n);
                }
                try{
                    cc.getPlatformController().kill();
                }catch(Exception e){
                    System.out.println("[controller] sleep error");
                }
                
                
            }
        });
    }

    protected void takeDown() {
        System.out.println("[controller] terminating.");
    }
}
