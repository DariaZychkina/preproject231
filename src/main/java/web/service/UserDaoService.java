package web.service;

import web.module.User;

import java.util.List;

public interface UserDaoService {
    public void addUser(User user);
    public void deleteUser(User user);
    public void updateUser(User user);
    public List<User> getUsersList();

}
