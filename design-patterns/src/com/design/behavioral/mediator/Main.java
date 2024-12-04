package com.design.behavioral.mediator;

public class Main {

    public static void main(String[] args) {
        Mediator mediator = new Mediator();

        ChatUser alice = new ChatUser("Alice", mediator);
        ChatUser bob = new ChatUser("Bob", mediator);
        ChatUser charlie = new ChatUser("Charlie", mediator);

        mediator.addUser(alice).addUser(bob).addUser(charlie);
        charlie.sendMessage("Hey!!");
    }
}
