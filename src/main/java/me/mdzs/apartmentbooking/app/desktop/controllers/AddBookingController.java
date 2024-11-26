package me.mdzs.apartmentbooking.app.desktop.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import me.mdzs.apartmentbooking.domain.Room;
import me.mdzs.apartmentbooking.utils.JsonUtilsForBooking;

import java.time.LocalDate;
import java.util.List;

public class AddBookingController {

    @FXML
    private ComboBox<Integer> roomNumberComboBox;

    @FXML
    private TextField guestsCountField;

    @FXML
    private DatePicker bookingDateFromPicker;

    @FXML
    private DatePicker bookingDateToPicker;

    private JsonUtilsForBooking jsonUtilsForBooking = new JsonUtilsForBooking();

    @FXML
    private void initialize() {
        // Заполнение списка доступных номеров комнат
        List<Integer> availableRooms = List.of(101, 102, 103, 201, 202, 203); // Пример номеров
        roomNumberComboBox.getItems().addAll(availableRooms);

        // Добавление обработчика на изменение даты начала бронирования
        bookingDateFromPicker.valueProperty().addListener((obs, oldDate, newDate) -> {
            if (newDate != null) {
                // Установить минимально допустимую дату для bookingDateToPicker
                bookingDateToPicker.setDayCellFactory(picker -> new DateCellWithMinDate(newDate));
            }
        });
    }

    @FXML
    private void handleAddBooking() {
        try {
            // Получаем выбранный номер комнаты
            Integer roomNumber = roomNumberComboBox.getValue();
            if (roomNumber == null) {
                throw new IllegalArgumentException("Room number is not selected");
            }

            int guestsCount = Integer.parseInt(guestsCountField.getText());
            LocalDate bookingDateFrom = bookingDateFromPicker.getValue();
            LocalDate bookingDateTo = bookingDateToPicker.getValue();

            if (bookingDateFrom == null || bookingDateTo == null) {
                throw new IllegalArgumentException("Both booking dates must be selected");
            }

            if (bookingDateTo.isBefore(bookingDateFrom)) {
                throw new IllegalArgumentException("Booking end date cannot be before start date");
            }

            Room room = new Room(roomNumber, guestsCount, bookingDateFrom.toString(), bookingDateTo.toString());
            System.out.println("Booking added: " + room);
            List<Room> list = JsonUtilsForBooking.readJsonToList();
            list.add(room);
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
