package me.mdzs.apartmentbooking.app.desktop.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import me.mdzs.apartmentbooking.Pathes;

import java.io.IOException;

public class UserController {
    public Button displayBookingButton;
    public Button addBookingButton;

    public String userName;
    public Button logOut;

    private String GetTitle() throws IOException{
        Stage stage1 = (Stage) logOut.getScene().getWindow();
        userName = stage1.getTitle();
        return userName;
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

    public void handleDisplayBooking(ActionEvent actionEvent) throws IOException {
        Stage stage1 = (Stage) logOut.getScene().getWindow();
        stage1.close();
        // Переход на окно регистрации
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Pathes.PATH_TO_DESKTOP_USER_DISPLAY_VIEW));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle(GetTitle());
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void handleAddBooking(ActionEvent actionEvent) throws IOException {
        Stage stage1 = (Stage) logOut.getScene().getWindow();
        stage1.close();
        // Переход на окно регистрации
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Pathes.PATH_TO_DESKTOP_USER_ADD_BOOKING_VIEW));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle(GetTitle());
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
