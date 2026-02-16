package com.example.WeatherDashboard.Runner;


import com.example.WeatherDashboard.Models.WeatherResponse;
import com.example.WeatherDashboard.Services.WeatherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class WeatherConsoleRunner implements CommandLineRunner {

    private final WeatherService weatherService;

    public WeatherConsoleRunner(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    public void run(String... args) {

        Scanner scanner = new Scanner(System.in);

        List<String> cities = List.of(
                "New York",
                "Los Angeles",
                "Chicago",
                "St. Louis"  // <-- added
        );

        while (true) {

            System.out.println("\n===== WEATHER MENU =====");
            System.out.println("1. New York");
            System.out.println("2. Los Angeles");
            System.out.println("3. Chicago");
            System.out.println("4. St. Louis");  // <-- added
            System.out.println("5. Exit");       // <-- updated exit option
            System.out.print("Choose a city: ");

            int choice = scanner.nextInt();

            if (choice == 5) {  // <-- exit now is 5
                System.out.println("Goodbye!");
                break;
            }

            if (choice >= 1 && choice <= 4) {  // <-- valid cities now 1-4

                String city = cities.get(choice - 1);

                try {
                    WeatherResponse response = weatherService.getWeather(city);

                    System.out.println("\n----- Weather Summary -----");
                    System.out.println("City: " + city);
                    System.out.println("Temperature: " + response.getMain().getTemp() + "°F");
                    System.out.println("Description: " + response.getWeather().get(0).getDescription());
                    System.out.println("Humidity: " + response.getMain().getHumidity() + "%");

                } catch (Exception e) {
                    System.out.println("Error retrieving weather data.");
                }

            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
