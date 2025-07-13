package test.ticketingsystem;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TicketingSystem {

    private final Map<String, Customer> customers;
    private final Map<String, Agent> agents;
    private final Map<String, List<AgentRatings>> agentRatingsMap;

    public TicketingSystem() {
        this.customers = new ConcurrentHashMap<>();
        this.agents = new ConcurrentHashMap<>();
        this.agentRatingsMap = new ConcurrentHashMap<>();
    }

    public void addCustomer(Customer customer) {
        String customerId = UUID.randomUUID().toString();
        customer.setId(customerId);
        this.customers.put(customerId, customer);
    }

    public void addAgents(Agent agent) {
        this.agents.put(agent.getId(), agent);
        agentRatingsMap.put(agent.getId(), new ArrayList<>());
    }

    public void rateAgent(String customerId, String agentId, int score) {
        AgentRatings agentRatings = new AgentRatings(customerId, agentId, score);
        this.agentRatingsMap.get(agentId).add(agentRatings);
    }

    public Map<String, Float> getAgentRatings() {
        Map<String, Float> agentRecordsAvg = new HashMap<>();
        // O(5N) * N
        for (Map.Entry<String, List<AgentRatings>> map: this.agentRatingsMap.entrySet()) {
            String agentId = map.getKey();
            List<AgentRatings> agentRatings = map.getValue();
            int sum = agentRatings.stream().mapToInt(agent -> agent.getRating()).sum();
            float avg = (float) sum / agentRatings.size();
            agentRecordsAvg.put(map.getKey(), avg);
        }
        // O(nlogN)
        return agentRecordsAvg.entrySet()
                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

}
