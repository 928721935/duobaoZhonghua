package com.jida.controller;

import com.jida.aspesct.BeAttackAnnotation;
import com.jida.service.MoveService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping
@BeAttackAnnotation
public class MoveController {
    @Resource
    private MoveService moveService;

    @ApiOperation("玩家移动")
    @GetMapping("/moveMap")
    public String index3(String redirection) {
        return moveService.moveMap(redirection);
    }

    @ApiOperation("环顾四方/返回游戏")
    @GetMapping("/flashView")
    public String index4() {
        return moveService.flashView();
    }
}
