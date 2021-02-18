package com.jida.common.filter;

import com.jida.common.util.CacheUtil;
import com.jida.common.util.StatisticsUtil;
import com.jida.common.cache.data.RoleEntity;
import com.jida.entity.User;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
@Slf4j
public class SessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent hse) {

    }

    public void sessionDestroyed(HttpSessionEvent hse) {
        HttpSession session = hse.getSession();
        Long userId = (Long) session.getAttribute("userId");
        log.info("sessionTimeOut,userId:{}",userId);
        RoleEntity currRoleEntity = CacheUtil.getRoleEntity(userId);
        User user = currRoleEntity.getUser();
        CacheUtil.viewCache.remove(currRoleEntity.getSceneId(), userId);
        CacheUtil.roleEntityCache.userID_roleEntityMap.remove(user.getUserId());
        StatisticsUtil.getInsatance().removeIp(currRoleEntity.getIpAddr(),user.getUserId());
    }
}
