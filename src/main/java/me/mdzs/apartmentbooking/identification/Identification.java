package me.mdzs.apartmentbooking.identification;

import me.mdzs.apartmentbooking.domain.User;

import java.util.*;

public class Identification {
    private  List<User> list;

    public Identification() {
        this.list = new ArrayList<>();
    }

    public void signUp(User user) throws Exception { //зарегистрироваться
        if (!user.getUserName().isEmpty() && !user.getPassword().isEmpty()){
            list.add(user);
        }
        else{
            throw new Exception("Fill the gaps");
        }
    }

    public Boolean signIn(User user) throws Exception { //войти
        if (!user.getUserName().isEmpty() && !user.getPassword().isEmpty()) {
            for (User item : list) {
                return item.equals(user);
            }
            throw new Exception("Your data isn't correct");
        }
        throw new Exception("Fill the gaps");
    }

}
