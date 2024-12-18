package me.mdzs.apartmentbooking.app.desktop.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import me.mdzs.apartmentbooking.Pathes;

import java.io.IOException;
import java.net.URL;

public class AdminController {

    public Button displayBookingButton;
    public Button addRoomButton;
    public Button addBookingButton;
    public Button logOut;

    public void handleDisplayBooking(ActionEvent actionEvent) throws IOException {
        //закрываем текущее окно
        Stage stage1 = (Stage) displayBookingButton.getScene().getWindow();
        stage1.close();
        // Переход на окно регистрации
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Pathes.PATH_TO_DESKTOP_DISPLAY_VIEW));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hotel Booking System. Display list");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void handleAddRoom(ActionEvent actionEvent) throws IOException {
        //закрываем текущее окно
        Stage stage1 = (Stage) addRoomButton.getScene().getWindow();
        stage1.close();
        // Переход на окно регистрации
        URL location = getClass().getResource(Pathes.PATH_TO_DESKTOP_ADD_ROOM_VIEW);
        if (location == null) {
            System.err.println("location is null!!!");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hotel Booking System. Login");
        stage.setScene(new Scene(root1));
        stage.show();
    }


    public void handleAddBooking(ActionEvent actionEvent) throws IOException {
        //закрываем текущее окно
        Stage stage1 = (Stage) addBookingButton.getScene().getWindow();
        stage1.close();
        // Переход на окно регистрации
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Pathes.PATH_TO_DESKTOP_ADD_BOOKING_VIEW));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hotel Booking System. Login");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void handleBack(ActionEvent actionEvent) throws IOException {
        //закрываем текущее окно
        Stage stage1 = (Stage) logOut.getScene().getWindow();
        stage1.close();
        // Переход на окно регистрации
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Pathes.PATH_TO_DESKTOP_LOGIN_VIEW));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hotel Booking System. Login");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
