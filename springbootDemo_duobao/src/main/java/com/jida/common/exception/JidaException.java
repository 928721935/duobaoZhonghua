package com.jida.common.exception;

public class JidaException extends MsException{
    private static final String code = "JIDA_ERROR";
    private static final String message = "系统出错";
    public JidaException(String message){
        super(code,message);
        if(code==null || message==null){
            throw new RuntimeException(message);
        }
    }
}
