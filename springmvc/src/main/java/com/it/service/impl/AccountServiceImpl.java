package com.it.service.impl;

import com.it.mapper.AccountMapper;
import com.it.po.Account;
import com.it.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class AccountServiceImpl implements AccountService {
    //数据库mapper层查询
    @Autowired
    private AccountMapper accountMapper;

    /**
     * 查询所有用户信息
     * @return
     * @throws Exception
     */
    public List<Account> findListAccount() throws Exception {
        return accountMapper.findListAccount();
    }

    /**
     * 根据id查询用户信息
     * @return
     * @throws Exception
     */
    public Account findAccountById(int id) throws Exception {
        return accountMapper.findAccountById(id);
    }
}
