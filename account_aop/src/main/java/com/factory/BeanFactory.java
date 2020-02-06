package com.factory;

import com.domain.Account;
import com.service.AccountService;
import com.service.impl.AccountServiceImpl;
import com.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @outhor li
 * @create 2020-02-05 20:16
 */
public class BeanFactory {
    private AccountService accountService;

    private TransactionManager txManager;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public final void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public AccountService getAccountService(){
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事物支持
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;

                        try {
                            //1.开启事物
                            txManager.beginTransaction();
                            //2.执行操作
                            rtValue = method.invoke(accountService, args);
                            //3.提交事物
                            txManager.commit();
                            return rtValue;
                        }catch (Exception e){
                            //4.回滚操作
                            txManager.rollback();
                            throw  new RuntimeException();
                        }finally {
                            //5.释放资源
                            txManager.release();
                        }

                    }
                });
    }
}
