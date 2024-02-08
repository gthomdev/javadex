import com.gthomdev.PokemonImageScraper;
import com.gthomdev.service.PokemonImageService;
import com.gthomdev.service.PokemonService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = PokemonImageScraper.class)
@ActiveProfiles("test")
public class PokemonImageServiceTest {
    @Autowired
    private PokemonImageService pokemonImageService;
    @Test
    public void testGetPaddedStringForIdShouldNotPadAThreeCharacterString(){
        String testString = "151";
        String expectedResult = "151";
        String resultString = pokemonImageService.getPaddedStringForId(testString);
        assertThat(resultString).isEqualTo(expectedResult);
    }

    @Test
    public void testGetPaddedStringForIdShouldPadATwoCharacterString(){
        String testString = "51";
        String expectedResult = "051";
        String resultString = pokemonImageService.getPaddedStringForId(testString);
        assertThat(resultString).isEqualTo(expectedResult);
    }

    @Test
    public void testGetPaddedStringForIdShouldThrowExceptionIfInputIsMoreThanThreeCharacters(){
        String testString = "5111";
        assertThrows(IllegalArgumentException.class, ()-> pokemonImageService.getPaddedStringForId(testString));
    }

    @Test
    public void testGetPaddedStringForIdShouldPadAOneCharacterString(){
        String testString = "1";
        String expectedResult = "001";
        String resultString = pokemonImageService.getPaddedStringForId(testString);
        assertThat(resultString).isEqualTo(expectedResult);
    }


    @Test
    public void testGetPaddedStringForIdShouldReturnThreeZeroesForAnEmptyString(){
        String testString = "";
        String expectedResult = "000";
        String resultString = pokemonImageService.getPaddedStringForId(testString);
        assertThat(resultString).isEqualTo(expectedResult);
    }
}