package com.design.behavioral.state;

public class WelcomeState extends State {

    public WelcomeState(Game game) {
        super(game);
        System.out.println("--- Game in Welcome State ---");
    }

    @Override
    public void onWelcome() {
        System.out.println("On Welcome screen");
    }

    @Override
    public void onPlaying() {
        getGame().changeState(new PlayingState(getGame()));
    }

    @Override
    public void onPause() {
        System.out.println("Not allowed");
    }

    @Override
    public void onEnd() {
        System.out.println("Not allowed");
    }
}
