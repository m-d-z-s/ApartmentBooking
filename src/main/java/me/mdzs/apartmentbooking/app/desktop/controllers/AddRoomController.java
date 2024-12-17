package me.mdzs.apartmentbooking.app.desktop.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import me.mdzs.apartmentbooking.Pathes;
import me.mdzs.apartmentbooking.domain.Room;
import me.mdzs.apartmentbooking.utils.JsonUtilsForRooms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddRoomController {
    @FXML
    public TextField roomNumber;
    @FXML
    public Button addRoomButton;
    public Button backButton;

    public void handleAddRoom(ActionEvent actionEvent) throws IOException {
        List<Integer> list = JsonUtilsForRooms.readJsonToList();
        Room room = new Room(Integer.parseInt(roomNumber.getText()));
        list.add(room.getRoomNumber());
        JsonUtilsForRooms.writeListToJson(list);

    }

    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        //закрываем текущее окно
        Stage stage1 = (Stage) backButton.getScene().getWindow();
        stage1.close();
        // Переход на окно регистрации
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Pathes.PATH_TO_DESKTOP_ADMIN_VIEW));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hotel Booking System. Home");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
