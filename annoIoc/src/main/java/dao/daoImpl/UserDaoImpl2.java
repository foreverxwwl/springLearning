package dao.daoImpl;

import dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @outhor li
 * @create 2020-01-16 20:26
 */

@Repository("userDao2")
public class UserDaoImpl2 implements UserDao {
    

    public void saveUser() {
        System.out.println("保存了用户222222222222");
    }
}
