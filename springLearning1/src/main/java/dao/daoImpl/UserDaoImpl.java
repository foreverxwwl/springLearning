package dao.daoImpl;

import dao.UserDao;

/**
 * @outhor li
 * @create 2020-01-16 20:26
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存了用户");
    }
}
