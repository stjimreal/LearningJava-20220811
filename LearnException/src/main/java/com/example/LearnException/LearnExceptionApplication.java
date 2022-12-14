package com.example.LearnException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
@Slf4j
public class LearnExceptionApplication implements CommandLineRunner {

    @Resource
    DataSource dataSource;
    public static void main(String[] args) {
        SpringApplication.run(LearnExceptionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("The DataSource is " + dataSource.toString());
        Connection conn = dataSource.getConnection();
        log.info("Your Connection is " + conn.toString());
        conn.close();
    }
}
