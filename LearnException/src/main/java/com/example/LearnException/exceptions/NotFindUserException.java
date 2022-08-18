package com.example.LearnException.exceptions;

/**
 * @program: Learning-20220811
 * @description:
 * @author:
 * @created: 2022/08/17 17:10
 */
public class NotFindUserException extends Exception{
    public NotFindUserException() {
        super("找不到此用户");
    }

    public NotFindUserException(String message) {
        super(message);
    }
}
