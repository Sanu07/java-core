package com.design.behavioral.state;

public class Game {

    private State state;

    public Game() {
        this.state = new WelcomeState(this);
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
