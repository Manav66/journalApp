package net.learningproj.journalApp.service;

import net.learningproj.journalApp.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.endpoint}")
    private String apiEndpoint;

    @Value("${weather.api.query}")
    private String query;

    public WeatherResponse getWeather(){
        String finalAPI = apiEndpoint + "?access_key=" + apiKey + "&query=" + query;
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        return response.getBody();
    }
}
