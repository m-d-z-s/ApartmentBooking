package me.mdzs.apartmentbooking.domain;

import java.util.Objects;

public class Booking {
    private final Room roomNumber;
    private final int guestsCount;
    private final String bookingDateFrom;
    private final String bookingDateTo;

    public Booking(Room roomNumber, int guestsCount, String bookingDateFrom, String bookingDateTo) {
        this.roomNumber = roomNumber;
        this.guestsCount = guestsCount;
        this.bookingDateFrom = bookingDateFrom;
        this.bookingDateTo = bookingDateTo;
    }

    public Room getRoomNumber() {
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Booking)) return false;
        Booking newBooking = (Booking) o;
        return (Objects.equals(this.roomNumber, newBooking.roomNumber) && Objects.equals(this.guestsCount, newBooking.guestsCount)
                && Objects.equals(this.bookingDateFrom, newBooking.bookingDateFrom)
                && Objects.equals(this.bookingDateTo, newBooking.bookingDateTo));
    }
}
