package UI;

import UX.DictionaryCommandLine;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController extends Navigation {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DictionaryCommandLine x = new DictionaryCommandLine();
        x.dictionaryAdvanced();
        setDictionaryCommandLine(x);
    }
}
