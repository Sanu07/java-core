package com.design.structural.bridge;

public class Main {

    public static void main(String[] args) {
        System.out.println("***** YouTube HD Video *****");
        Video youTubeHD = new YouTubeVideo(new HDProcessor());
        youTubeHD.play("file-1");

        System.out.println("***** YouTube HD4K Video *****");
        Video youTube4K = new YouTubeVideo(new HD4KProcessor());
        youTube4K.play("file-2");
    }
}
