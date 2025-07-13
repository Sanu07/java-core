package com.LLD.trafficsignal;

public class GreenState extends SignalState {

    public GreenState(TrafficSignal trafficSignal) {
        super(trafficSignal);
    }

    @Override
    public void handle(Direction direction, TrafficLight trafficLight) {
        System.out.println("Direction | " + direction + " :: Light | " + trafficLight);
        getTrafficSignal().changeState(new YellowState(getTrafficSignal()));
        getTrafficSignal().handle(getTrafficSignal(), TrafficLight.YELLOW, direction);
    }
}
