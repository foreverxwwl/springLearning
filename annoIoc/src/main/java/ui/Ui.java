package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

/**
 * @outhor li
 * @create 2020-02-01 20:58
 */
public class Ui {
    public static void main(String[] args) {
        //1.获取核心容器对象
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.更具id获取bean对象
        UserService userService = ac.getBean("userService", UserService.class);

        userService.saveUser();
        ac.close();

    }
}