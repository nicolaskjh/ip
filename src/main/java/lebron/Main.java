package lebron;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lebron.ui.MainWindow;

/**
 * A GUI for LeBron chatbot using JavaFX
 */
public class Main extends Application {
    private Lebron lebron = new Lebron("./data/lebron.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = loader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            loader.<MainWindow>getController().setChatbot(lebron);
            stage.setOnCloseRequest(e -> {
                e.consume();
                lebron.exit();
                loader.<MainWindow>getController().closeWindow();
            });
            stage.show();
            stage.setTitle("LeBron");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
