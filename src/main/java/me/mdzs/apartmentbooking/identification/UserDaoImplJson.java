package me.mdzs.apartmentbooking.identification;

import me.mdzs.apartmentbooking.domain.User;
import me.mdzs.apartmentbooking.utils.JsonUtils;
import java.util.List;
import java.util.Objects;

public class UserDaoImplJson implements UserDao<User>{
    private List<User> userList;
    private JsonUtils<List<User>> json;
    private String PATH = "resources/usersData.json";

    public UserDaoImplJson(){
        this.json = new JsonUtils<>(PATH);
        this.userList = json.readJson();
        if (userList == null) {
            userList = new java.util.ArrayList<>(); // Если данных нет, создаем пустой список
        }
    }

    @Override
    public User getUser(String userName) {
        for (User user : userList){
            if (user.getUserName().equals(userName)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public void delete(User user) {
        userList.removeIf(user1 -> user1.equals(user));
    }

    @Override
    public void update(User user) {
        for (User user1 : userList){
            if (Objects.equals(user1.getUserName(), user.getUserName())){
                user1.setPassword(user.getPassword());
            }
        }
    }

    @Override
    public void save(User user) {
        userList.add(user);
    }
}
