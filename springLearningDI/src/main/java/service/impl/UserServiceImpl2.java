package service.impl;


import service.UserService;

import java.util.Date;

/**
 * @outhor li
 * @create 2020-01-16 20:25
 */
public class UserServiceImpl2 implements UserService {
    private String name;
    private Integer age;
    private Date birthday;

    public void setUserName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveUser() {
        System.out.println("service"+name+","+age+","+birthday);
    }
}