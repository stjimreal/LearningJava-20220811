package com.examplellj.multidatasourcedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @program: Learning-20220811
 * @description:
 * @author: liuljing
 * @created: 2022/08/24 09:23
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, JdbcTemplateAutoConfiguration.class})
@Slf4j
public class MultipleDataSourceRunner implements CommandLineRunner {

    @Bean
    @ConfigurationProperties("foo.datasource")
    public DataSourceProperties fooDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("bar.datasource")
    public DataSourceProperties barDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource fooDataSource() {
        DataSourceProperties fooDataSourceProperties = fooDataSourceProperties();
        log.info("foo properties url: " + fooDataSourceProperties.getUrl());
        return fooDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    public DataSource barDataSource() {
        DataSourceProperties barDataSourceProperties = barDataSourceProperties();
        log.info("bar properties url: " + barDataSourceProperties.getUrl());

        return barDataSourceProperties.initializeDataSourceBuilder().build();
    }

    public static void main(String[] args) {
        SpringApplication.run(MultipleDataSourceRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("fooDataSource: " + fooDataSource().toString());
        log.info("fooDataSource: " + fooDataSource().getConnection().toString());
        log.info("barDataSource: " + barDataSource().toString());
        log.info("barDataSource: " + barDataSource().getConnection().toString());
    }
}
