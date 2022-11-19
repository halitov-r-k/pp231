package app.dao;

import app.models.User;

import java.util.List;

public interface AppDao {
    List<User> getUserList();

    void saveUser(User user);
}
