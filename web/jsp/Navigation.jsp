<%--
  Created by IntelliJ IDEA.
  User: rp599
  Date: 2017/8/1
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">普通用户选项</h1>
<div align="center">
    <input type=button onclick="location='user/UserLogin.jsp'" value="登&nbsp;录"/>
    <input type=button onclick="location='user/UserRegister.jsp'" value="注&nbsp;册"/>
    <input type=button onclick="location='user/UserUpdate.jsp'" value="修改个人信息"/>
</div>

<br><br><br><br><br><br><br><br><br><br>
<h1 align="center">管理员选项</h1>
<div align="center">
    <input type=button onclick="location='user/UserLogin.jsp'" value="登&nbsp;录"/>
    <input type=button onclick="location='user/UserRegister.jsp'" value="注&nbsp;册"/>
    <input type=button onclick="location='user/AdminisAccount.jsp'" value="修改个人信息"/>
    <input type=button onclick="location='room/AdminisRoom.jsp'" value="修改物业信息"/>
</div>
</body>
</html>
