package com.jida.controller;

import com.jida.aspesct.BeAttackAnnotation;
import com.jida.common.constant.StaticConstant;
import com.jida.service.ChatService;
import com.jida.service.GoodService;
import com.jida.service.SelfInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RequestMapping("")
@Controller
@BeAttackAnnotation
public class FunctionController {
    @Resource
    private ChatService chatService;
    @Resource
    private SelfInfoService selfInfoService;
    @Resource
    private GoodService goodService;

    @ApiOperation("状态/选项")
    @GetMapping("/function")
    public String index4() {
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function";
    }

    @ApiOperation("身体状态")
    @GetMapping("/bodyStatus")
    public String index5() {
        selfInfoService.getBodyStatus();
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/bodyStatus/bodyStatus";
    }

    @ApiOperation("个人信息")
    @GetMapping("/selfInfo")
    public String index6() {
        return selfInfoService.getSelfInfo();
    }

    @ApiOperation("聊天频道")
    @GetMapping("/chatChannel")
    public String index7() {
        chatService.getWord();
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/chatChannel/chatChannel";
    }

    @ApiOperation("准备公聊")
    @GetMapping("/readySayPublic")
    public String index9() {
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/chatChannel/sayPublic";
    }

    @ApiOperation("公聊发言")
    @PostMapping("/sayPublic")
    public String index10(String count) {
        return chatService.sayWord(count);
    }

    //物品详情
    @GetMapping("/baggage")
    public String index11() {
        goodService.getBaggageGoodList();
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/baggage/baggage";
    }

    @ApiOperation("获取当前场景人物列表")
    @GetMapping("/getOtherPeopleList")
    public String index12() {
        selfInfoService.getOtherPeopleList();
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/otherPeopleInfo/otherPeopleList";
    }

    @ApiOperation("获取其他人物详情")
    @GetMapping("/getOtherPeopleInfo")
    public String index13(Long userId) {
        return selfInfoService.getOtherPeopleInfo(userId);
    }

    @ApiOperation("准备与其他人对话")
    @GetMapping("/sayToOtherPeopleReady")
    public String index14(Long userId) {
        selfInfoService.sayToOtherPeopleReady(userId);
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/otherPeopleInfo/sayToOtherPeoplePage";
    }

    @ApiOperation("与其他人对话")
    @PostMapping("/sayToOtherPeople")
    public String index15(Long userId,String count) {
        chatService.sayToOtherPeople(userId,count);
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/otherPeopleInfo/sayToOtherPeopleSuccessPage";
    }

    @ApiOperation("取名字")
    @PostMapping("/setName")
    public String index16(String count) {
        return selfInfoService.setName(count);
    }

    @ApiOperation("取名字页面")
    @GetMapping("/setNamePage")
    public String index17() {
        return selfInfoService.setNamePage();
    }

    @ApiOperation("选择性别")
    @GetMapping("/setSex")
    public String index18(Integer sex) {
        return selfInfoService.setSex(sex);
    }

    @ApiOperation("所学武功列表")
    @GetMapping("/getSkillList")
    public String index19() {
        return selfInfoService.getSkillList();
    }

    @ApiOperation("可配置的特殊武功")
    @GetMapping("/getSkillSpecCanSet")
    public String index20(Integer skillID) {
        return selfInfoService.getSkillSpecCanSet(skillID);
    }

    @ApiOperation("配置特殊武功")
    @GetMapping("/setSkillSpec")
    public String index21(Integer skillID,int funcType) {
        return selfInfoService.setSkillSpec(skillID,funcType);
    }
}
