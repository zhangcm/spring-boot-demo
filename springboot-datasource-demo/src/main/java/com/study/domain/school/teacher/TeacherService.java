package com.study.domain.school.teacher;

import com.study.config.ScJpaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangcm
 * @since 1.0, 2018/3/27 下午3:12
 */
@Service
@Transactional(transactionManager = ScJpaConfig.TRANSACTION_MANAGER)
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher find(String id) {
        return teacherRepository.findOne(id);
    }

}
