## Repository注解

@Repository注解组件可以将持久层做一个标记，自动处理数据库操作产生的异常。

因为原生的java操作数据库所产生的异常只定义了几种，但是产生数据库异常的原因却有很多种，这样对于数据库操作的报错排查造成了一定的影响；而Spring拓展了原生的持久层异常，针对不同的产生原因有了更多的异常进行描述。所以，在注解了@Repository的类上如果数据库操作中抛出了异常，就能对其进行处理，转而抛出的是翻译后的spring专属数据库异常，方便我们对异常进行排查处理。


## Jdbc 的接口

### JdbcTemplate可以update query queryForObject queryForList batchInsert insert等操作

### namedParameterJdbcTemplate

### simpleJdbcInsert

## 遇到的问题

### 问题一：SpringBoot 2.7.3 与 2.1.2.RELEASE 版本对于Bean的循环解除有不同的判定，在新版中不主动解除循环

JdbcTemplate类和Dao存在循环引用，因此需要建立Configuration类，在 2.1.2.RELEASE 版本无此问题

### 问题二：未添加 SpringBoot 自动配置的 schema.sqlsq 和 data.sqlsq

```
	at com.examplellj.jdbctemplatedemo.JdbcTemplateDemoApplication.run(JdbcTemplateDemoApplication.java:32) [classes/:na]
	at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:771) [spring-boot-2.7.3.jar:2.7.3]
	... 5 common frames omitted
Caused by: org.h2.jdbc.JdbcSQLSyntaxErrorException: Table "FOO" not found (this database is empty); SQL statement:
```

### 问题三：2.7.3版本的 h2 语法 IDENTITY 发生了变化，需要使用 primary key 和 auto_increment

```h2
CREATE TABLE FOO (ID INT IDENTITY, BAR VARCHAR(64));
```

```
Caused by: org.h2.jdbc.JdbcSQLSyntaxErrorException: Syntax error in SQL statement "CREATE TABLE FOO (ID INT [*]IDENTITY, BAR VARCHAR(64))"; expected "ARRAY, INVISIBLE, VISIBLE, NOT NULL, NULL, AS, DEFAULT, GENERATED, ON UPDATE, NOT NULL, NULL, AUTO_INCREMENT, DEFAULT ON NULL, NULL_TO_DEFAULT, SEQUENCE, SELECTIVITY, COMMENT, CONSTRAINT, COMMENT, PRIMARY KEY, UNIQUE, NOT NULL, NULL, CHECK, REFERENCES, AUTO_INCREMENT, ,, )"; SQL statement:
```

#### 更改后：

```h2
CREATE TABLE FOO (ID INT AUTO_INCREMENT PRIMARY KEY, BAR VARCHAR(64));
```
