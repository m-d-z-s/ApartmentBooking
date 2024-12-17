package me.mdzs.apartmentbooking.app.desktop.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import me.mdzs.apartmentbooking.Pathes;
import me.mdzs.apartmentbooking.domain.Booking;
import javafx.scene.input.MouseEvent;
import me.mdzs.apartmentbooking.domain.Room;
import me.mdzs.apartmentbooking.identification.UserDaoImplJson;
import me.mdzs.apartmentbooking.utils.JsonUtilsForBooking;

import java.io.IOException;
import java.util.List;

public class DisplayController {
    public Button backButton;
    @FXML
    private TableView<Booking> roomsTable;

    @FXML
    private TableColumn<Booking, Room> roomNumberColumn;

    @FXML
    private TableColumn<Booking, Integer> guestsCountColumn;

    @FXML
    private TableColumn<Booking, String> dateColumnFrom;

    @FXML
    private TableColumn<Booking, String> dateColumnTo;
    private final UserDaoImplJson userdao = new UserDaoImplJson();

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

    private ObservableList<Booking> getRoomData() throws IOException {
        List<Booking> list =  JsonUtilsForBooking.readJsonToList();
        return FXCollections.observableArrayList(list); // Конвертация List в ObservableList
    }

    private void handleRowClick(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
            Booking selectedBooking = roomsTable.getSelectionModel().getSelectedItem();
            if (selectedBooking != null) {
                openEditDialog(selectedBooking);
            }
        } else if (event.getButton() == MouseButton.SECONDARY) {
            Booking selectedBooking = roomsTable.getSelectionModel().getSelectedItem();
            if (selectedBooking != null) {
                showContextMenu(event, selectedBooking);
            }
        }
    }

    private void showContextMenu(MouseEvent event, Booking selectedBooking) {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem deleteItem = new MenuItem("Удалить бронь");
        deleteItem.setOnAction(e -> confirmAndDelete(selectedBooking));
        contextMenu.getItems().add(deleteItem);
        contextMenu.show(roomsTable, event.getScreenX(), event.getScreenY());
    }

    private void confirmAndDelete(Booking booking) {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Подтверждение удаления");
        confirmationAlert.setHeaderText("Вы уверены, что хотите отменить бронь?");
        confirmationAlert.setContentText("Номер: " + booking.getRoomNumber());

        confirmationAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try { // Удаляем из таблицы
                    List<Booking> list = JsonUtilsForBooking.readJsonToList();
                    System.out.println(list);
                    System.out.println(booking);
                    list.remove(booking);
//                    list.removeIf(roomi -> roomi.equals(room));
                    System.out.println(list);
                    JsonUtilsForBooking.writeListToJson(list);
                    initialize();
                } catch (IOException e) {
                    showError("Ошибка сохранения данных", "Не удалось обновить файл с бронями.");
                }
            }
        });
    }
    private void showError(String title, String content) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle(title);
        errorAlert.setHeaderText(null);
        errorAlert.setContentText(content);
        errorAlert.showAndWait();
    }

    private void openEditDialog(Booking booking) {
        // Откройте новое окно или модальное диалоговое окно для редактирования данных
        System.out.println("Открытие окна редактирования для: " + booking);
        // Здесь можно подключить форму редактирования и передать данные выбранной записи
    }

    @FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        //закрываем текущее окно
        Stage stage1 = (Stage) backButton.getScene().getWindow();
        stage1.close();
        // Переход на окно регистрации
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Pathes.PATH_TO_DESKTOP_ADMIN_VIEW));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hotel Booking System. Login");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
