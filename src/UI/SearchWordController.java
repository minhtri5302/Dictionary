package UI;

import UX.DictionaryCommandLine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class SearchWordController {
    @FXML
    private TextField wordSearch;
    @FXML
    private Label explain;
    private DictionaryCommandLine dictionaryCommandLine;

    public void setDictionaryCommandLine(DictionaryCommandLine dictionaryCommandLine) {
        this.dictionaryCommandLine = dictionaryCommandLine;
    }

    public void submitSearchWord(ActionEvent event) {
        try {
            String word = wordSearch.getText();
            explain.setText(dictionaryCommandLine.getDictionaryManagement().searchWord(word));
        } catch (Exception ex) {
        }
    }

    public void searchGoMenu(ActionEvent e) {
        try {
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Menu.fxml"));
            Parent viewParent = loader.load();
            Scene scene = new Scene(viewParent);
            stage.setScene(scene);
        } catch (Exception ex) {
        }
    }
}
