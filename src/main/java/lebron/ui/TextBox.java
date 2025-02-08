package lebron.ui;

import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 * Represents a Text Box in the GUI for LeBron chatbot
 */
public class TextBox extends HBox {
    @FXML
    private Label text;
    @FXML
    private Circle image;

    /**
     * Constructor for TextBox
     *
     * @param text Text to display
     * @param image Image to display
     */
    private TextBox(String text, Image image) {
        try {
            FXMLLoader loader = new FXMLLoader(MainWindow.class.getResource("/view/TextBox.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.text.setText(text);
        this.image.setFill(new ImagePattern(image));
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setAlignment(Pos.TOP_LEFT);
    }

    public static TextBox getUserText(String text, Image img) {
        return new TextBox(text, img);
    }

    public static TextBox getLebronText(String text, Image img) {
        var textBox = new TextBox(text, img);
        textBox.flip();
        return textBox;
    }
}
