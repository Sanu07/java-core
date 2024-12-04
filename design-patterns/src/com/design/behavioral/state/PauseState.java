package com.design.behavioral.state;

public class PauseState extends State {
    public PauseState(Game game) {
        super(game);
        System.out.println("--- Game in Pause state ---");
    }

    @Override
    public void onWelcome() {
        System.out.println("Not allowed");
    }

    @Override
    public void onPlaying() {
        getGame().changeState(new PlayingState(getGame()));
    }

    @Override
    public void onPause() {
        System.out.println("Currently in Pause state");
    }

    @Override
    public void onEnd() {
        System.out.println("Not allowed");
    }
}
