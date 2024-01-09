package com.gthomdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class PokeClient {
    public static void main(String[] args) {
        SpringApplication.run(PokeClient.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            String url = "https://pokeapi.co/api/v2/ability/1/";
            String response = restTemplate.getForObject(url, String.class);
            System.out.println(response);
        };
    }
}