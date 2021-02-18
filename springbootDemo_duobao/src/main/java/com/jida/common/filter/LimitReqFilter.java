package com.jida.common.filter;

import com.jida.common.constant.CommonConstant;
import com.jida.common.constant.StaticConstant;
import com.jida.common.util.StatisticsUtil;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
@Slf4j
public class LimitReqFilter implements Filter {

    private FilterConfig filterCfg;

    public LimitReqFilter() {
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
            if (excludedPages.contains(request.getServletPath())) {
                filterChain.doFilter(request, response);
                return;
            }
            if (request.getServletPath().startsWith("/img")) {
                filterChain.doFilter(request, response);
                return;
            }
            String remoteAddr = StatisticsUtil.getIpAddr(request);
//            System.out.println(remoteAddr);
            LinkedList<Long> userIds = StatisticsUtil.getInsatance().ip_userIdListMap.get(remoteAddr);
            Integer ipMaxPeopleCount = CommonConstant.IP_MAX_PEOPLE_COUNT;
            if (userIds.size() > ipMaxPeopleCount) {
                request.setAttribute("tips", "不要登那么多的号!!!");
                request.getRequestDispatcher("/WEB-INF/jsp/wrong.jsp").forward(request, response);
                return;
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
    }

    private static List<String> excludedPages = Lists.newArrayList("/getVerifiyCode", "/register", "/registerPage", "/img", "/login", "/WEB-INF/jsp/login.jsp");
}
