import com.service.AccountService;
import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @outhor li
 * @create 2020-02-06 10:25
 */
public class AopTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = (AccountService) ac.getBean("accountService");

        as.saveAccount();
        as.updateAccount(1);
        as.deleteAccount();
    }
}
