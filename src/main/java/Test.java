import dao.UserDao;
import dao.impl.AppUserDao;
import model.AppUser;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        AppUserDao userDao = new AppUserDao();
        AppUser stefan = new AppUser();
        stefan.setLogin("Stefan");
        stefan.setEmail("stefan@wp.pl");
        userDao.saveUser(stefan);

        AppUser mirek = new AppUser();
        mirek.setLogin("Miras");
        mirek.setEmail("mirek@wp.pl");
        userDao.saveUser(mirek);

        userDao.follow(stefan.getLogin(), mirek.getLogin());
        userDao.getFollowers(mirek.getLogin()).forEach(System.out::println);

        mirek = userDao.getUserByLogin(mirek.getLogin());

        userDao.getFollowers(mirek.getLogin()).forEach(System.out::println);
        userDao.deleteUser(mirek.getId());
        userDao.getAll().forEach(System.out::println);


    }

}
