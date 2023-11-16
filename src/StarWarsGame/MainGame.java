package StarWarsGame;


import java.util.ArrayList;
import java.util.Scanner;

import static StarWarsGame.MainApiCall.generateInfoFromApi;
import static StarWarsGame.MainMethods.*;

public class MainGame {

    public static void main(String[] args) throws Exception {

        int answerNumber = generateRandomInt();

        String question = generateInfoFromApi("people", answerNumber);

        String answerName = generateInfoFromApi("planets", answerNumber);

        ArrayList<String> optionsList = generateListOfRandomName("planets", answerNumber, answerName);


        System.out.println("Which of the following planets is the home world of the Star Wars character " + question + "?");
        System.out.println("Is it:\n");

        int i = 0;
        while(i < optionsList.size()) {
            System.out.println((i+1) + ": " + optionsList.get(i));
            i++;
        }
        System.out.println("\nType in the number of your choice here:");

        Scanner userInput = new Scanner(System.in);
        String userChoiceString = userInput.nextLine();
        int userChoiceInt = Integer.parseInt(userChoiceString);

        boolean addPoint = checkIfUserChoiceCorrect(answerName, userChoiceInt, optionsList);

        if (addPoint) {
            System.out.println("Correct, it is " + answerName);
        } else {
            System.out.println("Incorrect, the answer is " + answerName);
        }







    }

}
