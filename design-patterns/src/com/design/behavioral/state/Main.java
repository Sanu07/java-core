package com.design.behavioral.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        Game game = new Game();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        do {
            System.out.println("-- Please input command --");
            input = bufferedReader.readLine().trim().toLowerCase();
            switch (input) {
                case "w": game.getState().onWelcome();
                    break;
                case "p": game.getState().onPlaying();
                    break;
                case "b": game.getState().onPause();
                    break;
                case "e": game.getState().onEnd();
                    break;
                default: {
                    if (!input.equals("q")) {
                        System.out.println("Unknown command");
                    }
                    break;
                }
            }
        } while (!input.equals("q"));

    }
}
