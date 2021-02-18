<%@ page import="com.jida.dto.ForumReplySuccessDto" %>
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
        <%ForumReplySuccessDto dto = (ForumReplySuccessDto)request.getAttribute("forumReplySuccessDto");%>
        回帖成功！<br/>
        <a href="<%=CommonUtil.getStandardUrl("forumPostDetail?id="+dto.getPostID()+"&postPageNum="+dto.getPostPageNum()+"&postPageSize="+10)%>">返回</a><br/>
        <a href="<%=CommonUtil.getStandardUrl("flashView")%>">返回游戏</a>
    </font><br>
</body>
</html>

