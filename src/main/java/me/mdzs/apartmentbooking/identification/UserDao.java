package me.mdzs.apartmentbooking.identification;

import me.mdzs.apartmentbooking.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserDao<T> {
    User getUser(String user) throws IOException;
    List<T> getAll() throws IOException;
    void save(T user) throws IOException;
    void update(T user) throws IOException;
    void delete(T user) throws IOException;
}
