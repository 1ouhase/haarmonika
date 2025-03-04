package net.iouhase.haarmonika;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


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

    @FXML
    private TextField emailField;

    @FXML
    private TextField typeField;

    public void initialize() {
        userList = useCase.getUsers();
        userObservableList.setAll(userList);
        userListView.setItems(userObservableList);
        nameField.clear();
        passwordField.clear();
//        useCase.autoNotify();
    }

    public void onAddUserButtonClicked() {
        if (!nameField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
            String name = nameField.getText();
            String password = passwordField.getText();
            String email = emailField.getText();
            String type = typeField.getText();
            textLabel.setText(useCase.addUser(name, password, email, type));
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
            String old = userListView.getSelectionModel().getSelectedItem().toString();
            String[] split = old.split(", ", 3);
            String oldName = split[0];
            String oldEmail = split[1];
            String oldType = split[2];
            if (!nameField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
                String name = nameField.getText();
                String password = passwordField.getText();
                String email = emailField.getText();
                String type = typeField.getText();
                textLabel.setText(useCase.updateUser(name, password, oldName, email, type));
                initialize();
            } else if (oldName != null) {
                nameField.setText(oldName);
                emailField.setText(oldEmail);
                typeField.setText(oldType);
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fejl");
            alert.setHeaderText(null);
            alert.setContentText("Vælg venligst en bruger");
            alert.showAndWait();
        }
    }
    public void onEmailButtonClicked(ActionEvent actionEvent) {
        try {
            String old = userListView.getSelectionModel().getSelectedItem().toString();
            String[] split = old.split(", ", 3);
            String email = split[1];
            if(emailField.getText().isEmpty()) {
                emailField.setText(email);
            }
            else {
                textLabel.setText(useCase.notifyOfBooking(email));
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fejl");
            alert.setHeaderText(null);
            alert.setContentText("Vælg venligst en bruger");
            alert.showAndWait();
        }
    }
    public void onListClicked(){
        String old = userListView.getSelectionModel().getSelectedItem().toString();
        String[] split = old.split(", ", 3);
        nameField.setText(split[0]);
        emailField.setText(split[1]);
        typeField.setText(split[2]);
    }
}
