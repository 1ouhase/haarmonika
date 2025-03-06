package net.iouhase.haarmonika;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primarystage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("TimesView.fxml"));
        Parent root = fxmlLoader.load();
        primarystage.setTitle("HårMonica's frisørsalon");
        primarystage.setScene(new Scene(root));
        primarystage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}