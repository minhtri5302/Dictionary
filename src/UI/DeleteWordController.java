package UI;

import UX.DictionaryCommandLine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class DeleteWordController extends Navigation{
    @FXML
    private TextField wordDelete;
    @FXML
    private Label alert;
    private DictionaryCommandLine dictionaryCommandLine;

    public void submitDeleteWord(ActionEvent event) {
        try {
            String target = wordDelete.getText();
            if (!dictionaryCommandLine.getDictionaryManagement().deleteWord(target)) {
                alert.setText("Từ này chưa có trong từ điển");
            }
            else alert.setText("Xoá từ thành công");
            dictionaryCommandLine.dictionaryAdvanced();
        } catch (Exception ex) {
        }
    }
}
