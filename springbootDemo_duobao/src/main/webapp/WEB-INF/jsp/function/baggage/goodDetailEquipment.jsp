<%@ page import="com.jida.dto.GoodDetailEquipmentDto" %>
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
    <%GoodDetailEquipmentDto dto = (GoodDetailEquipmentDto)request.getAttribute("goodDetailEquipment");%>
    <%=dto.getGoodName()%><br/>
    <%if(dto.getGong()!=null){%>
    攻击力：<%=dto.getGong()%><br/>
    <%}%>
    <%if(dto.getFang()!=null){%>
    防御力：<%=dto.getFang()%><br/>
    <%}%>
    <%if(dto.getShan()!=null){%>
    闪避力：<%=dto.getShan()%><br/>
    <%}%>
    耐久：<%=dto.getCurrNaiJiu()%>/<%=dto.getMaxNaiJiu()%><br/>

    <%if(dto.getIsGrow()==1){%>
        成长：可成长<br/>
        成长度：<%=dto.getGrowValue()%><br/>
        基数度：<%=dto.getBasicGrowValue()%><br/>
        等级：<%=dto.getLevel()%><br/>
        最大等级：<%=dto.getMaxLevel()%><br/>
        经验：<%=dto.getCurrNaiJiu()%>/<%=dto.getMaxExperience()%><br/>
        <%if(dto.getLevel()>=dto.getMaxLevel()){%>
        已经达到最大等级。<br/>
        <%}%>
    <%}else{%>
        成长：不可成长<br/>
    <%}%>
    <%if(dto.getCanDamage()==1){%>
        特效：永不磨损<br/>
    <%}%>
    <%if(dto.getCanDrop()==1){%>
        特效：不可掉落<br/>
    <%}%>
    <%if(dto.getCanDiscard()==1){%>
        特效：不可丢弃<br/>
    <%}%>
    <%if(dto.getCanSell()==1){%>
        特效：不可交易<br/>
    <%}%>
    <%if(dto.getCanGive()==1){%>
        特效：不可给予<br/>
    <%}%>
    <%=dto.getDescription()%><br/>
    <a href="game?cmd=1f571884cef8c25b13fc9c7eb3486eab1bcec673c64008739f3c53cd577cdcdbe370a85d100e0b645874c118a931f9e6">装备</a><br/>
    <a href="game?cmd=2a29120fb1a4108313fc9c7eb3486eab1bcec673c64008739f3c53cd577cdcdbe370a85d100e0b64799adfc7f15f8b52c86fb70b00d99f9c5874c118a931f9e6">丢弃</a><br/>
    <a href="<%=CommonUtil.getStandardUrl("baggage")%>">返回</a><br/>
    <a href="<%=CommonUtil.getStandardUrl("flashView")%>">返回游戏</a>
</font><br>
</body>
</html>

