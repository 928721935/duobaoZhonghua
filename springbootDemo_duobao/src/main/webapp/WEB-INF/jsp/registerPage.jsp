<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/include/public.jsp"%>
<html>
<head>
    <title>夺宝江湖</title>
    <base href="<%=basePath%>">
    <script type="text/javascript">
        function changeValidateCode(obj) {
            var timenow = new Date().getTime();
            obj.src="<%=CommonUtil.getContextPath()+"/getVerifiyCode?d="+Math.random()%>";
        }
    </script>
</head>
<body>
<form action="<%=CommonUtil.getContextPath()+"/register"%>" method="post">
    用户名：<input type="text" name="username" value="${username}">${tip1}<br>
    (6-16个大小写字母和数字)<br>
    密&nbsp;&nbsp;码：<input type="password" name="password" value="${password}">${tip2}<br>
    (6-16个大小写字母和数字)<br>
    重复密码：<input type="password" name="password2" value="${password2}">${tip3}<br>
    (6-16个大小写字母和数字)<br>
<%--    验证码:<input name="code" type="text" /><img id="imgObj" alt="验证码" src="http://dbwap.com:80//verification/code" onclick="changeValidateCode(this)"/><br>--%>
    验证码:<input name="code" type="text" />
    <img id="imgObj" alt="验证码" src="<%=CommonUtil.getContextPath()+"/getVerifiyCode"%>"
                                              onclick="this.src='<%=CommonUtil.getContextPath()%>/getVerifiyCode?d='+Math.random();"
/>${tip4}<br>
    <input type="submit" value="确定"><br>
    请牢记您所输入的用户名和密码，并且密码尽量既包含字母也包含数字，防止他人盗用您的用户名。<br>
</form>
</body>
</html>

