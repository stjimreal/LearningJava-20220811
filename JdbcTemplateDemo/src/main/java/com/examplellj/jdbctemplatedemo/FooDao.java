package com.examplellj.jdbctemplatedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: Learning-20220811
 * @description: 演示 simpleJdbcInsert 和 jdbcTemplate 接口插入的方式，
 * @author: liuljing
 * @created: 2022/08/24 20:27
 */
@Slf4j
@Repository
public class FooDao {
    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertData() {
        Arrays.asList("b", "c").forEach(bar -> {
            int update = jdbcTemplate.update("INSERT INTO FOO (BAR) VALUES (?)", bar);
            log.info("update: " + update);
        });

        HashMap<String, String> row = new HashMap<>();
        row.put("BAR", "d");
        Number id = simpleJdbcInsert.executeAndReturnKey(row);
        log.info("ID of d: {}", id.longValue());
    }

    public void listData() {
        log.info("Count: {}",
                jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO", Long.class));

        List<String> list = jdbcTemplate.queryForList("SELECT BAR FROM FOO", String.class);
        list.forEach(bar -> log.info("Bar: " + bar));

        List<Foo> fooList = jdbcTemplate.query("SELECT * FROM FOO", (rs, rowNum) -> Foo.builder()
                .id(rs.getLong(1))
                .bar(rs.getString(2))
                .build());
        fooList.forEach(foo -> log.info("Foo: {}", foo));
    }

}
