package com.jida.dto;

import lombok.Data;
import java.util.LinkedList;
import java.util.List;

@Data
public class BattleInfo {
//    private String peopleName;
    private List<Long> otherUserIds = new LinkedList<>();
    private Integer hp = 1000;
}
