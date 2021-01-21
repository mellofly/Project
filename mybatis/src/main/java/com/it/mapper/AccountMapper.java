package com.it.mapper;

import com.it.po.Account;

public interface AccountMapper {
    public Account findAccountById(int id)throws Exception;
}
