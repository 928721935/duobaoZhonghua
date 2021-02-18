package com.jida.common.util;

import com.jida.common.cache.data.RoleEntity;
import com.jida.entity.User;

public class NpcUtil {
    public static void initData(){
        RoleEntity roleEntity = new RoleEntity();
        User user = new User();
        user.setPeopleName("林得才");
        user.setUserId(100L);
        roleEntity.setSceneId(3);
        roleEntity.setUser(user);
        roleEntity.setUserType(1);
        CacheUtil.roleEntityCache.userID_roleEntityMap.put(user.getUserId(),roleEntity);
        CacheUtil.viewCache.add(roleEntity.getSceneId(),user.getUserId());

        roleEntity = new RoleEntity();
        user = new User();
        user.setPeopleName("春花");
        user.setUserId(101L);
        roleEntity.setSceneId(3);
        roleEntity.setUser(user);
        roleEntity.setUserType(1);
        CacheUtil.roleEntityCache.userID_roleEntityMap.put(user.getUserId(),roleEntity);
        CacheUtil.viewCache.add(roleEntity.getSceneId(),user.getUserId());

        roleEntity = new RoleEntity();
        user = new User();
        user.setPeopleName("苦力");
        user.setUserId(102L);
        roleEntity.setSceneId(3);
        roleEntity.setUser(user);
        roleEntity.setUserType(1);
        CacheUtil.roleEntityCache.userID_roleEntityMap.put(user.getUserId(),roleEntity);
        CacheUtil.viewCache.add(roleEntity.getSceneId(),user.getUserId());
    }
}
