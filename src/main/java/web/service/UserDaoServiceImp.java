package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.module.User;
import org.springframework.stereotype.Service;
import web.service.UserDaoService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserDaoServiceImp implements UserDaoService {
    private final UserDao userDao;
    @Autowired
    public UserDaoServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public List<User> getUsersList() {
        return userDao.getUsersList();
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }
}
