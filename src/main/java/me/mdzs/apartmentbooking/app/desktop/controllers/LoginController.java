package me.mdzs.apartmentbooking.app.desktop.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
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
        // Переход на окно регистрации
        FXMLLoader loader = new FXMLLoader(getClass().getResource("src/main/resources/me/mdzs/apartmentbooking/app/desktop/LoginView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Register");
        stage.setScene(new Scene(root, 300, 200));
        stage.show();
    }
}