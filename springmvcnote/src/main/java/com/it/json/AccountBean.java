package com.it.json;


public class AccountBean {
    public AbstractJsonObject message;
    public Object obj;

    public AbstractJsonObject getAbstractJsonObject() {
        return message;
    }

    public void setAbstractJsonObject(AbstractJsonObject abstractJsonObject) {
        this.message = abstractJsonObject;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
