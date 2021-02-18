package com.jida.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jida.common.constant.SkillEnum;
import com.jida.common.constant.StaticConstant;
import com.jida.common.util.CacheUtil;
import com.jida.common.util.NumberHanZiFormat;
import com.jida.common.util.RequestUtil;
import com.jida.common.util.illegalWordUtil.IllegalWordsSearch;
import com.jida.dto.*;
import com.jida.common.cache.data.RoleEntity;
import com.jida.entity.TypeSkill;
import com.jida.entity.User;
import com.jida.mapper.TypeSkillMappper;
import com.jida.mapper.UserMappper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SelfInfoService {
    @Resource
    private UserMappper userMappper;
//    @Resource
//    private RoleSkillMappper roleSkillMappper;
    @Resource
    private TypeSkillMappper typeSkillMappper;

    public String getSelfInfo() {
        HttpServletRequest request = RequestUtil.getRequest();
        RoleEntity currRoleEntity = CacheUtil.getCurrRoleEntity();
        SelfInfoDto selfInfoDto = new SelfInfoDto();
        selfInfoDto.setPeopleName(currRoleEntity.getUser().getPeopleName());
        request.setAttribute("selfInfo", selfInfoDto);
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/selfInfo/selfInfo";
    }

    public String getOtherPeopleInfo(Long userId) {
        RoleEntity currRoleEntity = CacheUtil.getCurrRoleEntity();
        if (userId.equals(currRoleEntity.getUser().getUserId())) {
            return getSelfInfo();
        }
        HttpServletRequest request = RequestUtil.getRequest();
        RoleEntity roleEntity = CacheUtil.roleEntityCache.userID_roleEntityMap.get(userId);
        if(roleEntity == null){
            request.setAttribute("tips", "对方不在线。");
            return StaticConstant.DEFAULT_JSP_DIRECTORY + "/wrong";
        }
        OtherPeopleInfoDto dto = new OtherPeopleInfoDto();
        dto.setPeopleName(roleEntity.getUser().getPeopleName());
        dto.setUserId(roleEntity.getUser().getUserId());

        request.setAttribute("otherPeopleInfoDto", dto);
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/otherPeopleInfo/otherPeopleInfo";
    }

    public void getOtherPeopleList() {
        RoleEntity currRoleEntity = CacheUtil.getCurrRoleEntity();
        Set<RoleEntity> roleEntities = CacheUtil.viewCache.sceneID_usersMap.get(currRoleEntity.getSceneId());
        List<OtherPeopleListDto> otherPeopleList = new ArrayList<>();
        for (RoleEntity roleEntity : roleEntities) {
            if (!roleEntity.equals(currRoleEntity)) {
                User user = roleEntity.getUser();
                OtherPeopleListDto dto = new OtherPeopleListDto();
                dto.setPeopleName(user.getPeopleName());
                dto.setUserId(user.getUserId());
                otherPeopleList.add(dto);
            }
        }
        HttpServletRequest request = RequestUtil.getRequest();
        request.setAttribute("otherPeopleList", otherPeopleList);
    }

    public void sayToOtherPeopleReady(Long userId) {
        RoleEntity currRoleEntity = CacheUtil.roleEntityCache.userID_roleEntityMap.get(userId);
        HttpServletRequest request = RequestUtil.getRequest();
        request.setAttribute("userId", currRoleEntity.getUser().getUserId());
        request.setAttribute("peopleName", currRoleEntity.getUser().getPeopleName());
    }

    public String setName(String count) {
        HttpServletRequest request = RequestUtil.getRequest();
        boolean flag = IllegalWordsSearch.getInstance().ContainsAny(count);
        if (flag) {
            request.setAttribute("tips", "对不起，这种名字会造成其他人的困扰。");
            return StaticConstant.DEFAULT_JSP_DIRECTORY + "/wrong";
        }
        String reg = "[\\u4e00-\\u9fa5]+";
        Matcher m = Pattern.compile(reg).matcher(count);
        boolean flag2;
        flag2 = m.matches();
        if (!flag2) {
            request.setAttribute("tips", "请输入中文");
            return StaticConstant.DEFAULT_JSP_DIRECTORY + "/wrong";
        }
        if (count.length() > 6) {
            request.setAttribute("tips", "对不起，你的中文名字必须是一到六个中文汉字。");
            return StaticConstant.DEFAULT_JSP_DIRECTORY + "/wrong";
        }
        User userCon = new User();
        userCon.setPeopleName(count);
        User user = userMappper.selectOne(Wrappers.lambdaQuery(userCon));
        if (user != null) {
            request.setAttribute("tips", "该名字已经被人取了");
            return StaticConstant.DEFAULT_JSP_DIRECTORY + "/wrong";
        }
        User user1 = CacheUtil.getCurrRoleEntity().getUser();
        Long userId = user1.getUserId();
        userCon.setUserId(userId);
        userMappper.updateById(userCon);
        if (user1.getSex() == null) {
            return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/setName/setSex";
        }
        user1.setPeopleName(count);
        request.setAttribute("tips", "ok");
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/wrong";
    }

    public String setSex(Integer sex) {
        User user = CacheUtil.getCurrRoleEntity().getUser();
        Long userId = user.getUserId();
        User userCon = new User();
        userCon.setSex(sex);
        userCon.setUserId(userId);
        userMappper.updateById(userCon);
        user.setSex(sex);
        HttpServletRequest request = RequestUtil.getRequest();
        request.setAttribute("tips", "ok");
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/wrong";
    }

    public String setNamePage() {
        User user1 = CacheUtil.getCurrRoleEntity().getUser();
        if (!StaticConstant.NO_NAME.equals(user1.getPeopleName())) {
            if (user1.getSex() == null) {
                return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/setName/setSex";
            } else {
                HttpServletRequest request = RequestUtil.getRequest();
                request.setAttribute("tips", "已经有姓名了，不要来捣乱！！！");
                return StaticConstant.DEFAULT_JSP_DIRECTORY + "/wrong";
            }
        }
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/setName/setName";
    }

    public void getBodyStatus() {
        HttpServletRequest request = RequestUtil.getRequest();
        RoleEntity currRoleEntity = CacheUtil.getCurrRoleEntity();
        User user = currRoleEntity.getUser();
        RoleInfo roleInfo = currRoleEntity.getRoleInfo();
        BodyStatusDto dto = new BodyStatusDto();
        BeanUtils.copyProperties(roleInfo,dto);
        BigDecimal xiuXing = user.getXiuXing();
        int nian = xiuXing.intValue();
        BigDecimal tianBig = xiuXing.subtract(BigDecimal.valueOf(nian)).multiply(BigDecimal.valueOf(250));
        int tian = tianBig.intValue();
        int shiChen = tianBig.subtract(BigDecimal.valueOf(tian)).multiply(BigDecimal.valueOf(4)).intValue();
        //250天=1年，1天=1/250年=0.004年
        //12时辰=1天，3时辰=1/250/4年=0.0001年
        StringBuffer sb = new StringBuffer();
        if(nian > 0){
            sb.append(NumberHanZiFormat.format(nian)+"年");
        }
        if(tian > 0){
            sb.append(NumberHanZiFormat.format(tian)+"天");
        }
        if(shiChen > 0){
            sb.append(NumberHanZiFormat.format(shiChen)+"时辰");
        }
        dto.setXiuXingStr(sb.toString());
        request.setAttribute("bodyStatusDto", dto);
    }

    public String getSkillList() {
        HttpServletRequest request = RequestUtil.getRequest();
        RoleEntity currRoleEntity = CacheUtil.getCurrRoleEntity();
        List<RoleSkillDto> dtoList = currRoleEntity.getRoleSkillList();
        request.setAttribute("roleSkillList", dtoList);
        request.setAttribute("skillCount", NumberHanZiFormat.format(currRoleEntity.getRoleSkillList().size()));
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/bodyStatus/skillList";
    }

    public String getSkillSpecCanSet(Integer skillID) {
        HttpServletRequest request = RequestUtil.getRequest();
        RoleEntity currRoleEntity = CacheUtil.getCurrRoleEntity();
        List<RoleSkillDto> roleSkillList = currRoleEntity.getRoleSkillList();
        SkillEnum skillEnum = SkillEnum.getSkillById(skillID);
        int specialSkill = skillEnum.getSpecialSkill();
        //如果是基本武功
        if(specialSkill==0){
            List<RoleSkillDto> result = new ArrayList<>();
            boolean flag = false;
            Map<Integer, Integer> typeSkillIDMap = currRoleEntity.getTypeSkillIDMap();
            Integer alreadyBindskillID = typeSkillIDMap.get(skillEnum.getSkillFuncType());
            for (RoleSkillDto roleSkill:roleSkillList) {
                if(roleSkill.getSpecialSkill()==1){
                    List<Integer> skillFuncTypeList = roleSkill.getSkillFuncTypeList();
                    if(skillFuncTypeList.contains(skillEnum.getSkillFuncType())){
                        if(!flag && roleSkill.getSkillID().equals(alreadyBindskillID)){
                            RoleSkillDto dto = new RoleSkillDto();
                            BeanUtils.copyProperties(roleSkill,dto);
                            dto.setAlreadyBind(1);
                            result.add(dto);
                            flag = true;
                        }else {
                            result.add(roleSkill);
                        }
                    }
                }
            }
            request.setAttribute("roleSkillList", result);
            request.setAttribute("skillCount", NumberHanZiFormat.format(result.size()));
            request.setAttribute("specialSkill", 0);
            request.setAttribute("funcType", skillEnum.getSkillFuncType());
        }else {
            request.setAttribute("specialSkill", 1);
            request.setAttribute("skillName", skillEnum.getName());
        }
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/bodyStatus/skillSpecListToSet";
    }

    public String setSkillSpec(Integer skillID, int funcType) {
        HttpServletRequest request = RequestUtil.getRequest();
        RoleEntity currRoleEntity = CacheUtil.getCurrRoleEntity();
        Long userId = currRoleEntity.getUser().getUserId();
        List<RoleSkillDto> roleSkillList = currRoleEntity.getRoleSkillList();
        SkillEnum skillEnum = SkillEnum.getSkillById(skillID);
        //找到这种类型的同种已配置的武功
//        List<SkillEnum> skillByFuncType = SkillEnum.getSkillByFuncType(skillEnum.getSkillFuncType());
        request.setAttribute("skillName",skillEnum.getName());
        Map<Integer, Integer> typeSkillIDMap = currRoleEntity.getTypeSkillIDMap();
        Integer alreadyBindSkillID = typeSkillIDMap.get(funcType);
        if(alreadyBindSkillID!=null){
            if(alreadyBindSkillID.equals(skillID)){
                return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/bodyStatus/setSkillSpecSuccess";
            }
            TypeSkill typeSkill = new TypeSkill();
            typeSkill.setUserID(userId);
            typeSkill.setType(funcType);
            TypeSkill typeSkil2 = new TypeSkill();
            typeSkil2.setSkillID(skillID);
            typeSkillMappper.update(typeSkil2,Wrappers.lambdaUpdate(typeSkill));
        }else {
            TypeSkill typeSkill = new TypeSkill();
            typeSkill.setUserID(userId);
            typeSkill.setSkillID(skillID);
            typeSkill.setType(funcType);
            typeSkillMappper.insert(typeSkill);
        }
        typeSkillIDMap.put(funcType,skillID);
        for (RoleSkillDto roleSkillDto:roleSkillList) {
            if(roleSkillDto.getSkillID().equals(skillID)){
                roleSkillDto.setInUsed(1);
            }
            if(roleSkillDto.getSkillID().equals(alreadyBindSkillID)){
                roleSkillDto.setInUsed(0);
            }
        }
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/bodyStatus/setSkillSpecSuccess";
    }
}
