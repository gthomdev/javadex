package com.gthomdev;

import com.gthomdev.model.Pokemon;
import com.gthomdev.service.PokemonImageService;
import com.gthomdev.service.PokemonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import java.awt.image.BufferedImage;

@SpringBootApplication
public class PokeClient {
    public static void main(String[] args) {
        SpringApplication.run(PokeClient.class, args);
    }

    @Bean
    public CommandLineRunner run(PokemonService pokemonService, PokemonImageService pokemonImageService) throws Exception {
        return args -> {

            BufferedImage bulbasaur = pokemonImageService.getPokemonImageForPokemon("bulbasaur");
            if (bulbasaur != null) {
                System.out.println(bulbasaur);
            }
            /*

            for (int i = 1; i < 152; i++) {
                Pokemon pokemon = pokemonService.getPokemonById(Integer.toString(i));
                StringBuilder sb = new StringBuilder();
                sb.append("Pokemon ").append(pokemon.name).append(" has ID ").append(pokemon.id);
                System.out.println(sb);
            }
        }; */
    };
}
}