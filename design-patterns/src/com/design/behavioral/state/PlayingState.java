package com.design.behavioral.state;

public class PlayingState extends State {

    public PlayingState(Game game) {
        super(game);
        System.out.println("--- Game in Playing state ---");
    }

    @Override
    public void onWelcome() {
        System.out.println("Not allowed");
    }

    @Override
    public void onPlaying() {
        System.out.println("Currently in Playing state");
    }

    @Override
    public void onPause() {
        getGame().changeState(new PauseState(getGame()));
    }

    @Override
    public void onEnd() {
        getGame().changeState(new EndState(getGame()));
    }
}
