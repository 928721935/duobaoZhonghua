package com.jida.common.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("接口返回公共实体")
@Data
public class ResultMessage<T> {
    private T result;
    private String message;
    private String code;
    private boolean success;

    /*private static String SUCCESS = "SUCCESS";
    private static String FAIL = "FAIL";*/

    public ResultMessage() {

    }

    public ResultMessage(boolean success,String message) {
        this.message = message;
        this.success = true;
        this.code = "200";
    }

    public ResultMessage(boolean success,String message,T result) {
        this.result = result;
        this.message = message;
        this.success = success;
        this.code = "200";
    }

    public static ResultMessage fail(String message){
        return new ResultMessage(false,message);
    }

    public static <T> ResultMessage<T> fail(String message,T data){
        return new ResultMessage(false,message,data);
    }

    public static ResultMessage success(String message){
        return new ResultMessage(true,message);
    }

    public static <T> ResultMessage<T> success(String message,T data){
        return new ResultMessage(true,message,data);
    }

    /*public ResultMessage<T> success(T result, String message){
        return new ResultMessage(result,message,"SUCCESS");
    }

    public ResultMessage<T> fail(T result, String message){
        return new ResultMessage(result,message,"FAIl");
    }*/
}
