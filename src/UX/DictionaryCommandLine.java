package UX;

import UI.IntroController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
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
//        showAllWords();
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/UI/Intro.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            IntroController controller = loader.getController();
            controller.newData();
            scene.getStylesheets().add
                    ("/UI/navigation-button.css");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
