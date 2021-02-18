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
    <form action="game" method="post">
        主题(20字以内):<br/>
        <input type="text" name="count" value="${count}"/>${tipTitle}<br/>
        内容(800字以内):<br/>
        <textarea name="other" rows="10" cols="29">${other}</textarea>${tipContent}<br/>
        <input type="hidden" name="cmd" value="<%=CommonUtil.getStandardPostCmd("sendPost?&postPageNum="+postPageNum+"&postPageSize="+10)%>"/>
        <input type="submit" value="确定"/><br/>
        <a href="<%=CommonUtil.getStandardUrl("forumNormalPostList?pageNum="+postPageNum+"&pageSize="+10)%>">返回</a><br/>
        <a href="<%=CommonUtil.getStandardUrl("flashView")%>">返回游戏</a>
    </form>
</font><br>
</body>
</html>

