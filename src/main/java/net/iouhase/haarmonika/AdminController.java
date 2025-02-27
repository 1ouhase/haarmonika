package net.iouhase.haarmonika;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import net.iouhase.haarmonika.model.User;

import java.util.ArrayList;
import java.util.List;

public class AdminController {
    UseCase useCase = new UseCase();
    List<String> userList = new ArrayList<>();
    ObservableList<String> userObservableList = FXCollections.observableList(userList);
    @FXML
    Label textLabel = new Label();

    @FXML
    private ListView<String> userListView;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;

    public void initialize() {
        userList = useCase.getUsers();
        userObservableList.setAll(userList);
        userListView.setItems(userObservableList);
    }

    public void onAddUserButtonClicked() {
        if (!nameField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
            String name = nameField.getText();
            String password = passwordField.getText();
            textLabel.setText(useCase.addUser(name, password));
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Indtast venligst navn og password til brugeren");
        }
    }
    public void onDeleteUserButtonClicked(ActionEvent actionEvent) {
        String username = userListView.getSelectionModel().getSelectedItem().toString();
        if (username != null) {
            textLabel.setText(useCase.removeUser(username));
        }
    }
    public void onEditUserButtonClicked(ActionEvent actionEvent) {
        if (!nameField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
            String name = nameField.getText();
            String password = passwordField.getText();
            useCase.updateUser(name, password);
        }
    }
}
