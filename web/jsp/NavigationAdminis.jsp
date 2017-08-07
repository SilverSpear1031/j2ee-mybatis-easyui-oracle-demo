<%--
  Created by IntelliJ IDEA.
  User: rp599
  Date: 2017/8/1
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>数字框</title>
    <!-- 引入Jquery -->
    <script type="text/javascript" src="../../easyui/jquery.min.js" charset="utf-8"></script>
    <!-- 引入Jquery_easyui -->
    <script type="text/javascript" src="../../easyui/jquery.easyui.min.js" charset="utf-8"></script>
    <!-- 引入easyUi国际化--中文 -->
    <script type="text/javascript" src="../../easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
    <!-- 引入easyUi默认的CSS格式--蓝色 -->
    <link rel="stylesheet" type="text/css" href="../../easyui/themes/default/easyui.css"/>
    <!-- 引入easyUi小图标 -->
    <link rel="stylesheet" type="text/css" href="../../easyui/themes/icon.css"/>

    <script type="text/javascript">
        window.onload = function () {
            $('#centerTab').tabs({
                tools:'#tab-tools'
            });
        };

        function addTab(tabId, title, url) {
            //如果当前id的tab不存在则创建一个tab
            if ($("#" + tabId).html() == null) {
                var name = 'iframe_' + tabId;
                $('#centerTab').tabs('add', {
                    title: title,
                    closable: true,
                    cache: false,
                    //注：使用iframe即可防止同一个页面出现js和css冲突的问题
                    content: '<iframe name="' + name + '"id="' + tabId + '"src="' + url + '" width="100%" height="100%" frameborder="0" scrolling="auto" ></iframe>'
                });
            }
        }
    </script>
</head>
<body>
<body class="easyui-layout">
<!-- 正上方panel -->
<div region="north" style="height:80px;padding:1px;background-color: #0092DC">
    <h1 style="vertical-align: middle">物业管理系统</h1>
</div>
<!-- 正左边panel -->
<div region="west" title="管理员导航" split="true" style="width:280px;padding1:1px;overflow:hidden;">
    <div class="easyui-accordion" fit="true" border="false">
        <!-- selected -->
        <div title="物业账户管理">
            <ul>
                <li>
                    <a href="javascript:addTab('UserUpdate','个人账户管理','<c:url value='user/UserUpdate.jsp'/>');">个人账户管理</a>
                </li>
                <li>
                    <a href="javascript:addTab('AdminisAccount','业主账户管理','<c:url value='user/AdminisAccount.jsp'/>');">业主账户管理</a>
                </li>
            </ul>
        </div>
        <div title="物业信息管理">
            <ul>
                <li>
                    <a href="javascript:addTab('AdminisRoom','物业信息管理','<c:url value='room/AdminisRoom.jsp'/>');">物业信息管理</a>
                </li>
            </ul>
        </div>
        <div title="物业投诉管理" selected="true">
            <ul>
                <li>
                    <a href="javascript:addTab('AdminisCpl','物业投诉管理','<c:url value='cpl/AdminisCpl.jsp'/>');">物业投诉管理</a>
                </li>
                <li>
                    <a href="javascript:addTab('AdminisCplHistory','物业投诉历史记录','<c:url value='cpl/AdminisCplHistory.jsp'/>');">物业投诉历史记录</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<!-- 正中间panel -->
<div region="center" title="功能区">
    <div class="easyui-tabs" id="centerTab" fit="true" border="false">
        <div title="欢迎页" style="padding:20px;overflow:hidden;">
            <div style="margin-top:20px;" align="center">
                <h1 style="vertical-align: middle">欢迎来到物业管理系统</h1>
                <img class="pn-image " src="../images/NavigationTop.jpg" border="0"
                     style="vertical-align:middle;width:745px;height:154px"/>
            </div>
        </div>
        <div id="tab-tools" style="right: 0px;height: 26px">
        <a href="#" onclick="location='/User_Logout.servlet'" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cancel'" onclick="addTab()">退出</a>
        </div>
    </div>
</div>
</body>
</html>
