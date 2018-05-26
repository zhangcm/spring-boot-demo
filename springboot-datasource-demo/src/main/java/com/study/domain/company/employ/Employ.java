package com.study.domain.company.employ;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author zhangcm
 * @since 1.0, 2018/3/27 下午2:37
 */
@Data
@AllArgsConstructor
@Entity
@Table(name = "employ")
public class Employ implements Serializable {

    @Id
    private String empId;

    @Column
    private String name;

}
