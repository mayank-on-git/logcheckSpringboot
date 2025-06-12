package com.logcheck.logcheck.config;


import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(MultiTenantProperties.class)
public class DataSourceConfig {

    @Autowired
    private MultiTenantProperties tenantProperties;


    @Bean
    @Primary
    public DataSource dataSource() {
        Map<Object, Object> dataSources = new HashMap<>();

        tenantProperties.getTenants().forEach((tenantId, props) -> {
            System.out.println("Loading tenant: " + tenantId + ", url: " + props.getUrl());
            DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create()
                    .url(props.getUrl())
                    .username(props.getUsername())
                    .password(props.getPassword())
                    .driverClassName("org.postgresql.Driver");

            dataSources.put(tenantId, dataSourceBuilder.build());
        });

        MultiTenantDataSource multiTenantDataSource = new MultiTenantDataSource();
        multiTenantDataSource.setTargetDataSources(dataSources);

        DataSource defaultDataSource = (DataSource) dataSources.get("tenant1");
        if (defaultDataSource == null) {
            throw new IllegalStateException("Default tenant 'tenant1' datasource not found!");
        }
        multiTenantDataSource.setDefaultTargetDataSource(defaultDataSource);
        multiTenantDataSource.afterPropertiesSet();  // Important: initialize the datasource routing map!

        System.out.println("Default tenant datasource set to tenant1");
        return multiTenantDataSource;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource,
            EntityManagerFactoryBuilder builder
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.logcheck.logcheck.entity")
                .persistenceUnit("default")
                .build();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
