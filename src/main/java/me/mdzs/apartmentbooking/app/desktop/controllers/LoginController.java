package me.mdzs.apartmentbooking.app.desktop.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import me.mdzs.apartmentbooking.domain.User;
import me.mdzs.apartmentbooking.identification.UserDaoImplDB;
import me.mdzs.apartmentbooking.identification.UserDaoImplJson;

import java.io.IOException;
import java.util.List;

public class LoginController {
    @FXML
    public Button signIn;
    @FXML
    public Button signUp;
    public Label status;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    UserDaoImplJson userDao = new UserDaoImplJson();

    @FXML
    private void handleLogin() throws IOException {
        status.setText("");
        String username = usernameField.getText().toLowerCase();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username and password cannot be empty.");
            return;
        }

        // Инициализируем UserDaoImplJson и проверяем данные пользователя
//        UserDaoImplDB userDao = new UserDaoImplDB();
        User user = userDao.getUser(username);
        Boolean flag = checkIfUserExist(username, password);

        if (flag) {
            status.setText("Login successful");
            // TODO: ""
            //закрываем текущее окно
            Stage stage1 = (Stage) signUp.getScene().getWindow();
            stage1.close();
            // Переход на новое окно
            FXMLLoader fxmlLoader;
            if (user.getIsAdmin()){
                fxmlLoader = new FXMLLoader(getClass().getResource("/me/mdzs/apartmentbooking/app/desktop/adminView.fxml"));

            }
            else {
                fxmlLoader = new FXMLLoader(getClass().getResource("/me/mdzs/apartmentbooking/app/desktop/userView.fxml"));
            }
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Hotel Booking System. Registration");
            stage.setScene(new Scene(root1));
            stage.show();

        } else {
            status.setText("Invalid username or password");
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


    private Boolean checkIfUserExist(String userName, String password) throws IOException {
        List<User> userList = userDao.getAll();
        for (User user : userList) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return true; // Возвращаем пользователя, если имя и пароль совпадают
            }
        }
        return false; // Если пользователь не найден или пароль неверный
    }
}