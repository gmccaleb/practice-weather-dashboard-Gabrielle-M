package com.example.WeatherDashboard.Models;

import java.util.List;

public class WeatherResponse {

    private MainWeather main;
    private List<Weather> weather;

    public MainWeather getMain() {
        return main;
    }

    public void setMain(MainWeather main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}
