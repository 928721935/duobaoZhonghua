<%@ page import="com.jida.dto.SceneDto" %>
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
    <%--路人乙走了过来。<br/>不帅走了过来。<br/>--%>
    <%SceneDto sceneDto = (SceneDto)request.getAttribute("sceneDto");%>
    <%for (String item : sceneDto.getComeSceneTrackStr()){ %>
        <%=item%><br/>
    <%}%>
    <%@ include file="/WEB-INF/include/publicChat.jsp"%>
    <%-- 私聊即时信息--%>
    <%@ include file="/WEB-INF/include/privateChat.jsp"%>
    <%=sceneDto.getBattlePrivateMsg()%>
    <%=sceneDto.getPlace().getName()%><br/>
        <%if(sceneDto.getFunctionDtoListStr().length()>0){%>
          <%=sceneDto.getFunctionDtoListStr()%><br/>
        <%}%>
        <%if(sceneDto.getScenePeopleListStr().length()>0){%>
            <%=sceneDto.getScenePeopleListStr()%>
        <%}%>
    请选择你的行走方向<br/>
    <%=sceneDto.getSceneWalkInfo()%>
    <%=sceneDto.getPlace().getDescription()%><br/>
    <a href="<%=CommonUtil.getStandardUrl("/function")%>">状态/选项</a><br/>
    <a href="<%=CommonUtil.getStandardUrl("/flashView")%>">环顾四方</a><br>
    <a href="game?cmd=f7f74cdda511c17c">返回首页</a>
</font><br>
</body>
</html>

