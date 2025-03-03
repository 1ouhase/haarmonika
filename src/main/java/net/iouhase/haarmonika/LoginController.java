package net.iouhase.haarmonika;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    UseCase useCase = new UseCase();

    @FXML
    private TextArea username;

    @FXML
    private TextArea password;

    @FXML
    public void login(ActionEvent event) throws IOException {
        boolean login = useCase.checkUser(username.getText(), password.getText());
        if (login) {
            nextScene();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
//            alert.setContentText(login);
            alert.showAndWait();
        }
    }

    @FXML
    public void nextScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = fxmlLoader.load();
        MainController mainController = fxmlLoader.getController();
        mainController.setUser(username.getText());
        Stage stage = (Stage) username.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
