package com.it.service;

import com.it.po.Account;

import java.util.List;

public interface AccountService {
    //根据id账户信息查询
    public Account findAccountById(int id) throws Exception;
}
