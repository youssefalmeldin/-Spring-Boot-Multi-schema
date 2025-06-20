package com.example.multischema.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.multischema.repository.userrepo",
        entityManagerFactoryRef = "schema1EntityManagerFactory", transactionManagerRef = "schema1TransactionManager")

public class Schema1Config {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.schema1")
    public DataSource schema1DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "schema1EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean schema1EntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("schema1DataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("com.example.multischema.model.user").persistenceUnit("schema1").build();
    }

    @Primary
    @Bean(name = "schema1TransactionManager")
    public PlatformTransactionManager schema1TransactionManager(@Qualifier("schema1EntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
