package me.mdzs.apartmentbooking.domain;

import java.util.Objects;

public class User {
    private String userName;

    private String password;

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.password = userPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User)) return false;
        User userAsUser = (User) o;
        return (Objects.equals(this.userName, userAsUser.userName) && Objects.equals(this.password, userAsUser.password));
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userName);
    }
}
