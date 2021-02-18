package com.jida.common.interceptor;


import com.jida.common.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
@Component
public class ErrorInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(response.getStatus() == HttpStatus.BAD_REQUEST.value()){
            throw new CommonException("");
        }else if(response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()){
            throw new CommonException("");
        }else if(response.getStatus() == HttpStatus.NOT_FOUND.value()){
            throw new NoHandlerFoundException(request.getMethod(),"this",new ServletServerHttpRequest(request).getHeaders());
        }else{
            return true;
        }
    }
}
