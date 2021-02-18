package com.jida.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jida.common.constant.CommonConstant;
import com.jida.common.constant.SkillEnum;
import com.jida.common.constant.StaticConstant;
import com.jida.common.util.*;
import com.jida.common.cache.data.RoleEntity;
import com.jida.dto.RoleInfo;
import com.jida.dto.RoleSkillDto;
import com.jida.entity.RoleSkill;
import com.jida.entity.TypeSkill;
import com.jida.entity.User;
import com.jida.entity.UserGood;
import com.jida.mapper.RoleSkillMappper;
import com.jida.mapper.TypeSkillMappper;
import com.jida.mapper.UserGoodMappper;
import com.jida.mapper.UserMappper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class LoginService {
    @Resource
    private UserMappper userMappper;
    @Resource
    private RoleSkillMappper roleSkillMappper;
    @Resource
    private TypeSkillMappper typeSkillMappper;
    @Resource
    private MoveService moveService;
    @Resource
    private UserGoodMappper userGoodMappper;


    public String login(String username, String password) {
        User userCon = new User();
        userCon.setUsername(username);
        User user = userMappper.selectOne(Wrappers.lambdaQuery(userCon));
        HttpServletRequest request = RequestUtil.getRequest();
        if (user != null) {
            String shaHex = getShaHex(password, username);
            boolean flag = shaHex.equals(user.getPassword());
            if(!CommonConstant.CHECK_PWD){
                flag = true;
            }
            if(flag){
                //密码正确
                dealLogin(user);
                return moveService.moveMap(null);
            }else {
                request.setAttribute("username",username);
                request.setAttribute("tip2","密码错误");
                return StaticConstant.DEFAULT_JSP_DIRECTORY + "/login";
            }
        }else {
            request.setAttribute("tip1","用户名不存在");
            return StaticConstant.DEFAULT_JSP_DIRECTORY + "/login";
        }
    }

    private void dealLogin(User user){
        HttpServletRequest request = RequestUtil.getRequest();
        HttpSession session = RequestUtil.getSession();
        session.setAttribute("userId", user.getUserId());
        Integer sessionTimeOut = CommonConstant.SESSION_TIME_OUT;
        session.setMaxInactiveInterval(sessionTimeOut);
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setUser(user);
        if (roleEntity.getSceneId() == null) {
            roleEntity.setSceneId(7);
        }
        RoleEntity roleEntityCache = CacheUtil.getRoleEntity(user.getUserId());
        String remoteAddr = StatisticsUtil.getIpAddr(request);
        StatisticsUtil statisticsUtil = StatisticsUtil.getInsatance();
        if(roleEntityCache!=null && roleEntityCache.getIpAddr() !=null && !request.getRemoteAddr().equals(roleEntityCache.getIpAddr())){
            statisticsUtil.removeIp(roleEntityCache.getIpAddr(),user.getUserId());
        }
        statisticsUtil.addIp(remoteAddr,user.getUserId());
        roleEntity.setIpAddr(request.getRemoteAddr());
        if(roleEntityCache!=null&& !session.getId().equals(roleEntityCache.getSession().getId())){
            roleEntityCache.getSession().setMaxInactiveInterval(1);
        }
        roleEntity.setSession(session);
        CacheUtil.roleEntityCache.userID_roleEntityMap.put(user.getUserId(), roleEntity);
        loadRoleInfo(user,roleEntity);
        loadSkill(user,roleEntity);
        loadPackage(roleEntity);
    }

    private void loadPackage(RoleEntity roleEntity){
        User user = roleEntity.getUser();
        UserGood userGood = new UserGood();
        userGood.setUserId(user.getUserId());
        List<UserGood> userGoods = userGoodMappper.selectList(Wrappers.lambdaQuery(userGood));
        roleEntity.setUserGoodList(userGoods);
    }

    private void loadSkill(User user,RoleEntity roleEntity){
        List<RoleSkillDto> roleSkills = roleSkillMappper.getSkillList(user.getUserId());
        List<RoleSkillDto> roleSkillDtos = new ArrayList<>();
        for (RoleSkillDto roleSkill:roleSkills) {
            RoleSkillDto dto = new RoleSkillDto();
            BeanUtils.copyProperties(roleSkill,dto);
            SkillEnum skillEnum = SkillEnum.getSkillById(roleSkill.getSkillID());
            dto.setSkillName(skillEnum.getName());
            dto.setSkillFuncType(skillEnum.getSkillFuncType());
            dto.setSpecialSkill(skillEnum.getSpecialSkill());
            dto.setSkillFuncTypeList(skillEnum.getSkillFuncTypeList());
            dto.setVipSpecialSkill(skillEnum.getVipSpecialSkill());
            roleSkillDtos.add(dto);
        }
        roleEntity.setRoleSkillList(roleSkillDtos);
        TypeSkill typeSkill = new TypeSkill();
        typeSkill.setUserID(user.getUserId());
        List<TypeSkill> typeSkills = typeSkillMappper.selectList(Wrappers.lambdaQuery(typeSkill));
        Map<Integer, Integer> typeSkillIDMap = typeSkills.stream().collect(Collectors.toMap(TypeSkill::getType, v -> v.getSkillID(), (v1, v2) -> v1));
        roleEntity.setTypeSkillIDMap(typeSkillIDMap);
    }

    private void loadRoleInfo(User user,RoleEntity roleEntity){
        Integer shengMingMax = user.getXiuXing().divide(BigDecimal.valueOf(2)).intValue();
        Integer jingShenMax = user.getXiuXing().divide(BigDecimal.valueOf(1)).intValue();
        Integer qianNengMax = user.getXiuXing().divide(BigDecimal.valueOf(20)).intValue();
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setShengMingMax(shengMingMax);
        roleInfo.setJingShenMax(jingShenMax);
        roleInfo.setNeiLiMax(user.getNeiLiMax());
        roleInfo.setQianNengMax(qianNengMax);
        roleInfo.setJingShenCurr(user.getJingShen());
        roleInfo.setShengMingCurr(user.getShengMing());
        roleInfo.setNeiLiCurr(user.getNeiLi());
        roleInfo.setQianNengCurr(user.getQianNeng());
        roleEntity.setRoleInfo(roleInfo);
    }

    public String register(String username, String password, String password2, String code) {
        HttpSession session = RequestUtil.getSession();
        Object obj = session.getAttribute("verifiyCode");
        if (obj == null) {
            return StaticConstant.DEFAULT_JSP_DIRECTORY + "/registerPage";
        }
        HttpServletRequest request = RequestUtil.getRequest();
        /*String verifiyCode2 = (String)obj;
        if(!verifiyCode2.equals(code)){
            request.setAttribute("tip4","验证码不正确");
        }*/
        String reg = "^[A-Za-z0-9]{6,12}$";
        Matcher m = Pattern.compile(reg).matcher(username);
        boolean matches = m.matches();
        boolean flag = true;
        if (!matches) {
            request.setAttribute("tip1", "用户名校验不通过");
            flag = false;
        }
        User userCon = new User();
        userCon.setUsername(username);
        User user = userMappper.selectOne(Wrappers.lambdaQuery(userCon));
        if (user != null) {
            request.setAttribute("tip1", "用户名已存在");
            flag = false;
        }

        m = Pattern.compile(reg).matcher(password);
        matches = m.matches();
        if (!matches) {
            request.setAttribute("tip2", "密码校验不通过");
            flag = false;
        }

        matches = password.equals(password2);
        if (!matches) {
            request.setAttribute("tip3", "密码与重复密码不一致");
            flag = false;
        }
        if (!flag) {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("password2", password2);
            return StaticConstant.DEFAULT_JSP_DIRECTORY + "/registerPage";
        } else {
            String passwordDigest = DigestUtils.sha1Hex(password + username);
            user = new User();
            user.setUserId(SnowFlakeUtil.getInstance().nextId());
            user.setUsername(username);
            user.setPassword(passwordDigest);
            user.setPeopleName(StaticConstant.NO_NAME);
            userMappper.insert(user);
        }
        return login(username,password);
    }

    private String getShaHex(String password,String username){
        return DigestUtils.sha1Hex(password + username);
    }
}
