package com.jida.dto;

import lombok.Data;
import java.util.Date;

@Data
public class ForumPostDto {
    private Long id;
    private String title;
    private String content;
    private Long senderID;
    private String senderPeopleName;
    private Integer replyNum;
    private Integer readNum;
    private Integer top;
    private Integer essence;
    private Date createTime;
}
