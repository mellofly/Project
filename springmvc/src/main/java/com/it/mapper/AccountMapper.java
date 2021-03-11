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
    /**
     * 根据用户id查询用户信息
     * @param
     * @return 用户信息
     * @throws Exception
     */
    public List<Account> findListAccount()throws Exception;
    /**
     *根据输入查询用户信息
     * @param account
     * @return
     * @throws Exception
     */
    public List<Account> findAccountsByMessage(Account account)throws Exception;


}
