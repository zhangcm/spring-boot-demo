package com.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

/**
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.study.domain.company",
        entityManagerFactoryRef = "coEntityManagerFactory",
        transactionManagerRef = CoJpaConfig.TRANSACTION_MANAGER
)
@AutoConfigureAfter(DataSourceConfig.class)
public class CoJpaConfig {

    public static final String TRANSACTION_MANAGER = "coTransactionManager";
    private static final String HIBERNATE_DIALECT = "hibernate.dialect";


    @Autowired
    private JpaProperties jpaProperties;

    @Value("${co.hibernate.dialect}")
    private String hibernateDialect;

    @Autowired
    @Qualifier("coDataSource")
    private DataSource coDataSource;

    @Bean(name = "coEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean coEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(coDataSource)
                .properties(getVendorProperties(coDataSource))
                .packages("com.study.domain.company")
                .persistenceUnit("ucPersistenceUnit")
                .build();
    }

    /**
     * 数据库类型不同时，会取主数据源的dialect，此处需单独设置一下
     */
    private Map<String, String> getVendorProperties(DataSource dataSource) {
        Map<String, String> properties = jpaProperties.getHibernateProperties(dataSource);
        properties.put(HIBERNATE_DIALECT, hibernateDialect);
        return properties;
    }

    @Bean(name = TRANSACTION_MANAGER)
    public PlatformTransactionManager coTransactionManager(EntityManagerFactoryBuilder builder) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(coEntityManagerFactory(builder).getObject());
        return transactionManager;
    }

}
