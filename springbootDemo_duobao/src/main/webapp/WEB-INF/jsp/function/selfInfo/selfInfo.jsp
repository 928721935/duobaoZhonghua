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
    <a href="game?cmd=93c797d1457d0e7a">修改个人设定</a>
    <a href="game?cmd=1b63fae7434db09e">个人数据存盘</a><br/>
    【长老】少林第一代弟子${selfInfo.peopleName} 【蜀山战盟】<br/>
    红名值：0<br/>
    杀人数：9757 被杀数：4139<br/>
    江湖名声：-7586 擂台积分：0<br/>
    转生：一百<br/>
    你生得剑眉星目，英姿勃勃，仪表不凡。<br/>
    今年九十七岁。<br/>
    武功看起来好象天下无敌，出手似乎斗破苍穹。<br/>
    你看起来气血充盈，并没有受伤。<br/>
    技能有效等级：<br/>
    基本招架（降龙十八掌）：10615<br/>
    基本轻功（少林身法）：62<br/>
    基本剑法（达摩剑）：56<br/>
    基本拳脚（降龙十八掌）：852<br/>
    基本内功（混元一气功）：1<br/>
    <a href="<%=CommonUtil.getStandardUrl("/function")%>">返回</a><br/>
    <a href="<%=CommonUtil.getStandardUrl("/flashView")%>">返回游戏</a></font><br>
</font><br>
</body>
</html>

