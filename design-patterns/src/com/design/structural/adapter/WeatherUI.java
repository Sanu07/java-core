package com.design.structural.adapter;

public class WeatherUI {

    public static void main(String[] args) {

        // WeatherUI has zipcode (Integer) as an input parameter
        int zipCode = 1000;

        // ********************** Problem **************
        WeatherFinder weatherFinder = new WeatherFinderImpl();
        // ISSUE: cannot find weather using zipcode. It requires city in String format
        // weatherFinder.findTemperature(zipCode);

        // ********************* Solution **************
        // use weather adapter to get the temperature using zipcode
        WeatherAdapter weatherAdapter = new WeatherAdapter();
        int temperature = weatherAdapter.findTemperature(zipCode);
        System.out.println(temperature);
    }
}
