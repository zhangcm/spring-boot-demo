package com.study.domain.token;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author zhangcm
 * @since 1.0, 2018/3/21 下午3:46
 */
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Fans implements Serializable {

    private String openId;

    private String nick;

}
