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
        Integer postPageNum = (Integer)request.getAttribute("postPageNum");
        Integer postPageSize = (Integer)request.getAttribute("postPageSize");
    %>
    发帖成功！<br/>
    <a href="<%=CommonUtil.getStandardUrl("forumNormalPostList?pageNum="+postPageNum+"&pageSize="+10)%>">返回</a><br/>
    <a href="<%=CommonUtil.getStandardUrl("flashView")%>">返回游戏</a>
</font><br>
</body>
</html>

