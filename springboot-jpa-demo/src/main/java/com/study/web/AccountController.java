package com.study.web;

import com.study.domain.token.Account;
import com.study.domain.token.AccountRepository;
import com.study.domain.token.AccountService;
import com.study.domain.token.Fans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * @author zhangcm
 * @since 1.0, 2018/3/21 下午3:54
 */
@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/account/save")
    public ResponseEntity<Account> saveAccount() {
        Fans fans = Fans.builder().openId("f001").nick("f001").build();
        Account account = Account.builder().appId("a001").nickname("a0001").build();
        account.addFans(fans);
        accountRepository.save(account);
        return ResponseEntity.ok(account);
    }

    @RequestMapping("/fans/add/{openId}")
    public ResponseEntity<Account> saveAccount(@PathVariable("openId") String openId) {
        Account account = accountRepository.getOne("a001");
        account.setNickname("hahaha");
        Fans fans = Fans.builder().openId(openId).nick(openId).build();
        account.addFans(fans);
        account = accountRepository.save(account);
        return ResponseEntity.ok(account);
    }

    @RequestMapping("/account/txsave/{appId}")
    public ResponseEntity<Account> txSave(@PathVariable("appId") String appId) {
        Account account = accountService.save(appId);
        return ResponseEntity.ok(account);
    }

    @RequestMapping("/account/cancel/{appId}")
    public ResponseEntity<Account> txCancel(@PathVariable("appId") String appId) {
        Account account = accountService.cancel(appId);
        return ResponseEntity.ok(account);
    }


}
