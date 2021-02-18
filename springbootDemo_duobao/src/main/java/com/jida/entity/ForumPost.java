package com.jida.entity;

import lombok.Data;
import java.util.Date;

@Data
public class ForumPost {
    private Long id;
    private String title;
    private String content;
    private Long senderID;
    private Integer replyNum;
    private Integer readNum;
    private Integer top;
    private Integer essence;
    private Date createTime;
    private Date lastReplyTime;
}
