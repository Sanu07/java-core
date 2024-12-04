package com.design.behavioral.state;

public abstract class State {

    private Game game;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public State(Game game) {
        this.game = game;
    }

    public abstract void onWelcome();
    public abstract void onPlaying();
    public abstract void onPause();
    public abstract void onEnd();
}
