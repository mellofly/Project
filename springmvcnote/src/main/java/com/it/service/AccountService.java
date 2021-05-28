package com.it.service;

import com.it.po.Account;

public interface AccountService {

    public Account findAccountById(int id) throws Exception;

    public int addAccount(Account account)throws Exception;

    public int findmaxid()throws Exception;

    public Account findAccountByCode(String code)throws Exception;

    public int updatephone(Account account)throws  Exception;

    public Account selectAccountBycode(String code)throws Exception;
}
