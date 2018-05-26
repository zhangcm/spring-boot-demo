package com.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
        basePackages = {"com.study.domain.school"},
        entityManagerFactoryRef = "scEntityManager",
        transactionManagerRef = ScJpaConfig.TRANSACTION_MANAGER
)
@AutoConfigureAfter(DataSourceConfig.class)
public class ScJpaConfig {

    public static final String TRANSACTION_MANAGER = "scTransactionManager";

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    @Qualifier("scDataSource")
    private DataSource scDataSource;

    @Bean(name = "scEntityManager")
    public LocalContainerEntityManagerFactoryBean scEntityManager(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(scDataSource)
                .properties(getVendorProperties(scDataSource))
                .packages("com.study.domain.school")
                .persistenceUnit("scPersistenceUnit")
                .build();
    }

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Bean(name = TRANSACTION_MANAGER)
    public PlatformTransactionManager scTransactionManager(EntityManagerFactoryBuilder builder) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(scEntityManager(builder).getObject());
        return transactionManager;
    }

}
