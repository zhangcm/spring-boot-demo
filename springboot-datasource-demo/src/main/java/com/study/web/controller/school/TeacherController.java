package com.study.web.controller.school;

import com.study.domain.school.teacher.Teacher;
import com.study.domain.school.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangcm
 * @since 1.0, 2018/3/27 下午3:10
 */
@RestController
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping("/teacher/save")
    public ResponseEntity<Teacher> save(@RequestParam("id") String id,
                                        @RequestParam("name") String name) {
        Teacher teacher = new Teacher(id, name);
        return ResponseEntity.ok(teacherService.save(teacher));
    }

    @RequestMapping("/teacher/{id}")
    public ResponseEntity<Teacher> find(@PathVariable("id") String id) {
        return ResponseEntity.ok(teacherService.find(id));
    }

}
