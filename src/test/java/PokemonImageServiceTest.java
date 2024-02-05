import com.gthomdev.PokemonImageScraper;
import com.gthomdev.service.PokemonImageService;
import com.gthomdev.service.PokemonService;
import org.junit.jupiter.api.Test;
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
}