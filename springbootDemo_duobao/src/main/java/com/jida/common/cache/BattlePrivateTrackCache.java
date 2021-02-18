package com.jida.common.cache;

import com.jida.common.util.CacheUtil;
import com.jida.dto.ChatRecordDTO;
import com.jida.common.cache.data.RoleEntity;
import java.util.LinkedList;
import java.util.List;

public class BattlePrivateTrackCache {
    //最多存放几条战斗信息
    private int maxSize;

    public BattlePrivateTrackCache(int maxSize) {
        this.maxSize = maxSize;
    }

    public void put(ChatRecordDTO trackInfo, Long receiverUserId) {
        LinkedList<ChatRecordDTO> trackInfos = CacheUtil.roleEntityCache.userID_roleEntityMap.get(receiverUserId).getBattleRecord();
        if (trackInfos.size() > maxSize) {
            trackInfos.removeFirst();
        }
        trackInfos.add(trackInfo);
    }

    public List<ChatRecordDTO> pull() {
        RoleEntity roleEntity = CacheUtil.getCurrRoleEntity();
        List<ChatRecordDTO> trackInfos = roleEntity.getBattleRecord();
        LinkedList<ChatRecordDTO> trackInfos2 = new LinkedList<>(trackInfos);
        trackInfos.clear();
        return trackInfos2;
    }
}
