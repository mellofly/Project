package com.it.service.impl;

import com.it.mapper.AccountMapper;
import com.it.po.Account;
import com.it.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public Account findAccountById(int id) throws Exception {
         return accountMapper.findAccountById(id);
    }
}
