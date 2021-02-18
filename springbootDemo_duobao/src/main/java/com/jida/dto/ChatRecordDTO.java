package com.jida.dto;

import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class ChatRecordDTO {
    private Date createTime;
    private String msg;
    private String sendPeopleName;
    private Long sendUserId;
    private Set<Long> areadyReadUserIds = new HashSet<>();
}
