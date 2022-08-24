# Spring Boot的自动配置

## AutoConfiguration和 Configuration 的区别是什么？

1. AutoConfiguration 和 Configuration 的区别是什么？
2. 为什么 SpringBootApplication 的 exclude 不能作用于@AutoConfiguration类？
3. 为什么标记为 @AutoConfiguration 的类自动解除了DataSource Bean的循环依赖？而标记为 Configuration 却无法做到？

## SpringBootApplication

==> SpringBootConfiguration + EnableAutoConfiguration + ComponentScan

## 由两个 DataSource Bean 造成的循环依赖是什么？是如何解除的？

循环依赖？

1. 在其中一个不使用Spring Boot自动配置的 main 启动类配置文件 .xml 中限定组件扫描位置，区分DataSource位置
2. 在另一个配置了@SpringBootApplication的main启动类中装配另一个类时，标记对方为 @AutoConfiguration


## Spring Data 包括哪些配置？

### 数据源相关 DataSource

DataSourceAutoConfiguration

#### 配置多数据源的方法

`@ConfigurationProperties`构建`DataSourceProperty`对象来构建多个DataSource

### 事务管理相关 TransactionManager/TransactionTemplate

DataSourceTransactionManagerAutoConfiguration

### 操作相关 JdbcTemplate

JdbcTemplateAutoConfiguration