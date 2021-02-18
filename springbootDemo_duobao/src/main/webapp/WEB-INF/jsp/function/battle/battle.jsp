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
    <a href="<%=CommonUtil.getStandardUrl("flashBattleRecord")%>">查看战况</a>
    <a href="game?cmd=70b3de62408847e7774b7df9d0939ff8">特殊攻击</a>
    <a href="game?cmd=67b2b6c1a861acd90bcb309a7461ff2d">逃跑</a><br/>
    ${battle_private_msg}
</font><br>
</body>
</html>

