package com.study.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @since 1.0, 2017/9/21 上午9:28
 */
@Data
@ConfigurationProperties(prefix = "demo.config")
public class ConfigProperties {

    private String name;
    private String host;
}
