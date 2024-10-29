package me.mdzs.apartmentbooking.utils;

import me.mdzs.apartmentbooking.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBUtilsTest {
    private final User user1 = new User("Alice", "25", false);
    private final User user2 = new User("Bob", "30", true);

    @Test
    void initializeDatabase() {
        DBUtils.initializeDatabase();
    }

    @Test
    void addUser() {
        DBUtils.addUser(user2);
    }

    @Test
    void getUser() {
        System.out.println(DBUtils.getUser("Alice"));

    }

    @Test
    void getAllUsers() {
        System.out.println(DBUtils.getAllUsers());
    }
}