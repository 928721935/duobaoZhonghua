package com.jida.common.filter;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 */
@Slf4j
public class SessionValidityFilter implements Filter {

    private FilterConfig filterCfg;

    public SessionValidityFilter() {
        super();
    }

    public void init(FilterConfig arg0) throws ServletException {
        this.filterCfg = arg0;
    }

    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain) {
        try {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            System.out.println(request.getServletPath());
            if(excludedPages.contains(request.getServletPath())){
                filterChain.doFilter(request, response);
                return;
            }
            if(request.getServletPath().startsWith("/img")){
                filterChain.doFilter(request, response);
                return;
            }
            Object userId = request.getSession().getAttribute("userId");
            //如果用户信息无效则跳转到登陆界面
            if (userId == null) {
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
                return;
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
    }

    private static List<String> excludedPages = Lists.newArrayList("/getVerifiyCode","/register","/registerPage","/img","/login","/WEB-INF/jsp/login.jsp");
}
