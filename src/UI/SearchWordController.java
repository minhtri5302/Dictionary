package UI;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import UX.DictionaryCommandLine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SearchWordController extends Navigation {

    @FXML
    private TextField wordSearch;
    @FXML
    private ListView<Button> listView;
    @Override
    public void initialize(URL location, ResourceBundle resources){
        wordSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            listView.getItems().clear();
            ArrayList<String> arrayList = getDictionaryCommandLine().getDictionaryManagement().getDictionary().getTrie().search(wordSearch.getText());
            for(String s: arrayList) {
                Button button = new Button();
                button.setText(s);
                listView.getItems().add(button);
            }
        });
    }
}
