<%@ page import="com.jida.common.util.CommonUtil" %>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="shortcut icon" href="<%=CommonUtil.getContextPath()%>/img/favicon.ico" type="image/x-icon"/>