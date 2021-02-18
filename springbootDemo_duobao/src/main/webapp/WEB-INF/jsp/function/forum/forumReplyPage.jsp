<%@ page import="com.jida.dto.ReplyPostPageDto" %>
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
        <%ReplyPostPageDto dto = (ReplyPostPageDto)request.getAttribute("replyPostPageDto");%>
        <form action="game" method="post">
            回复内容(200字以内):<br/>
            <textarea name="count" rows="10" cols="40">${count}</textarea>${tipReply}<br/>
            <input type="hidden" name="cmd" value="<%=CommonUtil.getStandardPostCmd("replyPost?postID="+dto.getPostID()+"&postPageNum="+dto.getPostPageNum()+"&postPageSize="+10)%>"/>
            <input type="submit" value="确定"/><br/>
            -----------------------------<br/>
            <a href="<%=CommonUtil.getStandardUrl("forumPostDetail?id="+dto.getPostID()+"&postPageNum="+dto.getPostPageNum()+"&postPageSize="+10+"&pageNum="+dto.getReplyPageNum()+"&pageSize="+10)%>">返回</a><br/>
            <a href="<%=CommonUtil.getStandardUrl("flashView")%>">返回游戏</a>
        </form>
    </font><br>
</body>
</html>

