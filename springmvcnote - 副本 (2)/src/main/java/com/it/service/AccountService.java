package com.it.service;

import com.it.po.Account;

public interface AccountService {

    public Account findAccountById(int id) throws Exception;
}
