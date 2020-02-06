package com.service.impl;

import com.dao.AccountDao;
import com.domain.Account;
import com.service.AccountService;

import java.util.List;

/**
 * @outhor li
 * @create 2020-02-03 18:38
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    public void transfer(String name1, String name2, Integer money) {
        Account account1 = accountDao.findAccountByName(name1);
        Account account2 = accountDao.findAccountByName(name2);
        account1.setMoney(account1.getMoney() - money);
        account2.setMoney(account2.getMoney() + money);
        accountDao.updateAccount(account1);
        int i = 1/0;
        accountDao.updateAccount(account2);
    }

}
