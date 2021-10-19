package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class DeleteWordController extends Navigation{
    @FXML
    private TextField wordTarget;
    @FXML
    private TextField wordExplain;
    @FXML
    private Label alert;

    public void submitDeleteWord(ActionEvent event) {
        try {
            String target = wordTarget.getText();
            target = target.trim();
            if (target.equals("")) {
                alert.setText("Chưa nhập từ");
                return;
            }
            alert.setTextFill(Color.web("red"));
            if (!getDictionaryManagement().deleteWord(target)) {
                alert.setText("Từ điển chưa có từ này");
            } else {
                alert.setTextFill(Color.web("#006400"));
                alert.setText("Xoá từ '" + target + "' thành công");
            }
        } catch (Exception ex) {
        }
    }
}
