package web.dao;

import org.springframework.stereotype.Repository;
import web.module.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
       entityManager.remove(getById(id));

    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override //@Transactional ставиться для указания, что для работы метода нужно открытое соединение с бд. А здесь я использую запрос к бд....... 
    public List<User> getUsersList() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }
}
