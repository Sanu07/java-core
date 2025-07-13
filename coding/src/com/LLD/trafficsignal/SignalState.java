package com.LLD.trafficsignal;

import lombok.Getter;

public abstract class SignalState {

    @Getter
    private TrafficSignal trafficSignal;

    public SignalState(TrafficSignal trafficSignal) {
        this.trafficSignal = trafficSignal;
    }

    public abstract void handle(Direction direction, TrafficLight trafficLight);
}
