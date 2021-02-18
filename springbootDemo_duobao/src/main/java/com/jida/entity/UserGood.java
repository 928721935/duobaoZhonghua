package com.jida.entity;

import lombok.Data;

@Data
public class UserGood {
    private Long userId;
    private String goodName;
    private Integer goodCount;
    private String unit;
    private Integer goodType;
    private Long goodID;
}
