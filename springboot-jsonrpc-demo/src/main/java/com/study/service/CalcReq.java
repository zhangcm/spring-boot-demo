package com.study.service;

import java.io.Serializable;

/**
 * @author zhangcm
 * @since 1.0, 2018/6/19 下午5:48
 */
public class CalcReq implements Serializable {

    private int a;

    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
