package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void addUser(web.model.User user);
    List<User> getAllUsers();
    void deleteUser(Long id);
    User getUser(Long id);
    void updateUser(User user);

}
