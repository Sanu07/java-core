package test.ticketingsystem;

import lombok.Data;

@Data
public class Customer {

    private String id;
    private String name;

    public Customer(String name) {
        this.name = name;
    }
}
