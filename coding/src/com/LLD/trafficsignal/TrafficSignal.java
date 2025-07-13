package com.LLD.trafficsignal;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TrafficSignal {

    private SignalState signalState;

    public SignalState getSignalState() {
        return signalState;
    }

    ScheduledExecutorService executorService;

    public TrafficSignal() {
        this.executorService = Executors.newSingleThreadScheduledExecutor();
        signalState = new GreenState(this);
        handle(this, TrafficLight.GREEN, Direction.NORTH);
    }

    public void changeState(SignalState signalState) {
        this.signalState = signalState;
    }

    public void handle(TrafficSignal trafficSignal, TrafficLight trafficLight, Direction direction) {
        executorService.schedule(() -> {
            this.signalState.handle(direction, trafficLight);
        }, 1000, TimeUnit.MILLISECONDS);
    }
}
