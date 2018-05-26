package com.study.web;

import com.study.domain.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangcm
 * @since 1.0, 2018/3/21 下午3:54
 */
@RestController
public class SiteTokenController {

    @Autowired
    private SiteTokenRepository siteTokenRepository;

    @RequestMapping("/site/token/save/{appId}")
    public ResponseEntity<SiteToken> saveAccount(@PathVariable String appId) {
        SiteToken siteToken = SiteToken.builder()
                .appId(appId)
                .verifyTicket(appId)
                .accessToken(appId)
                .build();
        siteTokenRepository.save(siteToken);
        return ResponseEntity.ok(siteToken);
    }

}
