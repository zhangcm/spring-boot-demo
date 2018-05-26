package com.study.domain.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author zhangcm
 * @since 1.0, 2018/4/9 下午4:35
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    public Account save(String appId) {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);
        Account account = Account.builder()
                .appId(appId)
                .nickname(appId)
                .build();
        try {

            accountRepository.save(account);
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
        }
        return account;
    }

    public Account cancel(String appId) {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);
        throw new NullPointerException();
    }

}
