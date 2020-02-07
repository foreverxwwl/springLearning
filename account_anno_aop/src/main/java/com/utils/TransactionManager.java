package com.utils;

import org.aspectj.lang.annotation.*;

/**
 * @outhor li
 * @create 2020-02-04 17:06
 * 和事务管理相关的工具类，它包含了，开启事务，提交事务，回滚事务和释放连接
 *
 */

@Aspect//表示当前类是一个切面类
public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    @Pointcut("execution(* com.service.impl.*.*(..))")
    private void pt1(){}
    /**
     * 开启事务
     */
    @Before("pt1()")
    public void beginTransaction(){
        try {
            //手动提交
            System.out.println("开启了事务");
            connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 提交事务
     */
    @AfterReturning("pt1()")
    public void commit(){
        try {
            System.out.println("提交了事务");
            connectionUtils.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    @AfterThrowing("pt1()")
    public void rollback(){
        try {
            System.out.println("回滚了事务");
            connectionUtils.getThreadConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    @After("pt1()")
    public void release(){
        try {
            System.out.println("释放了事务");
            connectionUtils.getThreadConnection().close();//还回连接池中
            connectionUtils.removeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
