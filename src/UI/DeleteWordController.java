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


public class DeleteWordController {
    @FXML
    private TextField wordDelete;
    @FXML
    private Label alert;
    private DictionaryCommandLine dictionaryCommandLine;

    public void setDictionaryCommandLine(DictionaryCommandLine dictionaryCommandLine) {
        this.dictionaryCommandLine = dictionaryCommandLine;
    }

    public void submitDeleteWord(ActionEvent event) {
        try {
            String target = wordDelete.getText();
            if (!dictionaryCommandLine.getDictionaryManagement().deleteWord(target)) {
                alert.setText("Từ này chưa có trong từ điển");
            }
            dictionaryCommandLine.dictionaryAdvanced();
        } catch (Exception ex) {
        }
    }

    public void deleteGoMenu(ActionEvent e) {
        try {
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Menu.fxml"));
            Parent viewParent = loader.load();
            Scene scene = new Scene(viewParent);
            stage.setScene(scene);
        } catch (Exception ex) {
        }
    }
}
