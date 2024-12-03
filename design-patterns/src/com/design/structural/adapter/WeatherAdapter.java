package com.design.structural.adapter;

public class WeatherAdapter {

    public int findTemperature(int zipCode) {
        // Fetch the city using the zipcode
        String city = findCityByZipCode(zipCode);
        WeatherFinder weatherFinder = new WeatherFinderImpl();
        return weatherFinder.findTemperature(city);
    }

    // can be any external API or DB call
    private String findCityByZipCode(int zipCode) {
        if (zipCode > 0) {
            return "Kolkata";
        }
        return "";
    }
}
