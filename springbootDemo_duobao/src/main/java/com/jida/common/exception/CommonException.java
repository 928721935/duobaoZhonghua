package com.jida.common.exception;

import com.jida.common.response.ResultMessage;
import lombok.Data;

@Data
public class CommonException extends RuntimeException{
    private ResultMessage result;

    public CommonException(String message){
        super(message);
        result = new ResultMessage();
        result.setCode("FAIL");
        result.setSuccess(false);
        result.setMessage(message);
    }

    public CommonException(int code,String message){
        super(message);
        result = new ResultMessage();
        result.setCode(code+"");
        result.setSuccess(false);
        result.setMessage(message);
    }
}
