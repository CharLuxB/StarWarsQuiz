package StarWarsGame;


import java.util.ArrayList;
import java.util.Scanner;


import static StarWarsGame.MainApiCall.generateNameAndPlanetUrlFromSwapiUrl;
import static StarWarsGame.MainApiCall.generatePlanetNameFromSwapiUrl;
import static StarWarsGame.MainMethods.*;

public class MainGame {

    public static void main(String[] args) throws Exception {

        int score = 0;

        for (int round = 1; round < 11 ; round++) {

            int randomPeopleNumber = generateRandomInt();

            ArrayList listOfNameAndPlanetUrl = generateNameAndPlanetUrlFromSwapiUrl("https://swapi.dev/api/people/" + randomPeopleNumber +"/");

            String randomPeopleName = (String) listOfNameAndPlanetUrl.get(0);

            String randomPeoplePlanetUrl = (String) listOfNameAndPlanetUrl.get(1);

            String correctPlanetAnswer = generatePlanetNameFromSwapiUrl(randomPeoplePlanetUrl);

            ArrayList optionPlanetsList = generateListOfRandomPlanetNames(correctPlanetAnswer);

            System.out.println("\nRound " + round + " | Score = " + score +
                    "\nWhich of the following planets is the home world of " + randomPeopleName + "?\nIs it:");

            int i = 0;
            while (i < optionPlanetsList.size()) {
                System.out.println((i + 1) + ": " + optionPlanetsList.get(i));
                i++;
            }
            System.out.println("\nType in the number of your choice here:");

            Scanner userInput = new Scanner(System.in);
            String userChoiceString = userInput.nextLine();
            int userChoiceInt = Integer.parseInt(userChoiceString);

            boolean addPoint = checkIfUserChoiceCorrect(correctPlanetAnswer, userChoiceInt, optionPlanetsList);

            if (addPoint) {
                System.out.println("Correct, it is " + correctPlanetAnswer);
                score += 1;
            } else {
                System.out.println("Incorrect, the answer is " + correctPlanetAnswer);
            }

        }
    }
}


