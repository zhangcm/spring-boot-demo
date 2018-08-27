package com.study.web;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.study.api.ExampleServerApi;
import org.springframework.stereotype.Service;

/**
 * @author zhangcm
 * @since 1.0, 2018/6/15 上午9:42
 */
@Service
@AutoJsonRpcServiceImpl
public class ExampleServerApiImpl implements ExampleServerApi {
    @Override
    public int multiplier(int a, int b) {
        return a * b;
    }
}
