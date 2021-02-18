package com.jida.common.util;

import com.jida.common.cache.data.PublicDataEntity;
import com.jida.common.cache.data.RoleEntity;
import com.jida.common.cache.data.SceneDataEntity;

import java.util.HashMap;
import java.util.Map;

public class CacheHolder {
    public static Map<Long, RoleEntity> USERID_ROLEENTITY_MAP = new HashMap<>();
    public static Map<Integer, SceneDataEntity> SCENEID_DATA_MAP = new HashMap<>();
    public static PublicDataEntity PUBLIC_DATA_ENTITY = new PublicDataEntity();
}
