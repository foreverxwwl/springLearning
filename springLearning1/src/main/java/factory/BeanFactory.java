package factory;

/**
 * @outhor li
 * @create 2020-01-16 20:27
 */

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 *
 * Bean指在计算机中表示可重用组件
 * JavaBean指用java编写的可重用组件
 *
 * 通过一个工厂组件创建service和dao对象
 * 第一个：需要一个配置文件来配置service和dao
 *        配置内容：唯一标识=全限定类名 （key=value）
 * 第二个：通过读取配置文件内容，反射创建对象
 */
public class BeanFactory {
    //定义一个Properties对象
    private static Properties properties;
    //定义一个Map。用于存放我们要创建的对象，看做容器
    private static Map<String, Object> beans;
    //使用静态代码块为Properties对象复制
    static {
        try{
            //实例化对象
            properties = new Properties();
            //获取properties文件流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("DesignPattern/Factory/resources/bean.properties");
            properties.load(in);
            //实例化容器
            beans = new  HashMap<String, Object>();
            //读取配置文件
            Enumeration keys = properties.keys();
            //遍历取出key
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //更具key获取value
                String beanPath = properties.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器
                beans.put(key, value);
            }

        }catch (Exception e){
            throw new ExceptionInInitializerError("初始化properties对象失败");
        }
    }

    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
}
