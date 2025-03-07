package net.iouhase.haarmonika;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.iouhase.haarmonika.database.DatabaseManager;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void start(Stage primarystage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
        Parent root = fxmlLoader.load();
        primarystage.setTitle("HårMonica's frisørsalon");
        primarystage.setScene(new Scene(root));
        primarystage.centerOnScreen();
        primarystage.show();
    }

    public static void main(String[] args) {
        try {
            DatabaseManager.getBookings();
        } catch (SQLException e){
            e.printStackTrace();
        }
        UseCase useCase = new UseCase();
        useCase.sendEmails();
        launch();
    }
}