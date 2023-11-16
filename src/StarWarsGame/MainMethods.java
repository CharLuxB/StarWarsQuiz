package StarWarsGame;
import static StarWarsGame.MainApiCall.generateNameFromApi;
import java.util.ArrayList;
import java.util.Random;

public class MainMethods {

    public static int generateRandomInt() {

        Random randInt = new Random();

        return (randInt.nextInt(59)+1);

    }

    public static ArrayList<String> generateListOfRandomName(String type, int numberToAvoid) throws Exception {

        ArrayList<String> listOfRandomNames = new ArrayList<String>();

        for (int i = 0; i < 4; i++) {
            int newRandomNum = generateRandomInt();
            if (newRandomNum != numberToAvoid) {
                String newName = generateNameFromApi(type, newRandomNum);
                listOfRandomNames.add(newName);
            }
        }
        return listOfRandomNames;
    }

}
