package com.study.web.controller.company;

import com.study.domain.company.employ.Employ;
import com.study.domain.company.employ.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangcm
 * @since 1.0, 2018/3/27 下午3:09
 */
@RestController
public class EmployController {

    private final EmployService employService;

    @Autowired
    public EmployController(EmployService employService) {
        this.employService = employService;
    }

    @RequestMapping("/employ/save")
    public ResponseEntity<Employ> save(@RequestParam("id") String id,
                                       @RequestParam("name") String name) {
        Employ teacher = new Employ(id, name);
        return ResponseEntity.ok(employService.save(teacher));
    }

    @RequestMapping("/employ/{id}")
    public ResponseEntity<Employ> find(@PathVariable("id") String id) {
        return ResponseEntity.ok(employService.find(id));
    }
}
