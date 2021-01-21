package com.it.test;

import com.it.mapper.AccountMapper;
import com.it.po.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class demo {
    public void findUserByIdTest() throws Exception {
        //mybatis配置文件
        String resource = "SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到SQLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //通过SqlSession操作数据库
        //第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
        //第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        //sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
        //Account user = sqlSession.selectOne("test.findAccountById",1);
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        Account account = accountMapper.findAccountById(1);
        System.out.println(account);

        //释放资源
        sqlSession.close();
    }
    public void findUserByMessageTest(Account account) throws Exception {
        //mybatis配置文件
        String resource = "SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到SQLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //通过SqlSession操作数据库
        //第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
        //第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        //sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
        //Account user = sqlSession.selectOne("test.findAccountById",1);
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        List<Account> accounts = accountMapper.findAccountsByMessage(account);
        int i=0;
        for (Account a:accounts) {
            System.out.println("第"+i+"个数据："+a);
            i++;
        }
        //释放资源
        sqlSession.close();
    }
}
