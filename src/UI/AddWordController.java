package UI;

import UX.DictionaryCommandLine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


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
