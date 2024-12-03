package com.design.structural.bridge;

public class YouTubeVideo extends Video {

    public YouTubeVideo(VideoProcessor videoProcessor) {
        super(videoProcessor);
    }

    @Override
    public void play(String file) {
        System.out.print("YouTube :: ");
        videoProcessor.process(file);
    }
}
