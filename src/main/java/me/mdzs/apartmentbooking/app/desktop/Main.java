package me.mdzs.apartmentbooking.app.desktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/me/mdzs/apartmentbooking/app/desktop/LoginView.fxml"));
        primaryStage.setTitle("Hotel Booking System");
        primaryStage.setScene(new Scene(fxmlLoader.load(), 300, 200));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
