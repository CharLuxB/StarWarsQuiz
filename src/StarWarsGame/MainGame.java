package StarWarsGame;


import static StarWarsGame.MainApiCall.generateNameFromApi;
import static StarWarsGame.MainMethods.generateRandomInt;

public class MainGame {

    public static void main(String[] args) throws Exception {

        int randomNumber = generateRandomInt();

        String question = generateNameFromApi("people", randomNumber);

        System.out.println("Which of the following planets is the home world of the Star Wars character " + question + "?\n");
        System.out.println("Is it");



    }

}
