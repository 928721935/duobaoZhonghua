package com.jida.controller;

import com.jida.common.constant.StaticConstant;
import com.jida.service.ForumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

//论坛
@Controller
@RequestMapping("")
public class ForumController {
    @Resource
    private ForumService forumService;

    //进入论坛普通帖子列表页面
    @GetMapping("/forumNormalPostList")
    public String index1(HttpServletRequest request) {
        String pageNumStr = request.getParameter("pageNum");
        String pageSizeStr = request.getParameter("pageSize");
        //pageSize是每页显示几条记录
        //pageNum是第几页
        int pageNum = pageNumStr==null?1:Integer.valueOf(pageNumStr);
        int pageSize = pageSizeStr==null?10:Integer.valueOf(pageSizeStr);
        forumService.forumNormalPostList(pageNum-1,pageSize);
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/forum/forumNormalPostList";
    }

    //帖子详情
    @GetMapping("/forumPostDetail")
    public String index2(Long id,HttpServletRequest request) {
        String pageNumStr = request.getParameter("pageNum");
        String pageSizeStr = request.getParameter("pageSize");
        String postPageNumStr = request.getParameter("postPageNum");
        String postPageSizeStr = request.getParameter("postPageSize");
        //pageSize是每页显示几条记录
        //pageNum是第几页
        int pageNum = pageNumStr==null?1:Integer.valueOf(pageNumStr);
        int pageSize = pageSizeStr==null?10:Integer.valueOf(pageSizeStr);
        Integer postPageNum = postPageNumStr==null?1:Integer.valueOf(postPageNumStr);
        Integer postPageSize = postPageSizeStr==null?10:Integer.valueOf(postPageSizeStr);
        forumService.forumPostDetail(id,pageNum-1,pageSize,postPageNum,postPageSize);
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/forum/forumPostDetail";
    }

    @GetMapping("/replyPostPage")
    public String index3(Long postID,Integer postPageNum,Integer postPageSize,Integer replyPageNum,Integer replyPageSize) {
        forumService.replyPostPage(postID,postPageNum,postPageSize,replyPageNum,replyPageSize);
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/forum/forumReplyPage";
    }

    //回复帖子
    @PostMapping("/replyPost")
    public String index4(String count,Long postID,Integer postPageNum,Integer postPageSize,HttpServletRequest request) {
        String replyPageNumStr = request.getParameter("replyPageNum");
        String replyPageSizeStr = request.getParameter("replyPageSize");
        //pageSize是每页显示几条记录
        //pageNum是第几页
        Integer replyPageNum = replyPageNumStr==null?1:Integer.valueOf(replyPageNumStr);
        Integer replyPageSize = replyPageSizeStr==null?10:Integer.valueOf(replyPageSizeStr);
        return forumService.replyPost(count,postID,postPageNum,postPageSize,replyPageNum,replyPageSize);
    }

    @GetMapping("/forumSendPostPage")
    public String index5(Integer postPageNum,Integer postPageSize) {
        forumService.forumSendPostPage(postPageNum,postPageSize);
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/forum/forumSendPostPage";
    }

    //发帖子
    @PostMapping("/sendPost")
    public String index6(String count,String other,Integer postPageNum,Integer postPageSize) {
        return forumService.sendPost(count,other,postPageNum,postPageSize);
    }
}
