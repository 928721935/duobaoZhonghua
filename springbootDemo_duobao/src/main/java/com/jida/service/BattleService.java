package com.jida.service;

import com.jida.common.cache.BattleCache;
import com.jida.common.constant.StaticConstant;
import com.jida.common.util.*;
import com.jida.dto.ChatRecordDTO;
import com.jida.dto.ChatRecordDTO;
import com.jida.dto.Place;
import com.jida.common.cache.data.RoleEntity;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class BattleService {
    @Resource
    private MoveService moveService;
    private BattleCache battleCache = ContextUtils.getBeanClass(BattleCache.class);

    public String attack(Long otherUserId) {
        RoleEntity currRoleEntity = CacheUtil.getCurrRoleEntity();
        Integer sceneId = currRoleEntity.getSceneId();
        Place place = MapUtil.placeId_placeMap.get(sceneId);
        HttpServletRequest request = RequestUtil.getRequest();
        if(place.isSafe()){
            request.setAttribute("tips","这里不准战斗。");
            return StaticConstant.DEFAULT_JSP_DIRECTORY +"/wrong";
        }
        RoleEntity otherRoleEntity = CacheUtil.getRoleEntity(otherUserId);
        if(!otherRoleEntity.getSceneId().equals(sceneId)){
            request.setAttribute("tips","这里没有这个人。");
            return StaticConstant.DEFAULT_JSP_DIRECTORY +"/wrong";
        }

        battleCache.turnInBattle(currRoleEntity.getUser().getUserId(),otherUserId);
        return flashBattleRecord();
    }

    public String flashBattleRecord() {
        RoleEntity currRoleEntity = CacheUtil.getCurrRoleEntity();
        if(currRoleEntity.isInBattle()){
            List<ChatRecordDTO> pull = CacheUtil.battlePrivateTrackCache.pull();
            StringBuffer sb = new StringBuffer();
            pull.stream().map(ChatRecordDTO::getMsg).forEach(o->sb.append(o));
            HttpServletRequest request = RequestUtil.getRequest();
            request.setAttribute("battle_private_msg",sb.toString());
            return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/battle/battle";
        }else {
            return moveService.flashView();
        }
    }
}
