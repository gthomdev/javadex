package com.gthomdev.service;
import com.gthomdev.model.Pokemon;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

    @Service
    public class PokemonService {


        private final RestTemplate restTemplate;

        public PokemonService(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        public Pokemon getPokemonById(String pokemonId) {
            String url = "https://pokeapi.co/api/v2/pokemon/" + pokemonId + "/";
            return restTemplate.getForObject(url, Pokemon.class);
        }
    }
