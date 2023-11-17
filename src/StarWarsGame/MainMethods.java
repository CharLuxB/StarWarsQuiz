package StarWarsGame;
import static StarWarsGame.MainApiCall.generateInfoFromApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainMethods {

    public static int generateRandomInt() {

        Random randInt = new Random();

        return (randInt.nextInt(1, 60));

    }

    public static boolean checkIfUserChoiceCorrect(String correctAnswerName, int userChoiceNum, ArrayList<String> listOfOptions) {

        if(userChoiceNum < 1 || userChoiceNum > 4) {
            return false;
        }

        String userChoiceName = listOfOptions.get(userChoiceNum-1);

        return userChoiceName.equals(correctAnswerName);

    }

    public static ArrayList<String> generateListOfRandomNames(String topic, String correctAnswerName) throws Exception {

        ArrayList<String> listOfRandomNames = new ArrayList<>();

        listOfRandomNames.add(correctAnswerName);

        while (listOfRandomNames.size() < 4) {

            int newRandomNum = generateRandomInt();

            String newRandomName = generateInfoFromApi(topic, newRandomNum);

            if (listOfRandomNames.contains(newRandomName)) {
                continue;
            } else {
                listOfRandomNames.add(newRandomName);
                }
            }
            Collections.shuffle(listOfRandomNames);
            return listOfRandomNames;
        }

}
//comment