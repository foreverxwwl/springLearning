package Ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

/**
 * @outhor li
 * @create 2020-01-21 16:58
 */
public class UI {

    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.更具id获取bean对象
        //UserService userService = ac.getBean("userService",UserService.class);

       // UserService userService = ac.getBean("userService2",UserService.class);
        UserService userService = ac.getBean("userService3",UserService.class);

        userService.saveUser();
    }
}
