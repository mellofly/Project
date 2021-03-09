package com.it.po;

public class Demo {

    private String demo_one;
    private String demo_two;

    public String getDemo_one() {
        return demo_one;
    }

    public void setDemo_one(String demo_one) {
        this.demo_one = demo_one;
    }

    public String getDemo_two() {
        return demo_two;
    }

    public void setDemo_two(String demo_two) {
        this.demo_two = demo_two;
    }
    public String toString(){
        return demo_one+demo_two;
    }
}
