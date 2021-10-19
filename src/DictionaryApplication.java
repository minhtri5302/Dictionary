import UI.IntroController;
import UX.DictionaryManagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class DictionaryApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/UI/Intro.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            IntroController controller = loader.getController();
            DictionaryManagement obj = new DictionaryManagement();
            obj.insertFromFile();
            controller.newData(obj);
            scene.getStylesheets().add
                    ("/UI/css/navigation-button.css");
            primaryStage.setTitle("Dictionary OOP");
            primaryStage.getIcons().add(new Image("/image/dictionary-icon.png"));
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }
}


