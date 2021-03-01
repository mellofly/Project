package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/Hello")
    public String hello(String value){
        if(value.equals("abc")){
            return "abc 你好";
        }
        else{
            return "你是谁，陌生人";
        }

    }
}
