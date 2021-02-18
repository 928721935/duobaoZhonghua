package com.jida.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private static volatile PropertiesUtil instance;
    private static Properties properties;

    private PropertiesUtil() {

    }

    public static PropertiesUtil getInstance() {
        if (instance == null) {
            synchronized (PropertiesUtil.class) {
                if (instance == null) {
                    instance = new PropertiesUtil();
                    init();
                }
            }
        }
        return instance;
    }

    private static void init() {
//        String name = LogUtil.getProjectPath()+ File.separator+"config"+File.separator +"specialConfig.properties";
        String name = "commonConfig.properties";
        try {
//            InputStream in = new FileInputStream(name);
            File file = CommonUtil.getClassPathFile(name);
            InputStream in = new FileInputStream(file);
            properties = new Properties();
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return properties.getProperty(key);
    }

    public static Properties getCommonProperties() {
        getInstance();
        return properties;
    }

    public static void main(String[] args) throws Exception {
        getInstance();
        String s1 = PropertiesUtil.getValue("sessionTimeOut");
        System.out.println(s1);
    }
}
