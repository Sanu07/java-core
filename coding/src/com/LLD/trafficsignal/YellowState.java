package com.LLD.trafficsignal;

public class YellowState extends SignalState {

    public YellowState(TrafficSignal trafficSignal) {
        super(trafficSignal);
    }

    @Override
    public void handle(Direction direction, TrafficLight trafficLight) {
        System.out.println("Direction | " + direction + " :: Light | " + trafficLight);
        getTrafficSignal().changeState(new RedState(getTrafficSignal()));
        getTrafficSignal().handle(getTrafficSignal(), TrafficLight.RED, direction);
    }
}
