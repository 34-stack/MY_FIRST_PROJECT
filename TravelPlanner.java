import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TravelPlanner extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Travel Itinerary Planner");

        TextField destinationField = new TextField();
        destinationField.setPromptText("Enter Destination");

        DatePicker startDatePicker = new DatePicker();
        DatePicker endDatePicker = new DatePicker();

        TextField budgetField = new TextField();
        budgetField.setPromptText("Enter Budget");

        Button generateItineraryButton = new Button("Generate Itinerary");

        generateItineraryButton.setOnAction(e -> {
            // Code to generate itinerary based on input
        });

        VBox vbox = new VBox(destinationField, startDatePicker, endDatePicker, budgetField, generateItineraryButton);
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherService {
    private static final String API_KEY = "YOUR_API_KEY";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";

    public static JSONObject getWeather(String city) throws Exception {
        String urlString = BASE_URL + "?q=" + city + "&appid=" + API_KEY;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(conn.getInputStream());
        JSONObject weatherData = new JSONObject(new String(reader.readAllBytes()));
        reader.close();

        return weatherData;
    }
}
