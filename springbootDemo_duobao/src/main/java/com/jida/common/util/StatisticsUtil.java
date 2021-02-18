package com.jida.common.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class StatisticsUtil {
    private static StatisticsUtil statisticsUtil = null;

    static {
        statisticsUtil = new StatisticsUtil();
    }

    public static StatisticsUtil getInsatance() {
        return statisticsUtil;
    }

    public volatile Map<String, LinkedList<Long>> ip_userIdListMap = new HashMap<>();

    public void addIp(String ip, long userId) {
        LinkedList<Long> userIdList = ip_userIdListMap.get(ip);
        if (userIdList == null) {
            userIdList = new LinkedList();
            ip_userIdListMap.put(ip, userIdList);
        }
        userIdList.add(userId);
    }

    public void removeIp(String ip, long userId) {
        LinkedList<Long> userIdList = ip_userIdListMap.get(ip);
        if (userIdList != null) {
            userIdList.remove(userId);
        }
    }

    public static String getIpAddr(HttpServletRequest request){
        /*String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }*/
        String ip = null;
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip)?"127.0.0.1":ip;
    }
}
