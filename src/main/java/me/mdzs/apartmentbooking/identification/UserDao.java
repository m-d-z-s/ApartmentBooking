package me.mdzs.apartmentbooking.identification;

import java.util.List;

public interface UserDao<T> {
    T getUser(String user);
    List<T> getAll();
    void save(T user);
    void update(T user);
    void delete(T user);
}
