package com.jida.common.filter;

/**
 *
 */
/*@Slf4j
public class ReLoginFilter implements Filter {

    private FilterConfig filterCfg;

    public ReLoginFilter() {
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
            Long userId = (Long)request.getSession().getAttribute("userId");
            //如果被别人顶号，则跳转到登陆界面
            RoleEntity roleEntity = CacheUtil.roleEntityCache.userID_roleEntityMap.get(userId);
            if (!roleEntity.getSessionId().equals(request.getSession().getId())) {
                request.getSession().setMaxInactiveInterval(1);
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
}*/
