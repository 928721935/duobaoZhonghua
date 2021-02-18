package com.jida.common.cache.data;

import com.jida.common.constant.SkillEnum;
import com.jida.dto.BattleInfo;
import com.jida.dto.ChatRecordDTO;
import com.jida.dto.RoleInfo;
import com.jida.dto.RoleSkillDto;
import com.jida.entity.RoleSkill;
import com.jida.entity.User;
import com.jida.entity.UserGood;
import lombok.Data;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
public class RoleEntity {
    private Integer sceneId;
    private User user;
    private HttpSession session;
    private String ipAddr;
    private boolean inBattle;
    private BattleInfo battleInfo = new BattleInfo();
    private int userType;
    private LinkedList<ChatRecordDTO> battleRecord = new LinkedList<>();
    private RoleInfo roleInfo;
    private List<UserGood> userGoodList;
    private List<RoleSkillDto> roleSkillList;
    private Map<Integer, Integer> typeSkillIDMap;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}

