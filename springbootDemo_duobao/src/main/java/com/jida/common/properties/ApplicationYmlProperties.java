package com.jida.common.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationYmlProperties {
    @Value("${server.port}")
    public String port;
    @Value("${server.servlet.context-path}")
    public String contextPath;
}
