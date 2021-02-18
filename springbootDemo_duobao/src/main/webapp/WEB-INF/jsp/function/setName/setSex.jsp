<%@ page import="com.jida.common.util.CommonUtil" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/include/public.jsp"%>
<html>
<head>
    <title>夺宝江湖</title>
    <base href="<%=basePath%>">
</head>
<body>
<font size="4">
    请选择你的性别，一旦选定无法更改，请仔细选取：<br/>
    <a href="<%=CommonUtil.getStandardUrl("setSex?sex=0")%>">男</a> |
    <a href="<%=CommonUtil.getStandardUrl("setSex?sex=1")%>">女</a>
</font><br>
</body>
</html>

