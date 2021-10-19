package UI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import UX.DictionaryManagement;
import UX.DictionaryPronunciation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class SearchWordController extends Navigation {
    @FXML
    private TextField wordSearch;
    @FXML
    private TextArea wordExplain;
    @FXML
    private ListView<String> listView;
    @FXML
    private Label wordTop;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wordSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            listView.getItems().clear();
            DictionaryManagement x = getDictionaryManagement();
            ArrayList<String> arrayList = getDictionaryManagement().getDictionary().getTrie().search(wordSearch.getText().trim());
            for (String s : arrayList) {
                listView.getItems().add(s);
            }
        });
    }

    @FXML
    public void submitListView(MouseEvent event) {
        if (listView.getSelectionModel().getSelectedItem() != null) {
            String target = listView.getSelectionModel().getSelectedItem();
            wordExplain.setText(getDictionaryManagement().searchWord(target));
            wordTop.setText(target);
        }
    }

    public void submitSearch(ActionEvent event) {
        String target = wordSearch.getText();
        target = target.trim();
        String explain = getDictionaryManagement().searchWord(target);
        wordExplain.setText(explain);
        wordTop.setText(target);
    }

    public void submitEnter(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) {
            String target = wordSearch.getText();
            target = target.trim();
            String explain = getDictionaryManagement().searchWord(target);
            wordExplain.setText(explain);
            wordTop.setText(target);
        }
    }

    public void submitSound(ActionEvent event) {
        String target = wordTop.getText();
        DictionaryPronunciation DP = new DictionaryPronunciation();
        DP.textToSpeech(target);
    }
}
