package com.jida.common.interceptor;

import com.jida.common.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
//@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static final Integer NOT_LOGIN = 401;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userId = request.getSession().getAttribute("userId");
        if(userId!=null){
            return true;
        }else{
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            throw new CommonException(NOT_LOGIN,"请先登陆");
//            response.sendRedirect("");
        }
    }

    @PostConstruct
    public void initCommonMenu(){
        log.info("初始化菜单开始");
        //COMMON_MENUS.add();
        log.info("初始化菜单结束");
    }
}
