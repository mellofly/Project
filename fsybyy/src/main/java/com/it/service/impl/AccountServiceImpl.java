package com.it.service.impl;


import com.it.po.Account;
import com.it.service.AccountService;


public class AccountServiceImpl implements AccountService {

    @Override
    public Account findAccountById(int id) throws Exception {
        Account account = new Account();
        account.setName("小明");
        account.setId(11);
        return account;
    }
}
