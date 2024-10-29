package me.mdzs.apartmentbooking.utils;

import me.mdzs.apartmentbooking.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonUtilsTest {

    private static final String FILE_PATH = "src/main/resources/usersData.json";

    private final User user1 = new User("Alice", "25", false);
    private final User user2 = new User("Bob", "30", true);

    @BeforeEach
    void setUp() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Test
    @Order(1)
    void test_writeListToJson() throws IOException {
        List<User> users = Arrays.asList(user1, user2);

        JsonUtils.writeListToJson(users, FILE_PATH);

        String content = Files.readString(new File(FILE_PATH).toPath());
        assertTrue(content.contains("\"userName\":\"Alice\""));
        assertTrue(content.contains("\"password\":\"25\""));
        assertTrue(content.contains("\"isAdmin\":false"));
        assertTrue(content.contains("\"userName\":\"Bob\""));
        assertTrue(content.contains("\"password\":\"30\""));
        assertTrue(content.contains("\"isAdmin\":true"));
    }

    @Test
    @Order(2)
    void test_readJsonToList() throws IOException {
        List<User> testUsers = Arrays.asList(user1, user2);

        List<User> realUsers = JsonUtils.readJsonToList(FILE_PATH);

        assertEquals(testUsers, realUsers);
    }

    @Test
    @Order(3)
    void test_writeSingleUserListToJson() throws IOException {
        List<User> users = List.of(user1);

        JsonUtils.writeListToJson(users, FILE_PATH);

        String content = Files.readString(new File(FILE_PATH).toPath());
        assertTrue(content.contains("\"userName\":\"Alice\""));
        assertTrue(content.contains("\"password\":\"25\""));
        assertTrue(content.contains("\"isAdmin\":false"));
    }

    @Test
    @Order(4)
    void test_readSingleUserJsonToList() throws IOException {
        List<User> testUsers = List.of(user1);

        List<User> realUsers = JsonUtils.readJsonToList(FILE_PATH);

        assertEquals(testUsers, realUsers);
    }
}
