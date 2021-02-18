package com.jida.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ChatRecord {
    private Long id;
    private String msg;
    private Long senderID;
    private Long receiverID;
    private Integer type;
    private Date createTime;
}
