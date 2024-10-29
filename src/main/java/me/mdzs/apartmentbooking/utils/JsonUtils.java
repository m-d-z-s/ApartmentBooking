package me.mdzs.apartmentbooking.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import me.mdzs.apartmentbooking.domain.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonUtils {

    private static final Gson gson = new Gson();

    public static List<User> readJsonToList(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            Type userListType = new TypeToken<List<User>>() {}.getType();
            return gson.fromJson(reader, userListType);
        }
    }

    public static void writeListToJson(List<User> list, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(list, writer);
        }
    }
}


