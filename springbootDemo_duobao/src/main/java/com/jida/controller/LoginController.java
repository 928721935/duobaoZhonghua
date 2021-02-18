package com.jida.controller;

import com.jida.common.constant.StaticConstant;
import com.jida.common.util.VerifyCodeUtil;
import com.jida.service.LoginService;
import com.jida.service.MoveService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping
public class LoginController {
    @Resource
    private LoginService loginService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public String index1(String username, String password) {
        return loginService.login(username,password);
    }

    @ApiOperation("注册页面")
    @GetMapping("/registerPage")
    public String index2() {
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/registerPage";
    }

    @ApiOperation("获取图形验证码")
    @GetMapping("/getVerifiyCode")
    @ResponseBody
    public void index3(HttpSession session, HttpServletResponse response) throws IOException {
        String verifyCode = VerifyCodeUtil.generateVerifyCode(4);
        //存入会话session
        session.setAttribute("verifiyCode", verifyCode.toLowerCase());
        //生成图片
        int w = 100, h = 40;
        VerifyCodeUtil.outputImage(w, h, response.getOutputStream(), verifyCode);
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public String index1(String username, String password,String password2,String code) {
        return loginService.register(username,password,password2,code);
    }
}
