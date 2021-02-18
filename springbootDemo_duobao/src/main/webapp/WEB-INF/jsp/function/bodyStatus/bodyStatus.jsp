<%@ page import="com.jida.dto.BodyStatusDto" %>
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
        <%BodyStatusDto dto = (BodyStatusDto)request.getAttribute("bodyStatusDto");%>
        气血：<%=dto.getShengMingCurr()%>/<%=dto.getShengMingMax()%><br/>
        精神：<%=dto.getJingShenCurr()%>/<%=dto.getJingShenMax()%><br/>
        内力：<%=dto.getNeiLiCurr()%>/<%=dto.getNeiLiMax()%><br/>
        潜能：<%=dto.getQianNengCurr()%>/<%=dto.getQianNengMax()%><br/>
        修为：<%=dto.getXiuXingStr()%><br/>
        内力攻击力：1880<br/>内力防御力：1880<br/>
        装备伤害力：314000000<br/>装备保护力：0<br/>
        装备躲避值：38<br/>总命中值：464<br/>
        总招架值：401<br/>总闪避值：176<br/>
        <a href="<%=CommonUtil.getStandardUrl("getSkillList")%>">配置技能</a><br/>
        <a href="game?cmd=9d89bcf51be45ce4a61cdc239e2794ec">修炼内力</a><br/>
        <a href="<%=CommonUtil.getStandardUrl("/function")%>">返回</a><br/>
        <a href="<%=CommonUtil.getStandardUrl("/flashView")%>">返回游戏</a></font><br>
    </font><br>
</body>
</html>

