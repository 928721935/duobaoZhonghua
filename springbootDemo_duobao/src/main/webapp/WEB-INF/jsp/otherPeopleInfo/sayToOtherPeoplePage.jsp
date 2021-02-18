<%@ page import="com.jida.common.util.CommonUtil" %>
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
    <form action="game" method="post">
        你要对${peopleName}什么？<br/>
        输入想说的话:<br/>
        <input type="text" name="count"/><br/>
        <input type="hidden" name="cmd" value="<%=CommonUtil.getStandardPostCmd("sayToOtherPeople?userId=" + request.getParameter("userId"))%>"/>
        <input type="submit" value="确定"/><br/>
        <a href="<%=CommonUtil.getStandardUrl("/getOtherPeopleInfo?userId="+request.getParameter("userId"))%>">返回</a><br/>
        <a href="<%=CommonUtil.getStandardUrl("/flashView")%>">返回游戏</a></font><br>
    </form>
</font><br>
</body>
</html>

