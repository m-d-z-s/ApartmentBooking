package me.mdzs.apartmentbooking.domain;

import java.util.Objects;

public class Room {
    private final int roomNumber;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Room)) return false;
        Room newRoom = (Room) o;
        return (Objects.equals(this.roomNumber, newRoom.roomNumber));
    }
}
