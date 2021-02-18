<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page import="com.jida.common.util.CommonUtil" %>
<%@ include file="/WEB-INF/include/public.jsp"%>
<html>
<head>
    <title>夺宝江湖</title>
</head>
<body>
<%--<form action="http://dbwap.com:80/login/Login" method="post">--%>
<form action="<%=CommonUtil.getContextPath()+"/login"%>" method="post">
    <img src="<%=CommonUtil.getContextPath()%>/img/jianghu.jpg" alt="picture"/><br/>
   <%-- <img src="<%=CommonUtil.getContextPath()+"/img/584572s.jpg"%>" alt="picture"/><br/>--%>
    欢迎大家来到夺宝江湖游戏世界（作者龙吟天下）！<br>
    用户名：<input type="text" name="username" value="${username}"><br>
    <c:choose>
        <c:when test="${tip1!=null}">
            ${tip1}<br>
        </c:when>
        <c:otherwise>
            (6-16个大小写字母和数字)<br>
        </c:otherwise>
    </c:choose>
    密&nbsp;&nbsp;码：<input type="password" name="password"><br>
    <c:choose>
        <c:when test="${tip2!=null}">
            ${tip2}<br>
        </c:when>
        <c:otherwise>
            (6-16个大小写字母和数字)<br>
        </c:otherwise>
    </c:choose>
    <input type="submit" value="登录"><br><br>

    <a href="http://dbwap.com:80/login/ResetPwdPre">修改密码</a><br>
    <a href="<%=CommonUtil.getContextPath()+"/registerPage"%>">注册账号</a><br><br>
    <%--<a href="http://dbwap.com:80/zhanglogin/ZhangLoginPre">小虾米账号专用通道</a> <br>
    <a href="http://dbwap.com:80/zhanglogin2/ZhangLoginPre">有乐趣社区账号直接登录</a><br>
    <a href="http://129.28.135.8/shequ/myjsp/login.jsp">有乐趣社区入口</a><br>
    <a href="http://129.28.135.8/storm/duobao/game">心法区入口</a>--%>
</form>
</body>
</html>

