package com.jida.service;

import com.jida.common.util.MapUtil;
import com.jida.dto.Place;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    public Integer getSceneByWay(int old_scene_id, String way) {
        if (StringUtils.isEmpty(way)) {
            return old_scene_id;
        }
        Place place = MapUtil.placeId_placeMap.get(old_scene_id);
        Integer new_scene_id = null;
        switch (way){
            case "North":{
                new_scene_id = place.getNorthPlaceId();
                break;
            }
            case "West":{
                new_scene_id = place.getWestPlaceId();
                break;
            }
            case "East":{
                new_scene_id = place.getEastPlaceId();
                break;
            }
            case "South":{
                new_scene_id = place.getSouthPlaceId();
                break;
            }
        }
        return new_scene_id;
    }
}
