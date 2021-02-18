package com.jida.controller;

import com.jida.aspesct.BeAttackAnnotation;
import com.jida.common.constant.StaticConstant;
import com.jida.service.BattleService;
import com.jida.service.ChatService;
import com.jida.service.SelfInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@RequestMapping("")
@Controller
public class BattleController {
    @Resource
    private BattleService battleService;

    @ApiOperation("杀戮")
    @GetMapping("/attack")
    @BeAttackAnnotation
    public String index1(Long userId) {
        return battleService.attack(userId);
    }

    @ApiOperation("查看战况")
    @GetMapping("/flashBattleRecord")
    public String index2() {
        return battleService.flashBattleRecord();
    }
}
