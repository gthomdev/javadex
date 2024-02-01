package com.gthomdev;

import com.gthomdev.service.PokemonImageService;
import com.gthomdev.service.PokemonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import java.awt.image.BufferedImage;

@SpringBootApplication
public class PokemonImageScraper {
    public static void main(String[] args) {
        SpringApplication.run(PokemonImageScraper.class, args);
    }

    @Bean
    public CommandLineRunner run(PokemonService pokemonService, PokemonImageService pokemonImageService) throws Exception {
        return args -> {
            for (int i = 1; i < 152; i++) {
                BufferedImage pokemon = pokemonImageService.getPokemonImageForPokemon(String.valueOf(i));
                pokemonImageService.savePokemonImage(pokemon, "C:\\Users\\georg\\Documents\\Pokemon\\" + String.valueOf(i) + ".png");
            }
    };
}
}