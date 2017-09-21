package com.study.service;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @since 1.0, 2017/7/21 下午2:16
 */
@Service
@EnableConfigurationProperties(ConfigProperties.class)
public class ConfigService {

    @Resource
    private ConfigProperties configProperties;

    public String getName() {
        return configProperties.getName();
    }

    public String getHost() {
        return configProperties.getHost();
    }

}