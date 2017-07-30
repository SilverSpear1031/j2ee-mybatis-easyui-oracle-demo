<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015-11-10
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<br><br><br><br><br><br><br><br><br><br>
<h1 align="center">登&nbsp;录</h1>
<h4 align="center" style="color:red">${info}</h4>

<form action="<c:url value='/Login.servlet'/>" method="post">
    <div align="center">
        用户名：<input type="text" name="userAccount" value="${userAccount}"/><br>
        密&nbsp;码：<input type="password" name="userPassword" /><br><br>
        <input type="submit" value="登&nbsp;录"/>&nbsp;&nbsp;&nbsp;&nbsp;
        <%--<a href="http://localhost:8080/Register.jsp" type="button">注&nbsp;册"</a>--%>
        <input type=button onclick="location='http://localhost:8080/Register.jsp'" value="注&nbsp;册">
        <br><br>
        <input type="checkbox" name="autoLogin" value="autoLogin"/>自动登录
    </div>
</form>
</body>
</html>
