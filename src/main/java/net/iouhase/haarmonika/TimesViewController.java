package net.iouhase.haarmonika;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimesViewController {
    @FXML
    protected Button back;

    @FXML
    protected ListView<String> times;

    @FXML
    private void initialize(){
        ObservableList<String> t = FXCollections.observableArrayList();

        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);

        while (!startTime.isAfter(endTime)) {
            String formattedTime = startTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            t.add(formattedTime);

            startTime = startTime.plusMinutes(30);
        }

        times.setItems(t);
    }

    @FXML
    private void onBackPressed() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Stage stage = (Stage)back.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
    }
}
