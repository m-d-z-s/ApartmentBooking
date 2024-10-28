package me.mdzs.apartmentbooking.utils;

import me.mdzs.apartmentbooking.domain.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonUtilsTest {

    @Test
    void testWriteToFile(){
        User user = new User("test", "test", false);
        JsonUtils<User> jsonUtils = new JsonUtils<>("src/main/resources/usersData.json");
        try{
            jsonUtils.writeJson(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}