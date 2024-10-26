package me.mdzs.apartmentbooking.app.desktop.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

import me.mdzs.apartmentbooking.identification.UserDaoImplJson;
import me.mdzs.apartmentbooking.domain.User;


public class RegistrationController {

    @FXML
    public Button signUp;
    @FXML
    public Button signIn;
    public Label status;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    private UserDaoImplJson userdao;

    public RegistrationController(){
        userdao = new UserDaoImplJson();
    }


    @FXML
    private void handleRegister(){
        String username = usernameField.getText();
        String password = passwordField.getText();
        if(username.isEmpty() || password.isEmpty()){
            status.setText("Fill the fields");
        }
        else{
            User newUser = new User(username, password);
            userdao.save(newUser);
//            userdao.update();
            status.setText("Done!");
        }
    }

    @FXML
    private void handleLogin() throws IOException {
        //закрываем текущее окно
        Stage stage1 = (Stage) signIn.getScene().getWindow();
        stage1.close();
        // Переход на окно регистрации
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/me/mdzs/apartmentbooking/app/desktop/LoginView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hotel Booking System. Login");
        stage.setScene(new Scene(root1));
        stage.show();
    }

}