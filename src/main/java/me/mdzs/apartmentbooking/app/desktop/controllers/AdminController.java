package me.mdzs.apartmentbooking.app.desktop.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import me.mdzs.apartmentbooking.domain.Room;
import javafx.scene.input.MouseEvent;
import me.mdzs.apartmentbooking.utils.JsonUtilsForRooms;

import java.io.IOException;

public class AdminController {
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
//        JsonUtilsForRooms.readJsonToList("src/main/resources/bookingList.json");
        return null;
//        return javafx.collections.FXCollections.observableArrayList(
//                new Room(101, 2, "2024-11-25", "2024-11-28"),
//                new Room(102, 3, "2024-11-20", "2024-11-23")
//        );
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


    public void handleEditButton(ActionEvent actionEvent) {
    }
}
