package com.bawei.entity;

import lombok.Data;

@Data
public class UserVo extends User{

    int current=1;
    int size=3;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int Size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "current=" + current +
                ", size=" + size +
                "} " + super.toString();
    }
}
