package UI;

import UX.Dictionary;
import UX.DictionaryCommandLine;
import java.net.URL;
import java.util.ResourceBundle;

public class IntroController extends Navigation {
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        DictionaryCommandLine x = new DictionaryCommandLine();
//        x.dictionaryAdvanced();
//        setDictionaryCommandLine(x);
//    }
    public void newData() {
        DictionaryCommandLine x = new DictionaryCommandLine();
        x.dictionaryAdvanced();
        setDictionaryCommandLine(x);
    }
}
