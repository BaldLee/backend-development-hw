package com.hw.task4.Entity;


import java.sql.Timestamp;

public class Product {
    private int content = 0;
    private long setTime = 0;

    public Product(int i) {
        content = i;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public long getSetTime() {
        return setTime;
    }

    public void setSetTime(long setTime) {
        this.setTime = setTime;
    }
}
