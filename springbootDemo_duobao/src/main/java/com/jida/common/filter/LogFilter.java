package com.jida.common.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class LogFilter extends OncePerRequestFilter {

    private static String REQUEST_ID ="REQUEST_ID";

    private static final long warnTime = 10000;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        MDC.put(REQUEST_ID,"100.100.100.222");
        ServletRequest requestWrapper = null;
        /*if(request instanceof HttpServletRequest){
            requestWrapper = new BodyReaderHttpServletRequestWrapper((HttpServletRequest) request);
            log.info("请求的参数: {}",((BodyReaderHttpServletRequestWrapper)requestWrapper).getBody());
        }*/
        try{
            if(requestWrapper == null){
                filterChain.doFilter(request,response);
            }else {
                filterChain.doFilter(requestWrapper,response);
            }
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }finally {
            long time = System.currentTimeMillis() - start;
            if(time > warnTime){
                log.warn("耗时{}ms",time);
            }else{
                log.info("耗时{}ms",time);
            }
        }
    }
}
