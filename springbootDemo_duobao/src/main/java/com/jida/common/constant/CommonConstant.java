package com.jida.common.constant;

import com.jida.common.util.PropertiesUtil;
import java.util.Properties;

public class CommonConstant {
    public static Properties commonProperties = null;
    static {
        commonProperties = PropertiesUtil.getCommonProperties();
    }

    public static final boolean ENCRYPT_PARAM =  Boolean.valueOf(commonProperties.getProperty("encryptParam"));

    public static final String DOMAIN =  commonProperties.getProperty("domain");

    public static final Integer SESSION_TIME_OUT =  Integer.valueOf(commonProperties.getProperty("sessionTimeOut"));

    public static final boolean CHECK_PWD =  Boolean.valueOf(commonProperties.getProperty("checkPwd"));

    public static final Integer IP_MAX_PEOPLE_COUNT =  Integer.valueOf(commonProperties.getProperty("ipMaxPeopleCount"));

    public static final Integer TIME_PER_ROUND =  Integer.valueOf(commonProperties.getProperty("timePerRound"));

}
