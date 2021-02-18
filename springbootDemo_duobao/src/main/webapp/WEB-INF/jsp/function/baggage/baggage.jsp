<%@ page import="com.jida.entity.UserGood" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jida.common.util.NumberHanZiFormat" %>
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
    <%List<UserGood> dtoList = (List<UserGood>)request.getAttribute("userGoodList");%>
    你身上带著下列这些东西(负重 15%)<br/>
    <%for (UserGood item : dtoList){ %>
        <a href="<%=CommonUtil.getStandardUrl("goodDetail?goodType="+item.getGoodType()+"&goodID="+item.getGoodID())%>">  <%=NumberHanZiFormat.format(item.getGoodCount())+item.getUnit()+item.getGoodName()%></a><br/>
    <%}%>

   <%-- <a href="game?cmd=9aa0b554fcc7d678243026c629bcd53847b854c9bb17e900ed53667f38bd1702aa99ac8ae9809a49">  一千三百二十六包固元镇定丹</a><br/>
    <a href="game?cmd=0d4b64bb5fdad2ba982162ee68f0db61cc6aaa8aff2a9c580a168ec63eaeabb629ebc7b00df06a91b64cd7889740ed2b">  六百八十颗三倍潜能丹(绑)</a><br/>
    <a href="game?cmd=61aeba84fb88608130bc5be0a0ef300ea852ca0c29b418c5a95b71c4cfaa0477bbc5a5db1a0a0e93a64cd4c689041baa">  十三颗双倍修为丹(绑)</a><br/>
    <a href="game?cmd=0d4b64bb5fdad2ba6b52099763c8af54acf85a7501a140826ed8d86301d489b7ba1a7a51dd7f56c3e53b01eeb6aed412">  三百三十颗三倍修为丹(绑)</a><br/><a href="game?cmd=1bfb9035707145d24f04ad8799b538cf2badb13651188635cece0cda0f5b8fefba1a7a51dd7f56c3e53b01eeb6aed412">  二十五块圣境令牌</a><br/><a href="game?cmd=0d4b64bb5fdad2ba982162ee68f0db613fac44bca2e78d5f5ea7ff92aa8b10dbba1a7a51dd7f56c3e53b01eeb6aed412">  五颗三倍潜能丹(绑)(限时)</a><br/>
    <a href="game?cmd=9facc219e74cbca6ec1228086188b7691ca11bab26fe3e2929ebc7b00df06a91b64cd7889740ed2b">□一个「破邪爪」</a><br/><a href="game?cmd=edcc6238ff5a72f879c0e8e0388533b2f510f09019be626abbc5a5db1a0a0e93a64cd4c689041baa">  二千七百一十八粒贯气通脉丹</a><br/><a href="game?cmd=61aeba84fb8860814bcdc0d9eee188d62896cf412e9c20661c8f665630096db37d7e754fa966fe14676689dad45f83d9">  一颗双倍潜能丹(绑)</a><br/>
    <a href="game?cmd=edcc6238ff5a72f8ff33cbffeed1bfb11486536e0f8ac809b9dcb1403ae6b37e140ede3dd9cdf83ea9907b9078e5a579">  三颗天元丹(绑)</a><br/><a href="game?cmd=0d4b64bb5fdad2ba6b52099763c8af54cf28c766e7d8429687b98c2092db508229ebc7b00df06a91b64cd7889740ed2b">  五颗三倍修为丹(绑)(限时)</a><br/><a href="game?cmd=1bfb9035707145d29f44598c58fae16718972a3fb0e4ebaa3b052ab176b42ba429ebc7b00df06a91b64cd7889740ed2b">  一块4级神兵精华（绑定）</a><br/>--%>
    <a href="<%=CommonUtil.getStandardUrl("function")%>">返回</a><br/>
    <a href="<%=CommonUtil.getStandardUrl("flashView")%>">返回游戏</a>
</font><br>
</body>
</html>

