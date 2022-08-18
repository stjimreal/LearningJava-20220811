package com.example.LearnException.exceptions;

import com.sun.javaws.ui.ApplicationIconGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @program: Learning-20220811
 * @description:
 * @author:
 * @created: 2022/08/18 10:13
 */

@NoArgsConstructor
public class ApiException extends RuntimeException {
    @Getter
    @Setter
    protected  Long errorCode;
    @Getter
    @Setter
    protected Object data;

    public  ApiException(Long errorCode, String message, Object data, Throwable e) {
        super(message, e);
        this.errorCode = errorCode;
        this.data = data;
    }

    public ApiException(Long errorCode, String message, Object data) {
        this(errorCode, message, data, null);
    }

    public ApiException(Long errorCode, String message) {
        this(errorCode, message, null);
    }

    public ApiException(String message, Throwable e) {
        this(null, message, null, e);
    }

    public ApiException(Throwable e) {
        super(e);
    }
}

