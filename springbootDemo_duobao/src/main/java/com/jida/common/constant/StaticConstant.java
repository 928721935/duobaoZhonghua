package com.jida.common.constant;

import com.jida.common.properties.ApplicationYmlProperties;
import com.jida.common.util.CommonUtil;
import com.jida.common.util.PropertiesUtil;
import com.jida.common.util.SpringPropertyUtil;

import java.util.Properties;

public class StaticConstant {
    public static ApplicationYmlProperties ymlProperty = null;
    static {
        ymlProperty = SpringPropertyUtil.getYmlProperty();
    }
    public static final String DEFAULT_JSP_DIRECTORY = "/WEB-INF/jsp";

    public static final String NO_NAME = "无名氏";

    public static final String PORT =  ymlProperty.port;

    public static final String CONTEXT_PATH =  ymlProperty.contextPath;
}
