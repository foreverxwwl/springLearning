package com.service;

import com.domain.Account;

import java.util.List;

/**
 * @outhor li
 * @create 2020-02-03 18:37
 */
public interface AccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    /**
     * 转账
     * @param name1
     * @param name2
     * @param money
     */
    void transfer(String name1, String name2, Integer money);
}
