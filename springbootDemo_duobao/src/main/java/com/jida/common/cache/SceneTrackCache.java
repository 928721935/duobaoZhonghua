package com.jida.common.cache;

import com.jida.common.util.CacheUtil;
import com.jida.common.cache.data.RoleEntity;
import com.jida.dto.TrackInfo;
import lombok.Data;
import org.apache.commons.lang3.time.DateUtils;

import java.util.*;

//@Data
public class SceneTrackCache {
    private int maxSize;
    private int cleanTimeLong;

    public SceneTrackCache(int maxSize, int cleanTimeLong) {
        this.maxSize = maxSize;
        this.cleanTimeLong = cleanTimeLong;
    }

    public Map<Integer, LinkedList<TrackInfo>> sceneID_TrackListMap = new HashMap<>();

    public void put(TrackInfo trackInfo) {
        RoleEntity roleEntity = CacheUtil.getCurrRoleEntity();
        Integer sceneId = roleEntity.getSceneId();
        LinkedList<TrackInfo> trackInfos = sceneID_TrackListMap.get(sceneId);
        if (trackInfos == null) {
            trackInfos = new LinkedList<>();
            sceneID_TrackListMap.put(sceneId, trackInfos);
        }
        if (trackInfos.size() > maxSize) {
            trackInfos.removeFirst();
        }
        trackInfos.add(trackInfo);
    }

    public List<TrackInfo> pull() {
        List<TrackInfo> result = new ArrayList<>();
        RoleEntity roleEntity = CacheUtil.getCurrRoleEntity();
        Integer sceneId = roleEntity.getSceneId();
        LinkedList<TrackInfo> trackInfos = sceneID_TrackListMap.get(sceneId);
        if (trackInfos == null) {
            return new LinkedList<>();
        }
        /*if (trackInfos.size() > maxSize) {
            trackInfos.removeFirst();
        }*/
        Date outDate = DateUtils.addSeconds(new Date(), -cleanTimeLong);
        for (int i = 0; i < trackInfos.size(); i++) {
            TrackInfo trackInfo = trackInfos.get(i);
            if (trackInfo.getCreateTime().after(outDate)) {
                Long userId = roleEntity.getUser().getUserId();
                if (!trackInfo.getAreadyReadUserIds().contains(userId)) {
                    result.add(trackInfo);
                    trackInfo.getAreadyReadUserIds().add(userId);
                }
            }
        }
        return result;
    }
}
