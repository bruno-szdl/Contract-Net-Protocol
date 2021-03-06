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
    private int nClients = 0;
    private int n;

    @Override
    protected void setup() {
        // gets the argument
        Set<String> placedClientsSet = new HashSet<String>();
        Object[] args = getArguments();
        cc = (ContainerController)args[0];
        
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
            Thread.sleep(100);
        } catch(Exception e){
            System.out.println("[controller] sleep error");
        }
        DFAgentDescription template = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        sd.setType("client");
        template.addServices(sd);

        try{
            DFAgentDescription[] result = DFService.search(this, template);
            nClients = result.length;
        } catch (FIPAException fe) {
            fe.printStackTrace();
        } 
    
        MessageTemplate mt = MessageTemplate.MatchConversationId("END");

        addBehaviour(new OneShotBehaviour() {
            public void action() {
                while(placedClientsSet.size() < nClients){

                    try{
                        Thread.sleep(1);
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
                        placedClientsSet.add(reply.getContent());
                    } else {
                        block();
                    }                                    
                }

                try{
                    Thread.sleep(1);
                } catch(Exception e){
                    System.out.println("[controller] sleep error");
                }
                
                System.out.println("\n------------------------------ CNP1 ------------------------------\n");
                
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
