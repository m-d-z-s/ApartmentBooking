package me.mdzs.apartmentbooking.identification;

import me.mdzs.apartmentbooking.domain.User;
import java.util.List;


public class UserDaoImplDB implements UserDao<User>{


    @Override
    public Boolean getUser(String user, String password) {
        return null;
    }


    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void save(User user) {

    }
}
