package com.it;

import com.it.po.Account;
import com.it.test.demo;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws Exception {
        demo tes = new demo();
        //tes.findUserByIdTest();
        Account account = new Account();
        account.setName("a");
        tes.findUserByMessageTest(account);
    }
}
