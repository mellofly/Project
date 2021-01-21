package com.it.dao.impl;

import com.it.dao.AccountDao;
import com.it.po.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class AccountDaoImpl implements AccountDao {
    private SqlSessionFactory sqlSessionFactory;
    public AccountDaoImpl(SqlSessionFactory s){
        this.sqlSessionFactory=s;
    }
    public Account findAccountById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Account account =sqlSession.selectOne("test.findAccountById",id);
        sqlSession.close();
        return account;
    }
}
