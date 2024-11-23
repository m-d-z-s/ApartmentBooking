package me.mdzs.apartmentbooking.app.desktop.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import me.mdzs.apartmentbooking.domain.Room;
import javafx.scene.input.MouseEvent;
import me.mdzs.apartmentbooking.utils.JsonUtilsForBooking;

import java.io.IOException;
import java.util.List;

public class DisplayController {
    public Button backButton;
    @FXML
    private TableView<Room> roomsTable;

    @FXML
    private TableColumn<Room, Integer> roomNumberColumn;

    @FXML
    private TableColumn<Room, Integer> guestsCountColumn;

    @FXML
    private TableColumn<Room, String> dateColumnFrom;

    @FXML
    private TableColumn<Room, String> dateColumnTo;
    @FXML
    public Button editButton;

    @FXML
    public void initialize() throws IOException {
        // Настраиваем колонки таблицы
        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        guestsCountColumn.setCellValueFactory(new PropertyValueFactory<>("guestsCount"));
        dateColumnFrom.setCellValueFactory(new PropertyValueFactory<>("bookingDateFrom"));
        dateColumnTo.setCellValueFactory(new PropertyValueFactory<>("bookingDateTo"));

        // Пример данных для таблицы
        roomsTable.setItems(getRoomData());

        // Слушатель нажатий на строки таблицы
        roomsTable.setOnMouseClicked(this::handleRowClick);
    }

    private ObservableList<Room> getRoomData() throws IOException {
        List<Room> list =  JsonUtilsForBooking.readJsonToList("src/main/resources/bookingList.json");
        return (ObservableList<Room>) list;
    }

    private void handleRowClick(MouseEvent event) {
        if (event.getClickCount() == 2) { // Обработка двойного клика
            Room selectedRoom = roomsTable.getSelectionModel().getSelectedItem();
            if (selectedRoom != null) {
                System.out.println("Редактируем номер: " + selectedRoom);
                openEditDialog(selectedRoom);
            }
        }
    }

    private void openEditDialog(Room room) {
        // Откройте новое окно или модальное диалоговое окно для редактирования данных
        System.out.println("Открытие окна редактирования для: " + room);
        // Здесь можно подключить форму редактирования и передать данные выбранной записи
    }


    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        //закрываем текущее окно
        Stage stage1 = (Stage) editButton.getScene().getWindow();
        stage1.close();
        // Переход на окно регистрации
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/me/mdzs/apartmentbooking/app/desktop/AdminView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hotel Booking System. Login");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
