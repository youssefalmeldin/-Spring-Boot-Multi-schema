package com.example.multischema.config;


import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.multischema.repository.Productrepo",
        entityManagerFactoryRef = "schema2EntityManagerFactory",
        transactionManagerRef = "schema2TransactionManager"
)

public class Schema2Config {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.schema2")
    public DataSource schema2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "schema2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean schema2EntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("schema2DataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.multischema.model.product")
                .persistenceUnit("schema2")
                .build();
    }

    @Bean(name = "schema2TransactionManager")
    public PlatformTransactionManager schema2TransactionManager(
            @Qualifier("schema2EntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}