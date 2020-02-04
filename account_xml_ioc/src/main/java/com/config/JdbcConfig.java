package com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * @outhor li
 * @create 2020-02-04 10:44
 * spring连接数据库的相关配置
 */

public class JdbcConfig {

    //从配置文件读取配置信息
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /**
     * 创建一个QueryRunner对象
     */
    @Bean(name = "runner")
    @Scope(value = "prototype") //对象是单例的
    public QueryRunner createQueryRunner(@Qualifier("ds1") DataSource dataSource){
        //@Qualifier("ds1") 注解在注入的时候也是自动按照类型注入。然后在寻找id注入 当都一样时使用此注解
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据源对象
     */
    @Bean(name = "ds1")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }



}
