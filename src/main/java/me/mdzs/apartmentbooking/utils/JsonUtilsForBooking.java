package me.mdzs.apartmentbooking.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import me.mdzs.apartmentbooking.domain.Room;
import me.mdzs.apartmentbooking.domain.User;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonUtilsForBooking implements JsonDao<Room>{
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static List<Room> readJsonToList(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            Type userListType = new TypeToken<List<Room>>() {}.getType();
            return gson.fromJson(reader, userListType);
        }
    }

    public static void writeListToJson(List<Room> list, String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(list, writer);
        }
    }
}