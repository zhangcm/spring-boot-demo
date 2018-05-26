package com.study.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangcm
 * @since 1.0, 2017/10/30 上午11:34
 */
@RestController
public class HomeController {


    @RequestMapping("/home")
    public ResponseEntity<String> home() {
        System.out.println(234);
        return ResponseEntity.ok("index");
    }

}
