package service.impl;


import dao.UserDao;
import service.UserService;

/**
 * @outhor li
 * @create 2020-01-16 20:25
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    public UserServiceImpl(){
        System.out.println("对象创建了");
    }

    public void saveUser() {
        userDao.saveUser();
    }
}