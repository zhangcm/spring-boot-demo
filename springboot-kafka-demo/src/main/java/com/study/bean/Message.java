package com.study.bean;

import java.io.Serializable;

/**
 * @author zhangcm
 * @since 1.0, 2018/8/7 下午4:38
 */
public class Message implements Serializable {

    private Long id;

    private String msg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
