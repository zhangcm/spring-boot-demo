package com.study.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.sql.DataSource;

/**
 * @author zhangcm
 * @since 1.0, 2017/5/15 下午4:26
 */
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix="spring.datasource.sc") // 使用不同配置前缀区分
    public DataSourceProperties scDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean(name = "scDataSource")
    public DataSource scDataSource(@Qualifier("scDataSourceProperties") DataSourceProperties scDataSourceProperties) {
        return scDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.co") // 使用不同配置前缀区分
    public DataSourceProperties coDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean(name = "coDataSource")
    @Primary // 默认数据源
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource coDataSource(DataSourceProperties coDataSourceProperties) {
        return coDataSourceProperties.initializeDataSourceBuilder().build();
    }

}
