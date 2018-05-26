package com.study.domain.token;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangcm
 * @since 1.0, 2018/3/21 下午3:50
 */
public interface AccountRepository extends JpaRepository<Account, String> {
}
