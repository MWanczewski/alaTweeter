package dao;

import model.AppUser;

import java.util.List;

public interface UserDao {

    List<AppUser> getAll();

    void saveUser(AppUser user);

    void deleteUser(long id);

    AppUser getUserByEmail(String email);

    AppUser getUserByLogin(String login);

    List<AppUser> getUsersByName(String name);

    boolean isUserValid(String login, String password);

    List<AppUser> getFollowedUsers(String login);

    List<AppUser> getNotFollowedUsers(String login);

    List<AppUser> getFollowers(String login);

    void follow(String currentUserLogin, String userLoginToFollow);

    void stopFollowing(String currentUserLogin, String userLoginToStopFollow);

}
