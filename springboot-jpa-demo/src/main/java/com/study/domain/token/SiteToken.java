package com.study.domain.token;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author zhangcm
 * @since 1.0, 2018/3/21 下午4:53
 */
@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Entity
@Table(name = "wx_site_token")
public class SiteToken implements Serializable {

    @Id
    private String appId;

    private String verifyTicket;

    private String accessToken;

}
