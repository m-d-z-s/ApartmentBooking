package me.mdzs.apartmentbooking.app.desktop.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    public Button signIn;
    @FXML
    public Button signUp;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
//        if (UserManager.login(username, password)) {
//            // Переход на BookingView или AdminView в зависимости от роли
//            BookingView bookingView = new BookingView();
//            bookingView.start(new Stage());
//            // Закрытие текущего окна
//            Stage stage = (Stage) usernameField.getScene().getWindow();
//            stage.close();
//        } else {
//            System.out.println("Invalid login.");
//        }
    }

    @FXML
    private void handleRegister() throws IOException {
        //закрываем текущее окно
        Stage stage1 = (Stage) signUp.getScene().getWindow();
        stage1.close();
        // Переход на окно регистрации
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/me/mdzs/apartmentbooking/app/desktop/RegistrationView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hotel Booking System. Registration");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}