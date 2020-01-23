package factory;

import service.UserService;
import service.impl.UserServiceImpl;

/**
 * @outhor li
 * @create 2020-01-22 20:10
 */
public class InstanceFactory {

    public UserService getUserService(){
        return new UserServiceImpl();
    }
}
