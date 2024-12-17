package me.mdzs.apartmentbooking.identification;

import me.mdzs.apartmentbooking.domain.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplJsonTest {
    public UserDaoImplJson userDaoImplJson = new UserDaoImplJson();
    private final String PATH = "src/main/resources/usersData.json";
    private final User user1 = new User("Alice", "25", false);
    private final User user2 = new User("Bob", "0121", true);
    private final User user3 = new User("Ira", "5421fhx3", false);
    private final User user4 = new User("Ira", "321", false);

    @Test
    void getAll() throws IOException {
        List<User> list = userDaoImplJson.getAll();
        for (User user : list){
            System.out.println(user);
        }
    }

    @Test
    void getUser() throws IOException {
        System.out.println(userDaoImplJson.getUser("Alice"));
    }


    @Test
    void delete() throws IOException {
        userDaoImplJson.delete(user3);
        getAll();
    }

    @Test
    void update() throws IOException {
        userDaoImplJson.update(user2);
        getAll();
    }

    @Test
    void save() throws IOException {
        userDaoImplJson.save(user3);
        getAll();
    }
}