package me.mdzs.apartmentbooking.app.desktop.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import me.mdzs.apartmentbooking.Pathes;
import me.mdzs.apartmentbooking.domain.Booking;
import me.mdzs.apartmentbooking.domain.Room;
import me.mdzs.apartmentbooking.utils.JsonUtilsForBooking;
import me.mdzs.apartmentbooking.utils.JsonUtilsForRooms;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class UserAddBookingController {
    @FXML
    public Button addBookingButton;
    @FXML
    public Button backButton;
    @FXML
    private ComboBox<Integer> roomNumberComboBox;

    @FXML
    private Spinner<Integer> guestsCountField;

    @FXML
    private DatePicker bookingDateFromPicker;

    @FXML
    private DatePicker bookingDateToPicker;

    private JsonUtilsForBooking jsonUtilsForBooking = new JsonUtilsForBooking();

    public String userName;

    private String GetTitle() throws IOException{
        Stage stage1 = (Stage) addBookingButton.getScene().getWindow();
        userName = stage1.getTitle();
        return userName;
    }

    @FXML
    private void initialize() throws IOException {
        // Заполнение списка доступных номеров комнат
        List<Integer> availableRooms = JsonUtilsForRooms.readJsonToList();
        System.out.println(availableRooms);// Пример номеров
        for (Integer room : availableRooms){
            roomNumberComboBox.getItems().add(room);
        }
//        roomNumberComboBox.getItems().addAll(availableRooms);

        // Добавление обработчика на изменение даты начала бронирования
        bookingDateFromPicker.valueProperty().addListener((obs, oldDate, newDate) -> {
            if (newDate != null) {
                // Установить минимально допустимую дату для bookingDateToPicker
                bookingDateToPicker.setDayCellFactory(picker -> new DateCellWithMinDate(newDate));
            }
        });
    }
    @FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        //закрываем текущее окно
        Stage stage1 = (Stage) backButton.getScene().getWindow();
        stage1.close();
        // Переход на окно регистрации
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Pathes.PATH_TO_DESKTOP_USER_VIEW));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle(GetTitle());
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void handleAddBooking() {
        try {
            // Получаем выбранный номер комнаты
            Integer roomNumber = roomNumberComboBox.getValue();
            if (roomNumber == null) {
                throw new IllegalArgumentException("Room number is not selected");
            }

            int guestsCount = guestsCountField.getValue();
            LocalDate bookingDateFrom = bookingDateFromPicker.getValue();
            LocalDate bookingDateTo = bookingDateToPicker.getValue();

            if (bookingDateFrom == null || bookingDateTo == null) {
                throw new IllegalArgumentException("Both booking dates must be selected");
            }

            if (bookingDateTo.isBefore(bookingDateFrom)) {
                throw new IllegalArgumentException("Booking end date cannot be before start date");
            }
            Room number = new Room(roomNumber);
            Booking booking = new Booking(GetTitle(), number, guestsCount, bookingDateFrom.toString(), bookingDateTo.toString());
            System.out.println("Booking added: " + booking);
            List<Booking> list = JsonUtilsForBooking.readJsonToList();
            list.add(booking);
            JsonUtilsForBooking.writeListToJson(list);

            // Логика для сохранения бронирования
        } catch (Exception e) {
            System.err.println("Invalid input: " + e.getMessage());
        }
    }

    // Вспомогательный класс для ограничения выбора дат
    private static class DateCellWithMinDate extends javafx.scene.control.DateCell {
        private final LocalDate minDate;

        public DateCellWithMinDate(LocalDate minDate) {
            this.minDate = minDate.plusDays(1);
        }
        @Override
        public void updateItem(LocalDate item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null && item.isBefore(minDate)) {
                setDisable(true); // Отключить даты до minDate
                setStyle("-fx-background-color: #ffc0cb;"); // Визуально выделить отключенные даты
            }
        }
    }
}