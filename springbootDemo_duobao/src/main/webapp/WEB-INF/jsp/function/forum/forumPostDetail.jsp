<%@ page import="com.jida.dto.ForumPostDetailDto" %>
<%@ page import="com.jida.dto.ForumPostDto" %>
<%@ page import="com.jida.dto.ForumReplyDto" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/public.jsp"%>
<html>
<head>
    <title>夺宝江湖</title>
    <base href="<%=basePath%>">
</head>
<body>
    <font size="4">
        <%
            ForumPostDetailDto forumNormalPostListDto = (ForumPostDetailDto)request.getAttribute("forumPostDetailDto");
            ForumPostDto postData = forumNormalPostListDto.getPostData();
            int replyIndex = 0;
        %>
        主题：<%=postData.getTitle()%><br/>
        <a href="<%=CommonUtil.getStandardUrl("getOtherPeopleInfo?userId="+postData.getSenderID())%>"><%=postData.getSenderPeopleName()%></a><br/>
        [<%=CommonUtil.translateDate2(postData.getCreateTime())%>]<br/>
        ------------------内容-----------------------<br/>
        <%=postData.getContent()%><br/>
        <%if(forumNormalPostListDto.getCount()!=0){%>
            ------------------回复-----------------------<br/>
            <%for (ForumReplyDto forumReplyDto : forumNormalPostListDto.getReplyList()){ %>
            <%=forumNormalPostListDto.getCount()-(++replyIndex+(forumNormalPostListDto.getCurrPage()-1)*10)+1%>楼:<%=forumReplyDto.getMsg()%><br/>
            <a href="<%=CommonUtil.getStandardUrl("getOtherPeopleInfo?userId="+forumReplyDto.getReplyerID())%>"><%=forumReplyDto.getReplyerPeopleName()%></a>
            <%=CommonUtil.translateDate2(forumReplyDto.getCreateTime())%><br/>
            <%}%>
            共<%=forumNormalPostListDto.getCount()%>条回复,<%=forumNormalPostListDto.getCurrPage()%>/<%=forumNormalPostListDto.getTotalPage()%>页<br/>
            <%if(forumNormalPostListDto.getCurrPage()!=1){%>
            <a href="<%=CommonUtil.getStandardUrl("forumPostDetail?id="+forumNormalPostListDto.getPostData().getId()+"&pageNum="+(forumNormalPostListDto.getCurrPage()-1)+"&pageSize="+10)%>">上一页</a>
            <%}%>
            <%if(forumNormalPostListDto.getCurrPage()!=1 && forumNormalPostListDto.getCurrPage()!=forumNormalPostListDto.getTotalPage()){%>
            |
            <%}%>
            <%if(forumNormalPostListDto.getCurrPage()!=forumNormalPostListDto.getTotalPage()){%>
            <a href="<%=CommonUtil.getStandardUrl("forumPostDetail?id="+forumNormalPostListDto.getPostData().getId()+"&pageNum="+(forumNormalPostListDto.getCurrPage()+1)+"&pageSize="+10)%>">下一页</a>
            <%}%>

            <%if(forumNormalPostListDto.getCurrPage()!=1 || forumNormalPostListDto.getCurrPage()!=forumNormalPostListDto.getTotalPage()){%>
                <br/>
            <%}%>
        <%}%>
        <a href="<%=CommonUtil.getStandardUrl("replyPostPage?postID="+forumNormalPostListDto.getPostData().getId()+"&postPageNum="+forumNormalPostListDto.getPostPageNum()+"&postPageSize="+10+"&replyPageNum="+forumNormalPostListDto.getCurrPage()+"&replyPageSize="+10)%>">回复</a><br/>
        <a href="<%=CommonUtil.getStandardUrl("forumNormalPostList?pageNum="+forumNormalPostListDto.getPostPageNum()+"&pageSize="+forumNormalPostListDto.getPostPageSize())%>">返回</a><br/>
        <a href="<%=CommonUtil.getStandardUrl("flashView")%>">返回游戏</a>
    </font><br>
</body>
</html>

