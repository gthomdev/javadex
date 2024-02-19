package com.gthomdev.service;
import java.awt.image.BufferedImage;
import java.net.HttpURLConnection;
import java.net.URL;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Service;
import javax.imageio.ImageIO;
import java.io.File;

@Service
public class PokemonImageService {

    public String getPaddedStringForId(String id) {
        if (id.length() >= 4) {
            throw new IllegalArgumentException("Id must be 3 characters or fewer");
        }
        int paddedChars = 3 - id.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paddedChars; i++) {
            sb.append("0");
        }
        sb.append(id);
        return sb.toString();
    }
    public BufferedImage getPokemonImageForPokemon(String id, Boolean overrideUserAgent) {

        String urlStr = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/" + getPaddedStringForId(id) + ".png";
        try {
            final URL url = new URL(urlStr);
            final HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            if (overrideUserAgent) {
                connection.setRequestProperty(
                        "User-Agent",
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_5) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
            }
            return ImageIO.read(connection.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void savePokemonImage(BufferedImage pokemonImage, String filePath) {
        File outputFile = new File(filePath);
            try {
                ImageIO.write(pokemonImage, "png", outputFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
