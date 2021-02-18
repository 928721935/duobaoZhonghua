<%@ page import="com.jida.dto.ChatRecordDTO" %>
<%@ page import="java.util.List" %>
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
    <a href="<%=CommonUtil.getStandardUrl("/readySayPublic")%>">发言</a> |
    <a href="<%=CommonUtil.getStandardUrl("/chatChannel")%>">刷新</a><br/>
    当前公共聊天频道<br/>
    <%List<ChatRecordDTO> list = (List<ChatRecordDTO>)request.getAttribute("lis");%>
    <%for (ChatRecordDTO item : list){ %>
        (<%=CommonUtil.translateDate1(item.getCreateTime())%>)<a href="<%=CommonUtil.getStandardUrl("/getOtherPeopleInfo?userId="+item.getSendUserId())%>"><%=item.getSendPeopleName()%></a>对大家说：<%=item.getMsg()%><br/>
    <%}%>
    <a href="<%=CommonUtil.getStandardUrl("/function")%>">返回</a><br/>
    <a href="<%=CommonUtil.getStandardUrl("/flashView")%>">返回游戏</a></font><br>
</font><br>
</body>
</html>

