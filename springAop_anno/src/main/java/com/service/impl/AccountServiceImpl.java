package com.service.impl;

import com.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @outhor li
 * @create 2020-02-06 9:30
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新"+i);

    }

    public int deleteAccount() {

        System.out.println("执行了删除");
        int i=1/0;
        return 0;
    }
}
