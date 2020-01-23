package factory;

import service.UserService;
import service.impl.UserServiceImpl;

/**
 * @outhor li
 * @create 2020-01-22 20:16
 */
public class StaticFactory {
    public static UserService getUserService(){
        return new UserServiceImpl();
    }
}
