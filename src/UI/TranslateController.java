package UI;

import UX.DictionaryPronunciation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
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

    private static String translate(String langFrom, String langTo, String text) throws IOException {
        // INSERT YOU URL HERE
        String urlStr = "https://script.google.com/macros/s/AKfycbwHsg9Ywpg25EwswiLFGGSCVKaN3eNr8QxsGrdDe9ofcfZIZds/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    //    public void submitDeleteWord(ActionEvent event) {
//        try {
//            String target = wordDelete.getText();
//            if (!dictionaryCommandLine.getDictionaryManagement().deleteWord(target)) {
//                alert.setText("Từ này chưa có trong từ điển");
//            }
//            else alert.setText("Xoá từ thành công");
//            dictionaryCommandLine.dictionaryAdvanced();
//        } catch (Exception ex) {
//        }
//    }
    public void submitTranslate(ActionEvent event) {
        try {
            String target = input.getText();
            String explain;
            if (AV)
                explain = translate("en", "vi", target);
            else
                explain = translate("vi", "en", target);
            System.out.println(explain);
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
