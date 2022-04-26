package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getAllUsers();
    void deleteUser(Long id);
    User getUser(Long id);
    void updateUser(User user);
}
