package com.gthomdev;

import com.gthomdev.service.PokemonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

import java.io.*;

@SpringBootApplication
public class PokemonDataScraper {
    public static void main(String[] args) {
        SpringApplication.run(PokemonImageScraper.class, args);
    }

    @Bean
    @Profile("!test")
    public CommandLineRunner runDataScraper(PokemonService pokemonService) throws Exception {
        return args -> {
            String[] pokemon = new String[151];
            for (int i = 1; i < 152; i++) {
                pokemon[i-1] = pokemonService.getPokemonById(String.valueOf(i)).name;
            }
            File outputFile = new File("Pokemon.txt");
            try (FileOutputStream fos = new FileOutputStream(outputFile); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));) {
                for (String s: pokemon) {
                    bw.write(s);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }
}