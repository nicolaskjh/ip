package lebron.ui;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lebron.Lebron;

/**
 * Represents the main window for the GUI of LeBron chatbot
 */
public class MainWindow {
    private static final String EXIT_RESPONSE = "LeUnc needs some rest. Bye!";

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox textContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Lebron lebron;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/bronny.png"));
    private Image lebronImage = new Image(this.getClass().getResourceAsStream("/images/lebron.png"));

    /**
     * Sets the chatbot to an instance of Lebron
     *
     * @param lebron Instance of LeBron chatbot to initialise
     */
    public void setChatbot(Lebron lebron) {
        this.lebron = lebron;
    }

    /**
     * Initialises the main window
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(textContainer.heightProperty());
        String greet = "BOOM BOOM BOOM BOOM!\nWhat can I do for you?";
        textContainer.getChildren().add(
                TextBox.getLebronText(greet, lebronImage)
        );
        sendButton.disableProperty().bind(Bindings.isEmpty(userInput.textProperty()));
    }

    /**
     * Takes in user input to display a text box echoing user input, and another text box
     * containing the reply from LeBron chatbot. Clears user input after processing
     */
    @FXML
    private void handleUserInput() {
        if (userInput.getText().isEmpty()) {
            return;
        }

        String input = userInput.getText();
        String response = lebron.getResponse(input);
        textContainer.getChildren().addAll(
                TextBox.getUserText(input, userImage),
                TextBox.getLebronText(response, lebronImage)
        );
        userInput.clear();

        if (response.equals(EXIT_RESPONSE)) {
            lebron.exit();
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // do nothing
                }
                Platform.exit();
            }).start();
        }
    }

    /**
     * Closes the GUI window
     */
    @FXML
    public void closeWindow() {
        Stage stage = (Stage) textContainer.getScene().getWindow();
        textContainer.getChildren().add(
                TextBox.getLebronText(EXIT_RESPONSE, lebronImage)
        );
        stage.close();
    }
}
