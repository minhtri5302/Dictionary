package UI;

import UX.DictionaryCommandLine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class EditWordController extends Navigation{
    @FXML
    private TextField wordTarget;
    @FXML
    private TextField wordExplain;
    @FXML
    private Label alert;
    public void submitEditWord(ActionEvent event) {
        try {
            String target = wordTarget.getText();
            String explain = wordExplain.getText();
            if (!getDictionaryCommandLine().getDictionaryManagement().editWord(target, explain)) {
                alert.setText("Từ này chưa có trong từ điển");
            }
            else alert.setText("Sửa từ thành công");
            getDictionaryCommandLine().dictionaryAdvanced();
        } catch (Exception ex) {
        }
    }
}
