package com.jida.common.cache;

import com.jida.common.util.CacheUtil;
import com.jida.common.cache.data.RoleEntity;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ViewCache {
    public static Map<Integer, Set<RoleEntity>> sceneID_usersMap = new HashMap<>();
    public static void add(Integer sceneID,Long userId){
        RoleEntity currRoleEntity = CacheUtil.getRoleEntity(userId);
        Set<RoleEntity> roleEntities = sceneID_usersMap.get(sceneID);
        if(roleEntities == null){
            roleEntities = new HashSet<>();
            sceneID_usersMap.put(sceneID,roleEntities);
        }
        roleEntities.add(currRoleEntity);
    }

    public static void remove(Integer sceneID,Long userId){
        RoleEntity currRoleEntity = CacheUtil.getRoleEntity(userId);
        Set<RoleEntity> roleEntities = sceneID_usersMap.get(sceneID);
        if(roleEntities == null){
            return;
        }
        roleEntities.remove(currRoleEntity);
    }
}
