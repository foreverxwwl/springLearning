package service.impl;

import DesignPattern.Factory.dao.UserDao;
import DesignPattern.Factory.factory.BeanFactory;
import DesignPattern.Factory.service.UserService;

/**
 * @outhor li
 * @create 2020-01-16 20:25
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = (UserDao) BeanFactory.getBean("userDao");

    @Override
    public void saveUser() {
        int i = 1;
        userDao.saveUser();
        System.out.println(i);
        i++;
    }
}