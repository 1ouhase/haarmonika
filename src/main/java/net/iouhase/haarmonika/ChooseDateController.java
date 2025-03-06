package net.iouhase.haarmonika;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

public class ChooseDateController {
    @FXML
    private DatePicker datePicker;

    @FXML
    private void datePickerAction() {
        System.out.println(datePicker.getValue());
    }
}
