package com.it.mapper;

import com.it.po.Account;

import java.util.List;

public interface AccountMapper {

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return 用户信息
     * @throws Exception
     */
    public Account findAccountById(int id)throws Exception;


}
