package com.jida.controller;

import com.jida.common.util.CommonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Controller
@RequestMapping("")
public class RouteController {
    /*@GetMapping("/view")
    public String index(@RequestParam("cmd") String cmd) {
        return cmd;
    }*/

    @GetMapping("/game")
    public String index2(@RequestParam("cmd") String cmd) {
        cmd = CommonUtil.decryptStr(cmd);
        cmd =CommonUtil.removeTimeStamp(cmd);
        System.out.println(cmd);
        return "forward:/"+cmd;
    }

    @PostMapping("/game")
    public String index8(@RequestParam("cmd") String cmd) {
        cmd = CommonUtil.decryptStr(cmd);
        cmd =CommonUtil.removeTimeStamp(cmd);
        System.out.println(cmd);
        return "forward:/"+cmd;
    }

    /*@GetMapping("/test1")
    public String index3(String a1,String a2) {
        return "/2";
    }*/
}
