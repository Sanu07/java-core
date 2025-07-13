package test.ticketingsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Client {

    public static void main(String[] args) {

        TicketingSystem ticketingSystem = new TicketingSystem();
        List<Agent> list = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Agent agent = new Agent(UUID.randomUUID().toString(), "AGENT-" + i);
            ticketingSystem.addAgents(agent);
            list.add(agent);
        }

        for (int i = 1; i <= 20; i++) {
            Customer customer = new Customer("C-" + 1);
            ticketingSystem.addCustomer(customer);
            int agentNum = new Random().nextInt(0, 5);
            int rating = new Random().nextInt(0, 5) + 1;
            System.out.println("Agent " + agentNum + " --- Rating ----> " + rating);
            ticketingSystem.rateAgent(customer.getId(), list.get(agentNum).getId(), rating);
        }

        System.out.println(ticketingSystem.getAgentRatings());

    }
}
