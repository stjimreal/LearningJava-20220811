package com.example.LearnException.exceptions;

/**
 * @program: Learning-20220811
 * @description:
 * @author:
 * @created: 2022/08/17 17:13
 */
public class DefaultAddressNotDeleteException extends Exception {
    public DefaultAddressNotDeleteException() {
        super ("不可删除默认地址");
    }

    public DefaultAddressNotDeleteException(String message) {
        super(message);
    }
}
