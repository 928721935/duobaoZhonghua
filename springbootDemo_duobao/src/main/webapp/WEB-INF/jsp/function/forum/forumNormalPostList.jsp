<%@ page import="com.jida.dto.ForumNormalPostListDto" %>
<%@ page import="com.jida.dto.ForumPostDto" %>
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
        ForumNormalPostListDto forumNormalPostListDto = (ForumNormalPostListDto)request.getAttribute("forumNormalPostListDto");
        int postIndex = 0;
    %>
    <a href="game?cmd=cbdda0d31af4a3c3c92b79c6b6f5d63c8b92c2fd501cec7e5c01d8209d139018">精华区</a><br/>
    版主：龙吟天下，冲灵，莫言，云裳，雪瑶<br/>
    <%--《顶》<a href="game?cmd=cbdda0d31af4a3c367bf8ca950edd08f62d3ddde6a5d34ffa4ecfb5ee3d725a1">击杀神秘人活动</a><br/>
    《顶》<a href="game?cmd=cbdda0d31af4a3c367bf8ca950edd08f2189d940a0047eeba4ecfb5ee3d725a1">征集武功新描述</a><br/>--%>
    <%for (ForumPostDto forumPostDto : forumNormalPostListDto.getTopList()){ %>
    《顶》<a href="<%=CommonUtil.getStandardUrl("forumPostDetail?id="+forumPostDto.getId()+"&postPageNum="+forumNormalPostListDto.getCurrPage()+"&postPageSize="+10)%>"><%=forumPostDto.getTitle()%></a><br/>
    <%}%>

    <%for (ForumPostDto forumPostDto : forumNormalPostListDto.getDataList()){ %>
    <%=++postIndex +(forumNormalPostListDto.getCurrPage()-1)*10%>.<a href="<%=CommonUtil.getStandardUrl("forumPostDetail?id="+forumPostDto.getId()+"&postPageNum="+forumNormalPostListDto.getCurrPage()+"&postPageSize="+10)%>"><%=forumPostDto.getTitle()%></a><br/>
    <%=forumPostDto.getSenderPeopleName()%> <%=forumPostDto.getReplyNum()%>/<%=forumPostDto.getReadNum()%><br/>
    <%}%>

    共<%=forumNormalPostListDto.getCount()%>帖,<%=forumNormalPostListDto.getCurrPage()%>/<%=forumNormalPostListDto.getTotalPage()%>页<br/>
    <%if(forumNormalPostListDto.getCurrPage()!=1){%>
        <a href="<%=CommonUtil.getStandardUrl("forumNormalPostList?pageNum="+(forumNormalPostListDto.getCurrPage()-1)+"&pageSize="+10)%>">上一页</a>
    <%}%>
    <%if(forumNormalPostListDto.getCurrPage()!=1 && forumNormalPostListDto.getCurrPage()!=forumNormalPostListDto.getTotalPage()){%>
    |
    <%}%>
    <%if(forumNormalPostListDto.getCurrPage()!=forumNormalPostListDto.getTotalPage()){%>
        <a href="<%=CommonUtil.getStandardUrl("forumNormalPostList?pageNum="+(forumNormalPostListDto.getCurrPage()+1)+"&pageSize="+10)%>">下一页</a>
    <%}%>
    <br/>
    <a href="<%=CommonUtil.getStandardUrl("forumSendPostPage?postPageNum="+forumNormalPostListDto.getCurrPage()+"&postPageSize="+10)%>">发帖</a><br/>
    <a href="<%=CommonUtil.getStandardUrl("flashView")%>">返回游戏</a>
</font><br>
</body>
</html>

