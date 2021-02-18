package com.jida.common.util;

import com.jida.common.cache.*;
import com.jida.common.cache.data.RoleEntity;

public class CacheUtil {
    public static RoleEntityCache roleEntityCache = ContextUtils.getBeanClass(RoleEntityCache.class);
    public static ViewCache viewCache = ContextUtils.getBeanClass(ViewCache.class);
//    公聊历史信息
    public static ChatRecordCache publicChatRecordCache = ContextUtils.getBean("publicChatRecordCache");
    public static SceneTrackCache comeSceneTrackCache = ContextUtils.getBean("comeSceneTrackCache");
//    私聊即时信息
    public static SelfTrackCache privateChatImmediateCache = ContextUtils.getBean("privateChatImmediateCache");
    public static BattlePrivateTrackCache battlePrivateTrackCache = ContextUtils.getBean("battlePrivateTrackCache");
//    public static BattleCache battleCache = new BattleCache();

    public static RoleEntity getCurrRoleEntity(){
        Long userId = (Long)RequestUtil.getSession().getAttribute("userId");
        return roleEntityCache.userID_roleEntityMap.get(userId);
    }

    public static RoleEntity getRoleEntity(Long userId ){
        return roleEntityCache.userID_roleEntityMap.get(userId);
    }

    /*private static CacheUtil instance;
    public static CacheUtil getInstance(){
        instance = new CacheUtil();
        return instance;
    }*/
}
