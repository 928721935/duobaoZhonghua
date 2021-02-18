package com.jida.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@TableName(value = "t_user")
public class User {
    @TableId
    private Long userId;
    private String username;
    private String password;
    private String peopleName;
    private Integer sex;
    private BigDecimal xiuXing;
    private Integer qianNeng;
    private Integer neiLi;
    private Integer neiLiMax;
    private Integer jingShen;
    private Integer shengMing;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
