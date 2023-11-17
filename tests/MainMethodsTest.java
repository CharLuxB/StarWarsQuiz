import StarWarsGame.MainMethods;
import org.junit.Test;

import java.util.ArrayList;

import static StarWarsGame.MainMethods.*;
import static org.junit.Assert.*;

public class MainMethodsTest {

    @Test
    public void testGenerateRandomInt() {
        int randomNumber = generateRandomInt();
        assertTrue(randomNumber >= 1 && randomNumber <= 60);
    }

    @Test
    public void testGenerateListOfRandomNamesSize() throws Exception {
        ArrayList<String> result = generateListOfRandomPlanetNames("Tatooine");
        assertEquals(4, result.size());
    }

    @Test
    public void testGenerateListOfRandomNamesContains() throws Exception {
        ArrayList<String> result = generateListOfRandomPlanetNames("Tatooine");
        assertTrue(result.contains("Tatooine"));
    }

    @Test
    public void testCheckIfUserChoiceCorrectTrue() {
        String correctAnswerName = "Alderan";
        ArrayList<String> listOfOptions = new ArrayList<>();
        listOfOptions.add(correctAnswerName);
        listOfOptions.add("Cerea");
        listOfOptions.add("Tatooine");
        listOfOptions.add("Coruscant");

        boolean result = MainMethods.checkIfUserChoiceCorrect(correctAnswerName, 1, listOfOptions);

        assertTrue(result);

    }

    @Test
    public void testCheckIfUserChoiceCorrectFalse() {
        String correctAnswerName = "Alderan";
        ArrayList<String> listOfOptions = new ArrayList<>();
        listOfOptions.add(correctAnswerName);
        listOfOptions.add("Cerea");
        listOfOptions.add("Tatooine");
        listOfOptions.add("Coruscant");

        boolean result = MainMethods.checkIfUserChoiceCorrect(correctAnswerName, 2, listOfOptions);

        assertFalse(result);

    }

}
// comment
