package net.iouhase.haarmonika;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.IOException;

public class ChooseDateController {
    public String date;

    @FXML
    private Button done;

    @FXML
    private DatePicker datePicker;

    @FXML
    private void datePickerAction(){
        this.date = datePicker.getValue() + "";
    }

    @FXML
    private void onDonePressed()throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("TimesView.fxml"));
        Stage stage = (Stage)done.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
    }
}
