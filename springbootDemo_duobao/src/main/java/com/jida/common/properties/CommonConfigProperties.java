package com.jida.common.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@Component
//@PropertySource(value = "classpath:/commonConfig.properties")
public class CommonConfigProperties {
    @Value("${encryptParam}")
    public boolean encryptParam;

    @Value("${ipMaxPeopleCount}")
    public Integer ipMaxPeopleCount;

    @Value("${timePerRound}")
    public Integer timePerRound;

    @Value("${sessionTimeOut}")
    public Integer sessionTimeOut;

    @Value("${checkPwd}")
    public boolean checkPwd;

    @Value("${contextPath}")
    public String contextPath;
}
