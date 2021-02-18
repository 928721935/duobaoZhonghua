<%@ page import="com.jida.dto.OtherPeopleInfoDto" %>
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
    <%OtherPeopleInfoDto otherPeopleInfoDto = (OtherPeopleInfoDto)request.getAttribute("otherPeopleInfoDto");%>
    【长老】少林寺第一代弟子「留个回忆」${otherPeopleInfoDto.peopleName}<br/>
    红名值：0<br/>
    杀人数：0 被杀数：0<br/>
    江湖名声：0 擂台积分：0<br/>
    她生得丰胸细腰，妖娆多姿，让人一看就心跳不已。<br/>
    看起来约二百二十多岁。<br/>武功看起来好象深不可测，出手似乎匪夷所思。<br/>
    她看起来气血充盈，并没有受伤。<br/>
    她身上带有：<br/>
    □「爱恨缠绵刀」<br/>
    □「白蟒靴」<br/>
    <a href="game?cmd=f2fe328231fcb721e54b9e02d79c0b36">千子</a>的娘子<br/>
    <a href="<%=CommonUtil.getStandardUrl("/sayToOtherPeopleReady?userId="+otherPeopleInfoDto.getUserId())%>">对话</a> |
    <a href="game?cmd=fa6c15e97fff8150437b80d7bb68cdf7e11f14aba33c6b7e">给予</a><br/>
    <a href="<%=CommonUtil.getStandardUrl("/attack?userId="+otherPeopleInfoDto.getUserId())%>">杀戮</a> |
    <a href="game?cmd=d02760eafbc6d17f1e37d067ab90ea65">切磋</a><br/>
    <a href="game?cmd=af3ebfee72de78e9ba4ff2da9c3561bc974a3cf31121ee82477f102b524cb039">关注</a> |
    <a href="game?cmd=4256ec0cec015bf501028fc4400f31f8477f102b524cb039">组队</a><br/>
    <a href="game?cmd=40ab399285223074ac7416bd7ba913e21e37d067ab90ea65">交易</a><br/>
    <a href="<%=CommonUtil.getStandardUrl("/getOtherPeopleList")%>">返回</a><br/>
    <a href="<%=CommonUtil.getStandardUrl("/flashView")%>">返回游戏</a></font><br>
</body>
</html>

