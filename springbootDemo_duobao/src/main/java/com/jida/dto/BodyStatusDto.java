package com.jida.dto;

import lombok.Data;

@Data
public class BodyStatusDto {
    private Integer shengMingMax;
    private Integer jingShenMax;
    private Integer qianNengMax;
    private Integer neiLiMax;
    private Integer shengMingCurr;
    private Integer jingShenCurr;
    private Integer qianNengCurr;
    private Integer neiLiCurr;
    private String xiuXingStr;
}
