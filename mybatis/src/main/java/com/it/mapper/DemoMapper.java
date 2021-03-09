package com.it.mapper;

import com.it.po.Account;
import com.it.po.Demo;

import java.util.List;

public interface DemoMapper {
    /**
     * 根据用户id查询用户信息
     * @param
     * @return 用户信息
     * @throws Exception
     */
    public List<Demo> findAllDemo()throws Exception;
}
