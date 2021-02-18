package com.jida.common.exception;

import lombok.Data;

@Data
public class MsException extends RuntimeException{
    private String code;
    private String message;
    private Object result;
    public MsException(String code,String message){
        super(message);
        if(code==null || message==null){
            throw new RuntimeException(message);
        }
        this.code = code;
        this.message = message;
    }
}
