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
    你对${otherUserName}说：${word}<br/>
    <a href="<%=CommonUtil.getStandardUrl("/getOtherPeopleInfo?userId="+request.getAttribute("otherUserId"))%>">返回</a><br/>
    <a href="<%=CommonUtil.getStandardUrl("/flashView")%>">返回游戏</a></font><br>
</font><br>
</body>
</html>

