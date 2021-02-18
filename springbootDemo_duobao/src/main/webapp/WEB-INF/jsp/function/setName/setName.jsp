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
    <form action="game" method="post">
        请输入你的中文姓名，一旦选定无法更改，请仔细选取（名字长度不能超过六个中文汉字）：<br/>
        输入名字<input type="text" name="count"/><br>
        <input type="hidden" name="cmd" value="<%=CommonUtil.getStandardPostCmd("setName")%>"/>
        <input type="submit" value="确定"/><br/>
        <a href="<%=CommonUtil.getStandardUrl("/flashView")%>">返回</a><br/>
        <a href="<%=CommonUtil.getStandardUrl("/flashView")%>">返回游戏</a>
    </form>
</font><br>
</body>
</html>

