package com.LLD.trafficsignal;

public class RedState extends SignalState {

    public RedState(TrafficSignal trafficSignal) {
        super(trafficSignal);
    }

    @Override
    public void handle(Direction direction, TrafficLight trafficLight) {
        System.out.println("Direction | " + direction + " :: Light | " + trafficLight);
        getTrafficSignal().changeState(new GreenState(getTrafficSignal()));
        Direction[] values = Direction.values();
        getTrafficSignal().handle(getTrafficSignal(), TrafficLight.GREEN, values[(direction.ordinal() + 1) % values.length]);
    }
}
