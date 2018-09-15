package com.zhangyi.zip;

import java.io.Serializable;

public class myFile implements Serializable {
    private String name;
    private Long time;
    private Long length;
    private Long addr;

    @Override
    public String toString() {
        return  name +
                "," + time +
                "," + length +
                "," + addr;
    }
    public myFile(String name, Long time, Long length, Long addr) {
        this.name = name;
        this.time = time;
        this.length = length;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getAddr() {
        return addr;
    }
    public void setAddr(Long addr) {
        this.addr = addr;
    }
}
