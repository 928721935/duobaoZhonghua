
<%@ page import="com.jida.dto.OtherPeopleListDto" %>
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
    <%List<OtherPeopleListDto> list = (List<OtherPeopleListDto>)request.getAttribute("otherPeopleList");%>
    <%for (OtherPeopleListDto item : list){ %>
        <a href="<%=CommonUtil.getStandardUrl("getOtherPeopleInfo?userId="+item.getUserId())%>">少林寺第一代弟子<%=item.getPeopleName()%></a><br/>
    <%}%>
    <c:if test="${otherPeopleList.size()==0}">
        这里没有一个人，大家都走开了<br>
    </c:if>
    <a href="<%=CommonUtil.getStandardUrl("/flashView")%>">返回</a><br/>
    <a href="<%=CommonUtil.getStandardUrl("/flashView")%>">返回游戏</a></font><br>
</font><br>
</body>
</html>

