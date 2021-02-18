<%@ page import="com.jida.entity.RoleSkill" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jida.dto.RoleSkillDto" %>
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
        <%List<RoleSkillDto> dtoList = (List<RoleSkillDto>)request.getAttribute("roleSkillList");%>
        你目前共学过${skillCount}种技能：<br/>
        <%for (RoleSkillDto item : dtoList){ %>
            <a href="<%=CommonUtil.getStandardUrl("getSkillSpecCanSet?skillID="+item.getSkillID())%>"><%=(item.getInUsed()==1?"□":"  ")+item.getSkillName()%>(<%=item.getLevel()%>级/<%=item.getStudyPercent()%>%)</a><br/>
        <%}%>
        请点击要配置武功的基础武功类型<br/>
        武功名称后括号中左边的数表示该项武功的等级，右边的数是这个级别的升级点数<br/>
        <a href="<%=CommonUtil.getStandardUrl("bodyStatus")%>">返回</a><br/>
        <a href="<%=CommonUtil.getStandardUrl("flashView")%>">返回游戏</a>
    </font><br>
</body>
</html>

