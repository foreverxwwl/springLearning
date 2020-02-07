package com.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @outhor li
 * @create 2020-02-04 16:58
 * 接的工具类，它用于从数据源中获取一个连接，并且实现和线程的绑定
 */

public class ConnectionUtils {
    private ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection(){
        try {
            //1.先从ThreadLocal上获取连接
            Connection conn = t1.get();
            //2.判断当前线程上是否有连接
            if (conn == null){
                //3.从数据源获取连接,存入ThreadLocal
                conn = dataSource.getConnection();
                t1.set(conn);
            }
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 把数据连接和线程解绑
     * 要不然下次再线程池中获取的线程绑定有一个关闭了的数据连接
     */
    public void removeConnection(){
        t1.remove();
    }
}
