package com.study.service;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import org.springframework.stereotype.Service;

/**
 * @author zhangcm
 * @since 1.0, 2018/6/19 下午4:37
 */
@Service
public class CalculateService {

    public int add(CalcReq req) {
        return req.getA() + req.getB();
    }

    public int sub(@JsonRpcParam("a") int a, @JsonRpcParam("b") int b) {
        return a - b;
    }

}
