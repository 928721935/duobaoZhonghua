<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="com.jida.dto.ChatRecordDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jida.common.util.CommonUtil" %>
<%@ page import="com.jida.dto.SceneDto" %>
<%
    List<ChatRecordDTO> publicChatRecordDTOList = ((SceneDto) request.getAttribute("sceneDto")).getPublicChatRecordDTOList();%>
<%for (ChatRecordDTO item : publicChatRecordDTOList) { %>
<a href="<%=CommonUtil.getStandardUrl("/chatChannel")%>">
    <聊天频道>
</a>(<%=CommonUtil.translateDate1(item.getCreateTime())%>)<a href="<%=CommonUtil.getStandardUrl("/getOtherPeopleInfo?userId=" + item.getSendUserId())%>"><%=item.getSendPeopleName()%></a>对大家说：<%=item.getMsg()%>
<br/>
<%}%>

