package com.jida.dto;

import lombok.Data;

import java.util.List;

@Data
public class SceneDto {
    private String battlePrivateMsg;
    private List<ChatRecordDTO> publicChatRecordDTOList;
    private List<ChatRecordDTO> privateChatRecordDTOList;
    private List<String> comeSceneTrackStr;
    private String scenePeopleListStr;
    private String sceneWalkInfo;
    private Place  place;
    private String functionDtoListStr;
}
