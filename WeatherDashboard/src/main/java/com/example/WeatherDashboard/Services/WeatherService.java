package com.example.WeatherDashboard.Services;

import com.example.WeatherDashboard.Models.WeatherResponse;
//import com.example.WeatherDashboard.Models.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private final String baseUrl =
            "https://api.openweathermap.org/data/2.5/weather";

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherResponse getWeather(String city) {

        String url = baseUrl
                + "?q=" + city
                + "&appid=" + apiKey
                + "&units=imperial";

        return restTemplate.getForObject(url, WeatherResponse.class);
    }
}
