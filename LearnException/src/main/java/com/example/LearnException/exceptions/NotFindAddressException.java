package com.example.LearnException.exceptions;

/**
 * @program: Learning-20220811
 * @description:
 * @author:
 * @created: 2022/08/17 17:11
 */
public class NotFindAddressException extends Exception{
    public NotFindAddressException() {
        super ("找不到该地址");
    }

    public NotFindAddressException(String message) {
        super(message);
    }
}
