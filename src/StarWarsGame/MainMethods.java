package StarWarsGame;
import static StarWarsGame.MainApiCall.generateInfoFromApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

public class MainMethods {

    public static int generateRandomInt() {

        Random randInt = new Random();

        return (randInt.nextInt(59)+1);

    }

    public static boolean checkIfUserChoiceCorrect(String correctAnswerName, int userChoiceNum, ArrayList listOfOptions) {
        String userChoiceName = (String) listOfOptions.get(userChoiceNum);
        return Objects.equals(userChoiceName, correctAnswerName);
    }

    public static ArrayList<String> generateListOfRandomName(String type, int numberToAvoid, String correctAnswerName) throws Exception {

        ArrayList<String> listOfRandomNames = new ArrayList<>();

        while (listOfRandomNames.size() < 4) {

            ArrayList<Integer> listOfRandomNumbers = new ArrayList<>();

            int newRandomNum = generateRandomInt();

            if (listOfRandomNumbers.contains(newRandomNum)) {
                continue;
            } else {
                listOfRandomNumbers.add(newRandomNum);
                if (newRandomNum != numberToAvoid) {
                    String newName = generateInfoFromApi(type, newRandomNum);
                    listOfRandomNames.add(newName);
                }
            }
            listOfRandomNames.add(correctAnswerName);
            Collections.shuffle(listOfRandomNames);
            return listOfRandomNames;
        }
        return listOfRandomNames;
    }
}
