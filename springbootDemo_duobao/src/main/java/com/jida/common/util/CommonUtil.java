package com.jida.common.util;

import com.jida.common.constant.CommonConstant;
import com.jida.common.constant.StaticConstant;
import org.springframework.core.io.ClassPathResource;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CommonUtil {
    private static ThreadLocal<DateFormat> dateFormat = new ThreadLocal() {
        @Override protected DateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss");
        }
    };
    private static ThreadLocal<DateFormat> dateFormat2 = new ThreadLocal() {
        @Override protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    public static String translateDate1(Date a){
        String format = dateFormat.get().format(a);
        return format;
    }

    public static String translateDate2(Date a){
        String format = dateFormat2.get().format(a);
        return format;
    }

    public static Field[] getAllField(Object object) {
        Class<?> clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }

    public static String encryptStr(String str) {
        if (CommonConstant.ENCRYPT_PARAM) {
            return AESUtil.encrypt(str);
        }
        return str;
    }

    public static String decryptStr(String str) {
        if (CommonConstant.ENCRYPT_PARAM) {
            return AESUtil.decrypt(str);
        }
        return str;
    }

    public static String getProjectPath() {
        File directory = new File("");//参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courseFile;
    }

    public static String getContextPath() {
        return "http://"+ CommonConstant.DOMAIN+ ":"+StaticConstant.PORT + StaticConstant.CONTEXT_PATH;
    }

    public static String getStandardUrl(String path) {
        return "game?cmd="+CommonUtil.encryptStr(addTimestamp(path));
    }

    public static String getStandardPostCmd(String path) {
        return CommonUtil.encryptStr(addTimestamp(path));
    }

    public static String removeTimeStamp(String cmd){
        int i = cmd.indexOf("&timestamp=");
        if(i>0){
            cmd = cmd.substring(0,i);
        }
        return cmd;
    }

    public static String addTimestamp(String path) {
        return path+"&timestamp="+new Date().getTime();
    }

    public static File getClassPathFile(String fileName) {
        ClassPathResource classPathResource = new ClassPathResource(fileName);
        File file = null;
        try {
            file = classPathResource.getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static void sleepThread(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepThread(long time,Thread thread){
        try {
            thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
