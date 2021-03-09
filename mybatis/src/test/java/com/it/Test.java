package com.it;

import com.it.test.demotest;

import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        demotest tes = new demotest();
        Scanner scanner = new Scanner(System.in);
        String s;
        while(((s=scanner.next()).equals("over"))==false){
            tes.findDemoTest(s);
        }

    }
}
