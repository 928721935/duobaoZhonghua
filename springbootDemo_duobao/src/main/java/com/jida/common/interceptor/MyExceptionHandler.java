package com.jida.common.interceptor;

import com.jida.common.exception.JidaException;
import com.jida.common.exception.MsException;
import com.jida.common.response.ResultMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class MyExceptionHandler {
    @ExceptionHandler(MsException.class)
    public ResultMessage<?> handleJidaException(MsException e){
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setSuccess(false);
        resultMessage.setMessage(e.getMessage());
        resultMessage.setCode(e.getCode());
        return resultMessage;
    }

    @ExceptionHandler(Exception.class)
    public ResultMessage<?> handleException(Exception e){
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setSuccess(false);
        resultMessage.setMessage(e.getMessage());
        resultMessage.setCode("系统错误。。。。。。");
        e.printStackTrace();
        return resultMessage;
    }
}
