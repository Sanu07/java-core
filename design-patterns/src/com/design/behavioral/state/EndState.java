package com.design.behavioral.state;

public class EndState extends State {

    public EndState(Game game) {
        super(game);
        System.out.println("--- Game in End state ---");
    }

    @Override
    public void onWelcome() {
        getGame().changeState(new WelcomeState(getGame()));
    }

    @Override
    public void onPlaying() {
        System.out.println("Not allowed");
    }

    @Override
    public void onPause() {
        System.out.println("Not allowed");
    }

    @Override
    public void onEnd() {
        System.out.println("Currently in End state");
    }
}
