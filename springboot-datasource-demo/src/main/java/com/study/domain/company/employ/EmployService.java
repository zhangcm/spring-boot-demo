package com.study.domain.company.employ;

import com.study.config.CoJpaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangcm
 * @since 1.0, 2018/3/27 下午3:11
 */
@Service
@Transactional(transactionManager = CoJpaConfig.TRANSACTION_MANAGER)
public class EmployService {

    private final EmployRepository employRepository;

    @Autowired
    public EmployService(EmployRepository employRepository) {
        this.employRepository = employRepository;
    }

    public Employ save(Employ employ) {
        return employRepository.save(employ);
    }

    public Employ find(String id) {
        return employRepository.findOne(id);
    }
}
