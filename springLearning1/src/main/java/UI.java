import dao.UserDao;
import dao.daoImpl.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;
import service.impl.UserServiceImpl;

/**
 * @outhor li
 * @create 2020-01-21 16:58
 */
public class UI {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        UserService userService = (UserService)ac.getBean("userService");
//        UserDao userDao = (UserDao) ac.getBean("userDao");
//        UserDao userDao = (UserDao) ac.getBean("userDao", UserDaoImpl.class);

        System.out.println(userService);
//        System.out.println(userDao);
        userService.saveUser();
    }
}
