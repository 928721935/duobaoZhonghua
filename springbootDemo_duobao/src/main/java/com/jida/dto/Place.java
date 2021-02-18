package com.jida.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Place {
    private Integer placeId;
    private String name;
    private String sencondName;
    private Integer northPlaceId;
    private Integer westPlaceId;
    private Integer eastPlaceId;
    private Integer southPlaceId;
    private String description;
    private List<FunctionDto> functionDtoList = new ArrayList<>();
//    private String placeRealName;
//    private List<Direction> direction;
    //是否安全区
    private boolean safe;
}

