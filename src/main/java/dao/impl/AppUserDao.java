package dao.impl;

import dao.AbstractDao;
import dao.UserDao;
import model.AppUser;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class AppUserDao extends AbstractDao implements UserDao {


    @Override
    public List<AppUser> getAll() {
        TypedQuery<AppUser> selectAllQuery = entityManager.createQuery("select u from AppUser u", AppUser.class);
        return selectAllQuery.getResultList();
    }

    @Override
    public void saveUser(AppUser user) {
        hibernateUtil.save(user);
    }

    @Override
    public void deleteUser(long id) {
        hibernateUtil.delete(AppUser.class, id);
    }

    @Override
    public AppUser getUserByEmail(String email) {
        TypedQuery<AppUser> selectByEmailQuery = entityManager.createQuery("select u from AppUser u where u.email = :email", AppUser.class);
        return selectByEmailQuery.setParameter("email", email).getSingleResult();
    }

    @Override
    public AppUser getUserByLogin(String login) throws NoResultException {
        TypedQuery<AppUser> selectByLoginQuery = entityManager.createQuery("select u from AppUser u where u.login = :login", AppUser.class);
        return selectByLoginQuery.setParameter("login", login).getSingleResult();
    }

    @Override
    public List<AppUser> getUsersByName(String name) {
        TypedQuery<AppUser> selectByNameQuery = entityManager.createQuery("select u from AppUser u where u.name = :name", AppUser.class);
        return selectByNameQuery.setParameter("name", name).getResultList();
    }

    @Override
    public boolean isUserValid(String login, String password) {
        try {
            AppUser userByLogin = getUserByLogin(login);
            if(userByLogin.getPassword().equals(password)) {
                return true;
            }
            return false;
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public List<AppUser> getFollowedUsers(String login) {
        return null;
    }

    @Override
    public List<AppUser> getFollowers(String login) {
        return null;
    }

    @Override
    public void follow(String currentUserLogin, String userLoginToFollow) {

    }

    @Override
    public void stopFollowing(String currentUserLogin, String userLoginToStopFollow) {

    }
}
