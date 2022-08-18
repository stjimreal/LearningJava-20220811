# Java 异常类

## 异常类继承关系讲解

Throwable -> Exception -> RuntimeException
        ->   Error -> ThreadDeath

RuntimeException和Error之外的Exception是可以进行捕获处理的异常，函数需要显示说明这些可能抛出的错误，否则编译无法正常通过，ThreadDeath类是一种常见的异常，但是因为用户可能会默认写捕捉所有Exception的try-catch异常处理，因此在JDK 7改为继承Error类。  
RuntimeException是在JVM正常运行时抛出的错误，Error是程序处理不了的JVM严重错误（例如OutOfMemoryError）及编译期出错。

## 应用开发过程中异常类设计最佳实践

[如何优雅的设计java异常](http://lrwinx.github.io/2016/04/28/%E5%A6%82%E4%BD%95%E4%BC%98%E9%9B%85%E7%9A%84%E8%AE%BE%E8%AE%A1java%E5%BC%82%E5%B8%B8/)

### 1、在Api层设置ExceptionHandler捕获统一处理异常 
1、设置Handler  
2、编写统一处理异常类继承RuntimeException  
3、在Controller层处理异常并且可以设置异常码

### 2、在Service层设置异常的两种方式

1、抛出带状态码 Exception 异常  
2、抛出指定类型的继承 Exception 异常
