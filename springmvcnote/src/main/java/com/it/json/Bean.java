package com.it.json;

import java.util.ArrayList;
import java.util.List;

public class Bean {
    private List<User> listuser = new ArrayList();

    private Bean() {
    }

    public List<User> getListuser() {
        return this.listuser;
    }

    public void setListuser(List<User> listuser) {
        this.listuser = listuser;
    }
}
