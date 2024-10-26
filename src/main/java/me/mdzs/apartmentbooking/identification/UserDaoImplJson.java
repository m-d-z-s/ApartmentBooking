package me.mdzs.apartmentbooking.identification;

import me.mdzs.apartmentbooking.domain.User;
import me.mdzs.apartmentbooking.utils.JsonUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class UserDaoImplJson implements UserDao<User>{
    private JsonUtils<List<User>> json;
    String PATH = "resources/usersData.json";


    public UserDaoImplJson(){
        this.json = new JsonUtils<>(PATH);
        File file = new File(PATH);
    }

    /**
     * Получает пользователя по имени и паролю.
     * Используется для авторизации.
     *
     * @param user имя пользователя
     * @param password пароль пользователя
     * @return объект User, если пользователь найден и пароль совпадает, иначе null
     */
    @Override
    public Boolean getUser(String user, String password) {
        List<User> userList = getAll();
        for (User u : userList) {
            if (u.getUserName().equals(user) && u.getPassword().equals(password)) {
                return true; // Возвращаем пользователя, если имя и пароль совпадают
            }
        }
        return false; // Если пользователь не найден или пароль неверный
    }

    @Override
    public List<User> getAll() {
        return json.readJson();
    }

    @Override
    public void delete(User user) {
        List<User> userList = getAll();
        userList.removeIf(user1 -> user1.equals(user));

        //json.writeJson(); сохранение изменение
    }

    /**
     * Обновляет информацию о пользователе.
     *
     * @param userNew объект User с обновленной информацией
     */
    @Override
    public void update(User userNew) throws IOException {
        List<User> userList = getAll();
        json = new JsonUtils<>(PATH);//TODO: "работает ли стирание данных?"
        for (User user : userList){
            if (Objects.equals(user.getUserName(), userNew.getUserName())){
                user.setPassword(userNew.getPassword());
                break;
            }
        }
        json.writeListToJson(userList);
    }

    /**
     * Сохраняет нового пользователя.
     * Используется для регистрации нового пользователя.
     *
     * @param user объект User, который нужно сохранить
     * @throws IOException если не удалось сохранить пользователя в файл
     */
    @Override
    public void save(User user) throws IOException {
        List<User> userList = getAll();
        json.writeJson(user);
    }
}
