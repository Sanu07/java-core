package test.ticketingsystem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AgentRatings implements Comparable<AgentRatings> {

    private String customerId;
    private String agentId;
    private int rating;

    @Override
    public int compareTo(AgentRatings o) {
        if (o.rating - this.rating > 0) {
            return -1;
        } else if (o.rating - this.rating < 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
