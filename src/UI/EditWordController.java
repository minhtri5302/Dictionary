package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
