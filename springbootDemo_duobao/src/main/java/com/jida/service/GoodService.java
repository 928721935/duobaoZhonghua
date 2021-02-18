package com.jida.service;

import com.jida.common.cache.data.RoleEntity;
import com.jida.common.constant.StaticConstant;
import com.jida.common.util.CacheUtil;
import com.jida.common.util.RequestUtil;
import com.jida.dto.GoodDetailEquipmentDto;
import com.jida.entity.GoodDetailEquipment;
import com.jida.entity.UserGood;
import com.jida.mapper.GoodDetailEquipmentMappper;
import com.jida.mapper.UserGoodMappper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class GoodService {
    @Resource
    private GoodDetailEquipmentMappper goodDetailEquipmentMappper;
    @Resource
    private UserGoodMappper userGoodMappper;

    public void getBaggageGoodList() {
        RoleEntity currRoleEntity = CacheUtil.getCurrRoleEntity();
        HttpServletRequest request = RequestUtil.getRequest();
        List<UserGood> userGoodList = currRoleEntity.getUserGoodList();
        request.setAttribute("userGoodList",userGoodList);
    }

    public String goodDetail(Integer goodType, Integer goodID) {
        HttpServletRequest request = RequestUtil.getRequest();
        if (goodType==1){
            GoodDetailEquipmentDto dto = userGoodMappper.getDetailEquipment(goodID);
            request.setAttribute("goodDetailEquipment",dto);
            return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/baggage/goodDetailEquipment";
        }
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/baggage/goodDetailEquipment";
    }
}
