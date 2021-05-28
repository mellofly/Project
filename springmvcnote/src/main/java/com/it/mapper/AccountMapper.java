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
     * 注册用户
     * @param account
     * @return
     * @throws Exception
     */
    public int addAccount(Account account)throws Exception;

    /**
     * 获取数据库中最大的ID
     * @return Account表中最大的id
     * @throws Exception
     */
    public int findMaxId()throws Exception;

    /**
     * 通过微信id获取用户信息
     * @param wxid
     * @return
     * @throws Exception
     */
    public Account findAcocuntBywxid(String wxid)throws Exception;

    /**
     * 通过输入code获取用户信息
     * @param code
     * @return
     * @throws Exception
     */
    public Account findAcocuntBycode(String code)throws Exception;

    public int setPhone(Account account)throws Exception;
}
