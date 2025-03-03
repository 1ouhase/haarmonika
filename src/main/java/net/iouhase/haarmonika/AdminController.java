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
        nameField.clear();
        passwordField.clear();
    }

    public void onAddUserButtonClicked() {
        if (!nameField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
            String name = nameField.getText();
            String password = passwordField.getText();
            textLabel.setText(useCase.addUser(name, password));
            initialize();
        }
        else if (nameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fejl");
            alert.setHeaderText(null);
            alert.setContentText("Indtast venligst navn og password til brugeren");
            alert.showAndWait();
        }
    }
    public void onDeleteUserButtonClicked(ActionEvent actionEvent) {
        try {
            String username = userListView.getSelectionModel().getSelectedItem().toString();
            if (username != null) {
                textLabel.setText(useCase.removeUser(username));
                initialize();
            }
        }catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fejl");
            alert.setHeaderText(null);
            alert.setContentText(("Vælg venligst en bruger at slette"));
            alert.showAndWait();
        }
    }
    public void onEditUserButtonClicked(ActionEvent actionEvent) {
        try {
            String oldName = userListView.getSelectionModel().getSelectedItem().toString();
            if (!nameField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
                String name = nameField.getText();
                String password = passwordField.getText();
                textLabel.setText(useCase.updateUser(name, password, oldName));
                initialize();
            } else if (oldName != null) {
                nameField.setText(oldName);
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fejl");
            alert.setHeaderText(null);
            alert.setContentText("Vælg venligst en bruger");
            alert.showAndWait();
        }
    }
}
