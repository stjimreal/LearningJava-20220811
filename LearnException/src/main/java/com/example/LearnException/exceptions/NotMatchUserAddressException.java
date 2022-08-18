package com.example.LearnException.exceptions;

/**
 * @program: Learning-20220811
 * @description:
 * @author:
 * @created: 2022/08/17 17:15
 */
public class NotMatchUserAddressException extends Exception {
    public NotMatchUserAddressException() {
        super("当前用户找不到匹配地址");
    }
    public NotMatchUserAddressException(String message) {
        super(message);
    }
}
