import com.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * @outhor li
 * @create 2020-02-08 9:16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml" )
public class test {
    @Autowired
    private AccountService as;

    @Test
    public void testTransfer(){
        as.transfer("aaa", "bbb", 100f);
    }
}
