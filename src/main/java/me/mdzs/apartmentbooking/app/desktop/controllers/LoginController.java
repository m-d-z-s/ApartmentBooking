package me.mdzs.apartmentbooking.app.desktop.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import me.mdzs.apartmentbooking.domain.User;
import me.mdzs.apartmentbooking.identification.UserDaoImplJson;

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
    private void handleLogin() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username and password cannot be empty.");
            return;
        }

        // Инициализируем UserDaoImplJson и проверяем данные пользователя
        UserDaoImplJson userDao = new UserDaoImplJson();
        Boolean flag = userDao.getUser(username, password);

        if (flag) {
            System.out.println("Login successful");
        } else {
            System.out.println("Invalid username or password");
        }
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