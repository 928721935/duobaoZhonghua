<%@ page import="com.jida.dto.RoleSkillDto" %>
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
    <%
        List<RoleSkillDto> dtoList = (List<RoleSkillDto>)request.getAttribute("roleSkillList");
        int specialSkill = (int)request.getAttribute("specialSkill");
    %>
    <%if(specialSkill==0){%>
        <%int funcType = (int)request.getAttribute("funcType");%>
        你目前共学过${skillCount}种能与之配置的特殊技能：<br/>
        <%for (RoleSkillDto item : dtoList){ %>
            <a href="<%=CommonUtil.getStandardUrl("setSkillSpec?skillID="+item.getSkillID()+"&funcType="+funcType)%>"><%=(item.getAlreadyBind()==1?"□":"  ")+item.getSkillName()%>(<%=item.getLevel()%>级/<%=item.getStudyPercent()%>%)</a><br/>
        <%}%>
        请点击要能与之配置的特殊技能<br/>
    <%}%>
    <%if(specialSkill==1){%>
        <%String skillName = (String) request.getAttribute("skillName");%>
        <%=skillName%><br/><%=skillName%><br/>
    <%}%>
    <a href="<%=CommonUtil.getStandardUrl("getSkillList")%>">返回</a><br/>
    <a href="<%=CommonUtil.getStandardUrl("flashView")%>">返回游戏</a>
</font><br>
</body>
</html>

