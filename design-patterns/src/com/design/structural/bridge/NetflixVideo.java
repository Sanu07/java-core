package com.design.structural.bridge;

public class NetflixVideo extends Video {

    private VideoProcessor videoProcessor;

    public NetflixVideo(VideoProcessor videoProcessor) {
        super(videoProcessor);
    }

    @Override
    public void play(String file) {
        System.out.print("Netflix :: ");
        videoProcessor.process(file);
    }
}
