package org.wethersdk;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

import lombok.SneakyThrows;
import org.wethersdk.exceptions.ApiKeyException;
import org.wethersdk.exceptions.CityNotFoundException;
import org.wethersdk.exceptions.NetworkException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.wethersdk.exceptions.CommonWeatherException;

/**
 * SDK for working with the OpenWeatherMap API.
 */
@RequiredArgsConstructor
public class WeatherSDK {

    @NonNull
    private final String apiKey;

    @NonNull
    private final String username;

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    /**
     * Retrieves weather data for the specified city.
     *
     * @param city The name of the city.
     * @return A JSON string containing weather data.
     */
    @SneakyThrows
    public String getWeather(@NonNull String city) {
        String url = String.format("%s?q=%s&appid=%s", BASE_URL, city, apiKey);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        return sendRequest(client, request)
                .orElseThrow(() -> new CommonWeatherException("Failed to fetch weather data for city: " + city));
    }

    /**
     * Sends an HTTP request and processes the response.
     *
     * @param client  The HTTP client.
     * @param request The HTTP request.
     * @return The response as a JSON string if the request is successful.
     */
    @SneakyThrows
    private Optional<String> sendRequest(HttpClient client, HttpRequest request){
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return switch (response.statusCode()) {
                case 200 -> Optional.ofNullable(response.body());
                case 401 -> throw new ApiKeyException("Invalid API key.");
                case 404 -> throw new CityNotFoundException("City not found.");
                default -> throw new CommonWeatherException("Failed to fetch weather data. Status code: " + response.statusCode());
            };
        } catch (IOException | InterruptedException e) {
            throw new NetworkException("Network error: " + e.getMessage());
        }
    }
}