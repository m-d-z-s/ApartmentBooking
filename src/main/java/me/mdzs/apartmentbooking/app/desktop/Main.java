package me.mdzs.apartmentbooking.app.desktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import me.mdzs.apartmentbooking.Pathes;

import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Pathes.PATH_TO_DESKTOP_LOGIN_VIEW)));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Hotel Booking System. Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
