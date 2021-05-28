package com.it.service.impl;

import com.it.mapper.AccountMapper;
import com.it.po.Account;
import com.it.service.AccountService;
import com.it.util.wx.WxLogUtils;
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

    @Override
    public int addAccount(Account account) throws Exception {
        return accountMapper.addAccount(account);
    }

    /**
     * 获取数据中最大的id
     * @return
     * @throws Exception
     */
    @Override
    public int findmaxid() throws Exception {
        return accountMapper.findMaxId();
    }

    /**
     * 判断是否用户存在
     * @param code
     * @return
     * @throws Exception
     */
    @Override
    public Account findAccountByCode(String code) throws Exception {
        return accountMapper.findAcocuntBycode(code);
    }

    @Override
    public int updatephone(Account account) throws Exception {
        return accountMapper.setPhone(account);
    }

    @Override
    public Account selectAccountBycode(String code) throws Exception {
        //根据code去微信查询openid
        Account returnData = WxLogUtils.jsCode2Session(code);

        Account account = (Account)returnData;
        //查询用户是否已经注册，如果没有注册进行注册操作。
        Account dbAccount = accountMapper.findAcocuntBywxid(account.getWx_id());
        if(dbAccount==null){
            return account;
        }
        else {
            return dbAccount;
        }
    }


}
