package com.jida.dto;

import lombok.Data;

import java.util.List;

@Data
public class ForumNormalPostListDto {
    private List<ForumPostDto> dataList;
    private List<ForumPostDto> topList;
    private Integer count;
    private Integer currPage;
    private Integer totalPage;
}
