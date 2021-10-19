package UI;

import UX.DictionaryPronunciation;
import UX.TranslateAPI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class TranslateController extends Navigation {
    @FXML
    private TextArea input;
    @FXML
    private TextArea output;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;

    public void initialize(URL location, ResourceBundle resources) {
        input.setWrapText(true);
        output.setWrapText(true);
        button1.setStyle("-fx-font-weight: bold; -fx-background-color: #7FFFD4; -fx-background-radius: 0");
        button2.setStyle("-fx-background-color: #7bc8ce; -fx-background-radius: 0");
        button3.setStyle("-fx-font-weight: bold; -fx-background-color: #7FFFD4; -fx-background-radius: 0");
        button4.setStyle("-fx-background-color: #7bc8ce; -fx-background-radius: 0");
    }



    public void submitTranslate(ActionEvent event) {
        try {
            String target = input.getText();
            String explain;
            if (AV)
                explain = TranslateAPI.translate("en", "vi", target);
            else
                explain = TranslateAPI.translate("vi", "en", target);
            output.setText(explain);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    boolean AV = true;

    private void setColor() {
        if (AV) {
            button1.setStyle("-fx-background-color: #7bc8ce; -fx-background-radius: 0");
            button2.setStyle("-fx-background-color: #7FFFD4; -fx-background-radius: 0; -fx-font-weight: bold; ");
            button3.setStyle("-fx-background-color: #7bc8ce; -fx-background-radius: 0");
            button4.setStyle("-fx-background-color: #7FFFD4; -fx-background-radius: 0; -fx-font-weight: bold; ");
            AV = false;
        } else {
            button1.setStyle("-fx-font-weight: bold; -fx-background-color: #7FFFD4; -fx-background-radius: 0");
            button2.setStyle("-fx-background-color: #7bc8ce; -fx-background-radius: 0");
            button3.setStyle("-fx-font-weight: bold; -fx-background-color: #7FFFD4; -fx-background-radius: 0");
            button4.setStyle("-fx-background-color: #7bc8ce; -fx-background-radius: 0");
            AV = true;
        }
    }

    public void submitButton(ActionEvent event) {
        setColor();
    }

    public void submitSound1(ActionEvent event) {
        String text = input.getText();
        DictionaryPronunciation DP = new DictionaryPronunciation();
        DP.textToSpeech(text);
    }

    public void submitSound2(ActionEvent event) {
        String text = output.getText();
        DictionaryPronunciation DP = new DictionaryPronunciation();
        DP.textToSpeech(text);
    }
}
