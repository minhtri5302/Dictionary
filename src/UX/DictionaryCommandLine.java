package UX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;


public class DictionaryCommandLine extends Application {
    private DictionaryManagement dictionaryManagement = new DictionaryManagement();

    public DictionaryManagement getDictionaryManagement() {
        return dictionaryManagement;
    }

    public void showAllWords() {
        Dictionary dictionary = dictionaryManagement.getDictionary();
        System.out.format("%-5s%-20s%-20s\n", "No", "|English", "|Vietnamese");
        HashMap<String, String> wordList = dictionary.getWordList();
        int i = 0;
        for (String s : wordList.keySet()) {
            System.out.format("%-5s%-20s%-20s\n", ++i, s, wordList.get(s));
        }
    }

    public void dictionaryAdvanced() {
        dictionaryManagement.insertFromFile();
        showAllWords();
    }

    public static void main(String[] args) {
        DictionaryPronunciation x = new DictionaryPronunciation();
//        x.textToSpeech("The time is now");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/UI/Menu.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            scene.getStylesheets().add
                ("/UI/navigation-button.css");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
