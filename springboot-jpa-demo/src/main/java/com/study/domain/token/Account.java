package com.study.domain.token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangcm
 * @since 1.0, 2018/3/21 下午3:46
 */
@Data
@Entity
@Table(name = "wx_official_account")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

    /**
     * 公众号编号
     */
    @Id
    private String appId;

    /**
     * 公众号昵称
     */
    @Column
    private String nickname;

    /**
     * 公众号头像
     */
    @Column
    private String headImg;

    @ElementCollection(targetClass = Fans.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "wx_fans", joinColumns = @JoinColumn(name = "app_id"))
    private Set<Fans> fansSet;

    public void addFans(Fans fans) {
        if (fansSet == null) {
            fansSet = new HashSet<>();
        }
        fansSet.add(fans);
    }
}
