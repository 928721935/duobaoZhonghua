package com.jida.controller;

import com.jida.aspesct.BeAttackAnnotation;
import com.jida.common.constant.StaticConstant;
import com.jida.service.GoodService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
@BeAttackAnnotation
public class GoodController {
    @Resource
    private GoodService goodService;

    @ApiOperation("物品详情")
    @GetMapping("/goodDetail")
    public String index1(Integer goodType, HttpServletRequest request) {
        String goodIDStr = request.getParameter("goodID");
        Integer goodID = goodIDStr==null?null:Integer.valueOf(goodIDStr);
        return goodService.goodDetail(goodType,goodID);
    }
}
