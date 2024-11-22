package me.mdzs.apartmentbooking.domain;

public class Room {
    private final int roomNumber;
    private final int guestsCount;
    private final String bookingDateFrom;

    private final String bookingDateTo;

    public Room(int roomNumber, int guestsCount, String bookingDateFrom, String bookingDateTo) {
        this.roomNumber = roomNumber;
        this.guestsCount = guestsCount;
        this.bookingDateFrom = bookingDateFrom;
        this.bookingDateTo = bookingDateTo;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getGuestsCount() {
        return guestsCount;
    }

    public String getBookingDateFrom() {
        return bookingDateFrom;
    }

    public String getBookingDateTo() {
        return bookingDateTo;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", guestsCount=" + guestsCount +
                ", dateFrom='" + bookingDateFrom + '\'' +
                ", dateTo='" + bookingDateTo + '\'' +
                '}';
    }
}
