package com.jida.dto;

import lombok.Data;

@Data
public class SendPostDto {
    private String tipTitle;
    private String tipContent;
    private Integer postPageNum;
    private Integer postPageSize;
}
