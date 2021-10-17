package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddWordController extends Navigation {

  @FXML
  private TextField wordTarget;
  @FXML
  private TextField wordExplain;
  @FXML
  private Label alert;

  public void submitAddWord(ActionEvent event) {
    try {
      String target = wordTarget.getText();
      String explain = wordExplain.getText();
      if (!getDictionaryCommandLine().getDictionaryManagement().addWord(target, explain)) {
        alert.setText("Từ điển đã có từ này");
      } else {
        alert.setText("Thêm vào từ điển thành công");
      }
      getDictionaryCommandLine().dictionaryAdvanced();
    } catch (Exception ex) {
    }
  }
}
