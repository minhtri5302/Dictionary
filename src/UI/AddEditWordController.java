package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class AddEditWordController extends Navigation {

    @FXML
    private TextField wordTarget;
    @FXML
    private TextArea wordExplain;
    @FXML
    private TextField wordPronoun;
    @FXML
    private TextField wordType;
    @FXML
    private Label alert;

    public void submitAddWord(ActionEvent event) {
        try {
            String target = wordTarget.getText();
            String explain = wordPronoun.getText();
            String add = wordExplain.getText();
            target = target.trim();
            if (target.equals("") || add.equals("")) {
                alert.setText("Chưa nhập từ hoặc giải thích");
                return;
            }
            alert.setTextFill(Color.web("red"));
            if(!wordType.getText().equals("")) explain += "\n   " + wordType.getText() + ":\n";
            add = add.replace("\n", "\n      - ");
            explain += "      - " + add;
            if (!getDictionaryManagement().addWord(target, explain)) {
                alert.setText("Từ điển đã có từ này");
            } else {
                alert.setText("Thêm từ '" + target + "' vào từ điển thành công");
                alert.setTextFill(Color.web("#006400"));
            }
        } catch (Exception ex) {
        }
    }

    public void submitEditWord(ActionEvent event) {
        try {
            String target = wordTarget.getText();
            String explain = wordPronoun.getText();
            String add = wordExplain.getText();
            target = target.trim();
            if (target.equals("") || add.equals("")) {
                alert.setText("Chưa nhập từ hoặc giải thích");
                return;
            }
            alert.setTextFill(Color.web("red"));
            if (!wordType.getText().equals("")) explain += "\n   " + wordType.getText() + ":\n";
            add = add.replace("\n", "\n      - ");
            explain += "      - " + add;
            if (!getDictionaryManagement().editWord(target, explain)) {
                alert.setText("Từ điển chưa có từ này");
            } else {
                alert.setTextFill(Color.web("#006400"));
                alert.setText("Sửa từ '" + target + "' thành công");
            }
        } catch (Exception ex) {
        }
    }
}
