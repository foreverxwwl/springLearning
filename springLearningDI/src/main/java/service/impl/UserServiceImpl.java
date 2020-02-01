package service.impl;


import javafx.scene.chart.PieChart;
import service.UserService;

import java.util.Date;

/**
 * @outhor li
 * @create 2020-01-16 20:25
 */
public class UserServiceImpl implements UserService {
    private String name;
    private Integer age;
    private Date birthday;

    public UserServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveUser() {
        System.out.println("service"+name+","+age+","+birthday);
    }
}