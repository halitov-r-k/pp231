package app.service;

import app.dao.AppDao;
import app.models.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AppServiceImp implements AppService{
    private final AppDao appDao;

    public AppServiceImp(AppDao appDao) {
        this.appDao = appDao;
    }

    @Override
    @Transactional
    public List<User> getUserList() {
        return appDao.getUserList();
    }

    @Transactional
    @Override
    public void saveUser(User user) { appDao.saveUser(user); }

    @Override
    @Transactional
    public User getUser(Integer id) { return appDao.getUser(id); }

    @Override
    @Transactional
    public void deleteUser(Integer id) { appDao.deleteUser(id); }
}
