import dao.UserDao;
import dao.impl.AppUserDao;
import model.AppUser;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        UserDao userDao = new AppUserDao();
        AppUser user1 = new AppUser();
        user1.setLogin("Mark");
        user1.setLastName("Surname");
        user1.setName("Mark");
        user1.setDateOfRegistration(new Date());
        user1.setPassword("**8***");
        userDao.saveUser(user1);

        AppUser user2 = new AppUser();
        user2.setLogin("Makaron");
        user2.setLastName("Surname");
        user2.setName("Marokan");
        user2.setDateOfRegistration(new Date());
        user2.setPassword("**8***");
        userDao.saveUser(user2);


        userDao.follow("Mark", "Makaron");
        AppUser makaron = userDao.getUserByLogin("Makaron");
        Set<AppUser> followers = makaron.getFollowers();
        userDao.stopFollowing("Mark", "Makaron");
        AppUser makaron1 = userDao.getUserByLogin("Makaron");
        HashSet<AppUser> followers1 = userDao.getFollowers(makaron1.getLogin());


        System.out.println(followers1.size());
        userDao.saveUser(makaron1);
        returnTest();
    }
    public static void returnTest() {
        if(true) {
            System.out.println("IN if");
            return;
        }
        System.out.println("outside");
    }
}
