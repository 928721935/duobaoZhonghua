package com.jida.dto;

import lombok.Data;

import java.util.*;

@Data
public class TrackInfo {
    private String msg;
    private Set<Long> areadyReadUserIds = new HashSet<>();
    private Date createTime;
}
