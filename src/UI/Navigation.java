package UI;

import UX.DictionaryCommandLine;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Navigation implements Initializable {
    private DictionaryCommandLine dictionaryCommandLine;

    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setDictionaryCommandLine(DictionaryCommandLine dictionaryCommandLine) {
        this.dictionaryCommandLine = dictionaryCommandLine;
    }

    public DictionaryCommandLine getDictionaryCommandLine() {
        return this.dictionaryCommandLine;
    }

    public void goSearchWord(ActionEvent e) {
        try {
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("SearchWord.fxml"));
            Parent viewParent = loader.load();
            Scene scene = new Scene(viewParent);
            scene.getStylesheets().add
                    ("/UI/navigation-button.css");
            SearchWordController controller = loader.getController();
            controller.setDictionaryCommandLine(dictionaryCommandLine);
            stage.setScene(scene);
        } catch (Exception ex) {
        }
    }

    public void goAddWord(ActionEvent e) {
        try {
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("AddEditWord.fxml"));
            Parent viewParent = loader.load();
            Scene scene = new Scene(viewParent);
            scene.getStylesheets().add
                    ("/UI/navigation-button.css");
            AddEditWordController controller = loader.getController();
            controller.setDictionaryCommandLine(dictionaryCommandLine);
            stage.setScene(scene);
        } catch (Exception ex) {
        }
    }

    public void goTranslate(ActionEvent e) {
        try {
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Translate.fxml"));
            Parent viewParent = loader.load();
            Scene scene = new Scene(viewParent);
            scene.getStylesheets().add
                    ("/UI/navigation-button.css");
            TranslateController controller = loader.getController();
            controller.setDictionaryCommandLine(dictionaryCommandLine);
            stage.setScene(scene);
        } catch (Exception ex) {
        }
    }

    public void goEditWord(ActionEvent e) {
        try {
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("DeleteWord.fxml"));
            Parent viewParent = loader.load();
            Scene scene = new Scene(viewParent);
            scene.getStylesheets().add
                    ("/UI/navigation-button.css");
            DeleteWordController controller = loader.getController();
            controller.setDictionaryCommandLine(dictionaryCommandLine);
            stage.setScene(scene);
        } catch (Exception ex) {
        }
    }

    public void goMenu(ActionEvent e) {
        try {
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Intro.fxml"));
            Parent viewParent = loader.load();
            Scene scene = new Scene(viewParent);
            IntroController controller = loader.getController();
            controller.setDictionaryCommandLine(dictionaryCommandLine);
            scene.getStylesheets().add
                    ("/UI/navigation-button.css");
            stage.setScene(scene);
        } catch (Exception ex) {
        }
    }
}
