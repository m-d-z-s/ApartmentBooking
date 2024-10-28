package me.mdzs.apartmentbooking.utils;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import me.mdzs.apartmentbooking.domain.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtils<T>{
    private final String jsonPath;
    private final JSONObject jsonObject = new JSONObject();

    public JsonUtils(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    public List<User> readJsonToList(String filePath) throws IOException {
        List<User> existingUserList = List.of();
        try {
            // Read the existing JSON file
            String json = new String(Files.readAllBytes(Paths.get(filePath)));

            // Deserialize the JSON into a list of Tracker objects
            Type userListType = new TypeToken<List<User>>() {}.getType();
            existingUserList = new Gson().fromJson(json, userListType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return existingUserList;
    }
//    public static List<User> readJsonToList(String filePath) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.readValue(new File(filePath), new TypeReference<List<User>>() {});
//    }

    public void writeJson(User user) throws IOException {
        jsonObject.put(user.getUserName(), user.getPassword());
        FileWriter file = new FileWriter(jsonPath);
        file.write(jsonObject.toJSONString());
        file.close();
    }
//    public void writeListToJson(List<User> list) throws IOException {
//        for (User user : list){
//            writeJson(user);
//        }
//    }

    public void writeListToJson(List<User> list) {
        // Check if the file exists
        File file = new File(jsonPath);
        if (!file.exists()) {
            writeJsonToFile(list);
        } else {
            try {
                // Read the existing JSON file
                String json = new String(Files.readAllBytes(Paths.get(jsonPath)));

                // Deserialize the JSON into a list of Tracker objects
                Type userListType = new TypeToken<List<User>>() {}.getType();
                List<User> existingTrackerList = new Gson().fromJson(json, userListType);

                // Add the new tracker object to the existing list
                existingTrackerList.add(new User("test", "test", false));

                // Write the updated list to the file
                writeJsonToFile(existingTrackerList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeJsonToFile(List<User> userList) {
        try (FileWriter writer = new FileWriter(jsonPath)) {
            // Serialize the list of Tracker objects to JSON
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(userList);

            // Write the JSON to the file
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


