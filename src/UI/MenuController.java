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

public class MenuController implements Initializable {
    private DictionaryCommandLine dictionaryCommandLine;

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("INITTTTt");
        dictionaryCommandLine = new DictionaryCommandLine();
        dictionaryCommandLine.dictionaryAdvanced();
    }

    public void goSearchWord(ActionEvent e) {
        try {
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("SearchWord.fxml"));
            Parent viewParent = loader.load();
            Scene scene = new Scene(viewParent);
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
            loader.setLocation(getClass().getResource("AddWord.fxml"));
            Parent viewParent = loader.load();
            Scene scene = new Scene(viewParent);
            AddWordController controller = loader.getController();
            controller.setDictionaryCommandLine(dictionaryCommandLine);
            stage.setScene(scene);
        } catch (Exception ex) {
        }
    }

    public void goDeleteWord(ActionEvent e) {
        try {
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("DeleteWord.fxml"));
            Parent viewParent = loader.load();
            Scene scene = new Scene(viewParent);
            DeleteWordController controller = loader.getController();
            controller.setDictionaryCommandLine(dictionaryCommandLine);
            stage.setScene(scene);
        } catch (Exception ex) {
        }
    }

    public void goEditWord(ActionEvent e) {
        try {
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("EditWord.fxml"));
            Parent viewParent = loader.load();
            Scene scene = new Scene(viewParent);
            EditWordController controller = loader.getController();
            controller.setDictionaryCommandLine(dictionaryCommandLine);
            stage.setScene(scene);
        } catch (Exception ex) {
        }
    }
}
