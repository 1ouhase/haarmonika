package net.iouhase.haarmonika;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import net.iouhase.haarmonika.database.DatabaseManager;
import net.iouhase.haarmonika.model.Booking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainController {
    ArrayList<Booking> bookings;

    @FXML
    protected TableView<Booking> tableView;

    @FXML
    protected TableColumn<Booking, String> dato;
    @FXML
    protected TableColumn<Booking, String> tid;
    @FXML
    protected TableColumn<Booking, String> varighed;
    @FXML
    protected TableColumn<Booking, String> klipstype;
    @FXML
    protected TableColumn<Booking, String> navn;
    @FXML
    protected TableColumn<Booking, String> frisør;
    @FXML
    protected TableColumn<Booking, Boolean> aflyst;


    @FXML
    protected Button opretTid;

    @FXML
    protected Button adminButton;

    @FXML
    protected void initialize() {
        try {
            UseCase usecase = new UseCase();
            bookings = usecase.getBookings();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

        dato.setCellValueFactory(cellData -> cellData.getValue().datoProperty());
        tid.setCellValueFactory(cellData -> cellData.getValue().tidProperty());
        varighed.setCellValueFactory(cellData -> cellData.getValue().varihedProperty());
        klipstype.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        navn.setCellValueFactory(cellData -> cellData.getValue().navnProperty());
        frisør.setCellValueFactory(cellData -> cellData.getValue().frisørProperty());
        aflyst.setCellValueFactory(cellData -> cellData.getValue().aflysningProperty());

        ObservableList<Booking> observableList = FXCollections.observableArrayList(bookings);

        tableView.setItems(observableList);
    }

    @FXML
    protected void onAdminButtonPressed() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
        Stage stage = (Stage)adminButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
    }

    @FXML
    protected void onOpretTidPressed() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ChooseDate.fxml"));
        Stage stage = (Stage)opretTid.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
    }
}