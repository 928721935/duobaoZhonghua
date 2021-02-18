package com.jida.common.cache;

import com.jida.common.util.RequestUtil;
import com.jida.common.cache.data.RoleEntity;
import java.util.HashMap;
import java.util.Map;

public class RoleEntityCache {
    public Map<Long, RoleEntity> userID_roleEntityMap = new HashMap<>();
    public RoleEntity getCurrRoleEntity(){
        Long userId = (Long)RequestUtil.getSession().getAttribute("userId");
        return userID_roleEntityMap.get(userId);
    }
}
