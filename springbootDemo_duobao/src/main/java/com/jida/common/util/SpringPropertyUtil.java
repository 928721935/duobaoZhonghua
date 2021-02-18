package com.jida.common.util;

import com.jida.common.properties.ApplicationYmlProperties;
import com.jida.common.properties.CommonConfigProperties;

public class SpringPropertyUtil {
    public static ApplicationYmlProperties getYmlProperty(){
        ApplicationYmlProperties bean = SpringUtils.ctx.getBean(ApplicationYmlProperties.class);
        return bean;
    }

    /*public static CommonConfigProperties getCommonProperty(){
        CommonConfigProperties bean = SpringUtils.ctx.getBean(CommonConfigProperties.class);
        return bean;
    }*/
}
