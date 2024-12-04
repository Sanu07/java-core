package com.design.behavioral.memento;

public class Main {

    public static void main(String[] args) {
        Originator originator = new Originator("Initial State");
        Caretaker caretaker = new Caretaker();

        caretaker.saveState(originator.createMemento());
        System.out.println("Current state is : " + originator.getState());

        originator.setState("State-1");
        caretaker.saveState(originator.createMemento());
        System.out.println("Current state is :" + originator.getState());

        originator.restoreMemento(caretaker.restoreState(0));
        System.out.println("Current state is : " + originator.getState());
    }
}
