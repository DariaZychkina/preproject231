package web.dao;

import org.springframework.stereotype.Repository;
import web.module.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        
    }

    @Override
    @Transactional
    public List<User> getUsersList() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
}
