package service.impl;


import dao.UserDao;
import dao.daoImpl.UserDaoImpl;
import service.UserService;

/**
 * @outhor li
 * @create 2020-01-16 20:25
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    public UserServiceImpl(){
        System.out.println("对象创建了");
    }
    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}