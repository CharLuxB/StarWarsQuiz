package StarWarsGame;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MainApiCall {

    public static String generateInfoFromApi(String type, int number) throws Exception {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://swapi.dev/api/" + type + "/" + number + "/"))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        String body = response.body();

        int nameStart = body.indexOf("\"name\":\"") + 8;
        int nameEnd = body.indexOf("\",", nameStart);
        String answer = body.substring(nameStart, nameEnd);

        return answer;

    }

}