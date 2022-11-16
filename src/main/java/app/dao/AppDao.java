package app.dao;

import app.models.User;

import java.util.List;

public interface AppDao {
    public List<User> getListUsers();
}
