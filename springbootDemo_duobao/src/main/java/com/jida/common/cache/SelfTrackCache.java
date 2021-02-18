package com.jida.common.cache;

import com.jida.common.util.CacheHolder;
import com.jida.common.util.CacheUtil;
import com.jida.dto.ChatRecordDTO;
import com.jida.common.cache.data.RoleEntity;
import com.jida.dto.ChatRecordDTO;

import java.util.*;

public class SelfTrackCache {
    public Map<Long, LinkedList<ChatRecordDTO>> userID_TrackListMap = new HashMap<>();

    public void put(ChatRecordDTO trackInfo, Long receiverUserId) {
        LinkedList<ChatRecordDTO> trackInfos = userID_TrackListMap.get(receiverUserId);
        if (trackInfos == null) {
            trackInfos = new LinkedList<>();
            userID_TrackListMap.put(receiverUserId, trackInfos);
        }
        trackInfos.add(trackInfo);
    }

    public List<ChatRecordDTO> pull() {
        RoleEntity roleEntity = CacheUtil.getCurrRoleEntity();
        Long userId = roleEntity.getUser().getUserId();
        LinkedList<ChatRecordDTO> trackInfos = userID_TrackListMap.get(userId);
        if (trackInfos == null) {
            return new LinkedList<>();
        }
        LinkedList<ChatRecordDTO> trackInfos2 = new LinkedList<>(trackInfos);
        trackInfos.clear();
        return trackInfos2;
    }
}
