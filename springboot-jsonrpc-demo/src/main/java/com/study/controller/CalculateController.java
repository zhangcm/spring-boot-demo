package com.study.controller;

import com.googlecode.jsonrpc4j.JsonRpcServer;
import com.study.service.CalculateService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhangcm
 * @since 1.0, 2018/6/19 下午4:35
 */
@Controller
public class CalculateController implements InitializingBean {

    @Autowired
    private CalculateService calculateService;

    private JsonRpcServer jsonRpcServer;

    @RequestMapping("/add")
    public void add(HttpServletRequest req, HttpServletResponse res) throws IOException {
        jsonRpcServer.handle(req, res);
    }

    @RequestMapping("/sub")
    public void sub(HttpServletRequest req, HttpServletResponse res) throws IOException {
        jsonRpcServer.handle(req, res);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        jsonRpcServer = new JsonRpcServer(calculateService);
    }
}
