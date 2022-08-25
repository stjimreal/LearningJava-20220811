package com.examplellj.jdbctemplatedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

@SpringBootApplication
@Slf4j
public class JdbcTemplateDemoApplication implements CommandLineRunner {

	@Autowired
	private FooDao fooDao;
	@Autowired
	private FooBatchDao fooBatchDao;


	public static void main(String[] args) {
		SpringApplication.run(JdbcTemplateDemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		fooDao.listData();
		fooDao.insertData();
		fooBatchDao.batchInsert();
		fooDao.listData();
	}
}
