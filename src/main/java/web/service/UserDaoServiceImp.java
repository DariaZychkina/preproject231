package web.service;

import web.dao.UserDaoImp;
import web.module.User;
import org.springframework.stereotype.Service;
import web.service.UserDaoService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserDaoServiceImp implements UserDaoService {
    @Override
    @Transactional
    public void addUser(User user) {
        new UserDaoImp().addUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        new UserDaoImp().deleteUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        new UserDaoImp().updateUser(user);
    }

    @Override
    @Transactional
    public List<User> getUsersList() {
        return new UserDaoImp().getUsersList();
    }
}
