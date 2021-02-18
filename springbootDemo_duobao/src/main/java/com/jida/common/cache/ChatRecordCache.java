package com.jida.common.cache;

import com.jida.common.util.CacheUtil;
import com.jida.dto.ChatRecordDTO;
import com.jida.common.cache.data.RoleEntity;
import org.apache.commons.lang3.time.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ChatRecordCache {
    private int maxSize;
    private int cleanTimeLong;

    public LinkedList<ChatRecordDTO> chatRecordDTOList = new LinkedList<>();

    public ChatRecordCache(int maxSize,int cleanTimeLong) {
        this.maxSize = maxSize;
        this.cleanTimeLong = cleanTimeLong;
    }

    public void put(ChatRecordDTO record){
        if(chatRecordDTOList.size()>maxSize){
            chatRecordDTOList.removeLast();
        }
        chatRecordDTOList.addFirst(record);
    }

    public List<ChatRecordDTO> pull(){
        List<ChatRecordDTO> result = new ArrayList<>();
        RoleEntity roleEntity = CacheUtil.getCurrRoleEntity();
        Long userId = roleEntity.getUser().getUserId();
        LinkedList<ChatRecordDTO> trackInfos = chatRecordDTOList;
        Date outDate = DateUtils.addSeconds(new Date(), -cleanTimeLong);
        for (int i = 0; i < trackInfos.size(); i++) {
            ChatRecordDTO trackInfo = trackInfos.get(i);
            if (trackInfo.getCreateTime().after(outDate)) {
                if (!trackInfo.getAreadyReadUserIds().contains(userId)) {
                    result.add(trackInfo);
                    trackInfo.getAreadyReadUserIds().add(userId);
                }
            }
        }
        return result;
    }
}
