import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class WeatherController {
    private VBox view;
    private TextField locationInput;
    private Label temperatureLabel, humidityLabel, windSpeedLabel, conditionLabel;
    private ComboBox<String> unitSelector;
    private Button searchButton;

    public WeatherController() {
        view = new VBox(10); // Set spacing between elements
        view.setPadding(new Insets(20)); // Add padding around the VBox
        initializeView();
    }

    private void initializeView() {
        // Title Label
        Label titleLabel = new Label("Weather Information");
        titleLabel.setFont(new Font("Arial", 24));
        titleLabel.setTextFill(Color.DARKBLUE);
        view.getChildren().add(titleLabel);

        // Location input and search button
        HBox inputBox = new HBox(10); // Set spacing between elements
        locationInput = new TextField();
        locationInput.setPromptText("Enter location...");
        searchButton = new Button("Get Weather");
        searchButton.setOnAction(e -> fetchWeather());
        inputBox.getChildren().addAll(locationInput, searchButton);
        view.getChildren().add(inputBox);

        // Weather information labels
        temperatureLabel = new Label("Temperature: --");
        humidityLabel = new Label("Humidity: --");
        windSpeedLabel = new Label("Wind Speed: --");
        conditionLabel = new Label("Condition: --");

        // Unit selector
        unitSelector = new ComboBox<>();
        unitSelector.getItems().addAll("Celsius", "Fahrenheit");
        unitSelector.setOnAction(e -> updateUnits());

        // Add all elements to the VBox
        view.getChildren().addAll(temperatureLabel, humidityLabel, windSpeedLabel, conditionLabel, unitSelector);
    }

    private void fetchWeather() {
        // Code to fetch weather and update labels
        String location = locationInput.getText();
        try {
            String jsonResponse = APIHandler.fetchWeatherData(location);
            // Parse JSON and update labels (temperatureLabel, humidityLabel, etc.)
            // Placeholder code for demonstration:
            temperatureLabel.setText("Temperature: 20°C"); // Replace with actual data
            humidityLabel.setText("Humidity: 60%"); // Replace with actual data
            windSpeedLabel.setText("Wind Speed: 10 km/h"); // Replace with actual data
            conditionLabel.setText("Condition: Sunny"); // Replace with actual data
        } catch (Exception e) {
            showAlert("Error", "Unable to fetch weather data. Please check the location.");
        }
    }

    private void updateUnits() {
        // Code to switch units and refresh data display
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public VBox getView() {
        return view;
    }
}
