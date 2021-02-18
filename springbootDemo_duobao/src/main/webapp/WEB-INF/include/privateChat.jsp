<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="com.jida.dto.ChatRecordDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jida.common.util.CommonUtil" %>
<%@ page import="com.jida.dto.SceneDto" %>
<%
    List<ChatRecordDTO> privateChatRecordDTOList = ((SceneDto) request.getAttribute("sceneDto")).getPrivateChatRecordDTOList();
%>
<%for (ChatRecordDTO item : privateChatRecordDTOList) { %>
==<%=CommonUtil.translateDate2(item.getCreateTime())%>==<br/><%=item.getSendPeopleName()%>对你说：<%=item.getMsg()%><a
        href="<%=CommonUtil.getStandardUrl("/sayToOtherPeopleReady?userId="+item.getSendUserId())%>">回复</a><br/>
<%}%>

