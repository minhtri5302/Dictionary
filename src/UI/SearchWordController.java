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


public class SearchWordController extends Navigation {
    @FXML
    private TextField wordSearch;
    @FXML
    private Label explain;

    public void submitSearchWord(ActionEvent event) {
        try {
            String word = wordSearch.getText();
            explain.setText(getDictionaryCommandLine().getDictionaryManagement().searchWord(word));
        } catch (Exception ex) {
        }
    }
}
