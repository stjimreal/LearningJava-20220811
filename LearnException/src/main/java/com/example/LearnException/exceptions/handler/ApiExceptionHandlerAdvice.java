package com.example.LearnException.exceptions.handler;

import com.example.LearnException.exceptions.ApiException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @program: Learning-20220811
 * @description:
 *      代码中用到了@ControllerAdvice，这是spring MVC提供的一个特殊的切面处理。
 * @author: liuljing
 * @created: 2022/08/18 10:54
 */
@ControllerAdvice(annotations = Controller.class)
public class ApiExceptionHandlerAdvice {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorDTO> exception(Exception exception, HttpServletResponse response) {
        ErrorDTO errorDTO = new ErrorDTO();
        if (exception instanceof ApiException) {
            ApiException apiException = (ApiException) exception;
            errorDTO.setErrorCode(apiException.getErrorCode());
        } else {
            errorDTO.setErrorCode(0L);
        }
        errorDTO.setTip(exception.getMessage());
        response.setCharacterEncoding("utf-8");
        return new ResponseEntity<>(errorDTO,
                HttpStatus.valueOf(response.getStatus()));
    }
}

@Setter
@Getter
class ErrorDTO{
    private Long errorCode;
    private String tip;
}