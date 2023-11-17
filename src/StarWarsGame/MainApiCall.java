package StarWarsGame;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class MainApiCall {



    public static ArrayList generateNameAndPlanetUrlFromSwapiUrl(String swapiUrl) throws Exception {

        ArrayList<String> listOfPeopleNameAndPlanetUrl = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(swapiUrl))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        String body = response.body();

        int nameStart = body.indexOf("\"name\":\"") + 8;
        int nameEnd = body.indexOf("\",", nameStart);
        String answerName = body.substring(nameStart, nameEnd);

        int homeworldStart = body.indexOf("\"homeworld\":\"") + 13;
        int homeworldEnd = body.indexOf("\",", homeworldStart);
        String homeworldUrl = body.substring(homeworldStart, homeworldEnd);

        listOfPeopleNameAndPlanetUrl.add(answerName);
        listOfPeopleNameAndPlanetUrl.add(homeworldUrl);

        return listOfPeopleNameAndPlanetUrl;

    }

    public static String generatePlanetNameFromSwapiUrl(String swapiUrl) throws Exception {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(swapiUrl))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        String body = response.body();

        int nameStart = body.indexOf("\"name\":\"") + 8;
        int nameEnd = body.indexOf("\",", nameStart);
        String planetName = body.substring(nameStart, nameEnd);

        return planetName;

    }

}