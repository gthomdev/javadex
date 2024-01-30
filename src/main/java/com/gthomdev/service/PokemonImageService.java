package com.gthomdev.service;
import com.gthomdev.model.Pokemon;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.Buffer;
import java.net.URL;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import javax.imageio.ImageIO;

@Service
public class PokemonImageService {

    public String getPaddedStringForId(String id) {
        int paddedChars = 4 - id.length();
        return "0".repeat(paddedChars) + id;
    }
    public BufferedImage getPokemonImageForPokemon(String pokemonName) {
  /*      Document doc;

        try {
            doc = Jsoup.connect("https://bulbapedia.bulbagarden.net/wiki/" + pokemonName + "_(Pok%C3%A9mon)").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Elements image = doc.select(".image"); */
        try {
            return ImageIO.read(new URL("https://archives.bulbagarden.net/media/upload/thumb/f/fb/0001Bulbasaur.png/250px-0001Bulbasaur.png"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
