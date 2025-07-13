package test.ticketingsystem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rating {
    private String customerId;
    private String agentId;
    private int score;
}
