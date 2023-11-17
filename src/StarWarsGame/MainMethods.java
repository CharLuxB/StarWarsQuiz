
package StarWarsGame;
import static StarWarsGame.MainApiCall.generatePlanetNameFromSwapiUrl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainMethods {

    public static int generateRandomInt() {

        Random randInt = new Random();

        return (randInt.nextInt(1, 45));

    }

    public static boolean checkIfUserChoiceCorrect(String correctPlanetName, int userChoiceNum, ArrayList<String> listOfOptions) {

        if(userChoiceNum < 1 || userChoiceNum > 4) {
            return false;
        }

        String userChoiceName = listOfOptions.get(userChoiceNum-1);

        return userChoiceName.equals(correctPlanetName);

    }

    public static ArrayList<String> generateListOfRandomPlanetNames(String correctPlanetName) throws Exception {

        ArrayList<String> listOfRandomPlanetNames = new ArrayList<>();

        listOfRandomPlanetNames.add(correctPlanetName);

        while (listOfRandomPlanetNames.size() < 4) {

            int newRandomNum = generateRandomInt();

            String newRandomUrl = "https://swapi.dev/api/planets/" + newRandomNum +"/";

            String newRandomPlanetName = generatePlanetNameFromSwapiUrl(newRandomUrl);


            if (listOfRandomPlanetNames.contains(newRandomPlanetName)) {
                continue;
            } else {
                listOfRandomPlanetNames.add(newRandomPlanetName);
                }
            }
            Collections.shuffle(listOfRandomPlanetNames);
            return listOfRandomPlanetNames;
        }

}

