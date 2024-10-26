package me.mdzs.apartmentbooking.utils;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import me.mdzs.apartmentbooking.domain.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtils<T>{
    private final String jsonPath;
    private final JSONObject jsonObject = new JSONObject();

    public JsonUtils(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    public T readJson() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(jsonPath)) {
            // Парсим содержимое JSON файла
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            return (T) jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeJson(User user) throws IOException {
        jsonObject.put(user.getUserName(), user.getPassword());
        FileWriter file = new FileWriter(jsonPath);
        file.write(jsonObject.toJSONString());
        file.close();
    }
    public void writeListToJson(List<User> list) throws IOException {
        for (User user : list){
            writeJson(user);
        }
    }
}
