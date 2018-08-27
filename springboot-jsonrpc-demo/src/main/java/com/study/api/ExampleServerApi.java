package com.study.api;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;

/**
 * @author zhangcm
 * @since 1.0, 2018/6/15 上午9:40
 */
@JsonRpcService("/calc")
public interface ExampleServerApi {

    int multiplier(@JsonRpcParam(value = "a") int a, @JsonRpcParam(value = "b") int b);

}
