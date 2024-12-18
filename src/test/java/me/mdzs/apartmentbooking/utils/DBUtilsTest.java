package me.mdzs.apartmentbooking.utils;

import me.mdzs.apartmentbooking.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBUtilsTest {
    private static final String URL = "jdbc:sqlite:users.db";
    private final User user1 = new User("Alice", "25", false);
    private final User user2 = new User("olya", "54dv", true);

    @Test
    void initializeDatabase() {
        DBUtils.initializeDatabase(URL);
    }

    @Test
    void addUser() {
        DBUtils.addUser(user1, URL);
    }

    @Test
    void getUser() {
        System.out.println(DBUtils.getUser(user1.getUserName(), URL));

    }

    @Test
    void getAllUsers() {
        System.out.println(DBUtils.getAllUsers(URL));
    }

    @Test
    void removeUser() {
        DBUtils.removeUser(user2, URL);
        System.out.println(DBUtils.getAllUsers(URL));
    }
}