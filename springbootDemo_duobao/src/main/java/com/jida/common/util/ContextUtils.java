package com.jida.common.util;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/**
 * Spring ApplicationContext 工具类
 */
public class ContextUtils {

    public static ApplicationContext ctx;

    public static void setApplicationContext(ApplicationContext ctx2) throws BeansException {
        ctx = ctx2;
    }

    public static <T> T getBean(String beanName) {
        if(ctx.containsBean(beanName)){
            return (T) ctx.getBean(beanName);
        }else{
            return null;
        }
    }

    public static <T> T getBeanClass(Class<T> baseType){
        return ctx.getBean(baseType);
    }
}
