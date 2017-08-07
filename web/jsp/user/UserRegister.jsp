<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<br><br><br>
<h1 align="center">欢迎注册物业管理系统</h1>
<form action="<c:url value='/User_Register.servlet'/>" method="post">
    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td>
                <table width="835" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td width="41" height="7" align="center">&nbsp;</td>
                        <td width="794" height="30" align="left" valign="top"><span class="text_blod_title">注册信息</span>
                        </td>
                    </tr>
                    <tr>
                        <td height="15" colspan="2" align="center"><img src="../../../images/line1.jpg" width="835"
                                                                        height="6"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="5%">&nbsp;</td>
                                    <td width="95%" align="left" class="text_cray">注：标有 <span class="text_red">*</span>
                                        处，均为必填项
                                    </td>
                                </tr>
                                <tr>
                                    <td height="15" colspan="2">&nbsp;</td>
                                </tr>

                            </table>
                            <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td height="30" colspan="4" align="left" class="text_red1"><span class="text_title">登录信息</span>
                                    </td>
                                </tr>

                                <tr>
                                    <td width="19" align="center" class="text_red">*</td>
                                    <td width="98" height="40" align="left" class="text_cray1">登录名：</td>
                                    <td width="160" align="left" class="text_cray1"><input name="userAccount"
                                                                                           type="text"
                                                                                           class="text_cray"/></td>
                                    <td width="423" height="35" align="left" class="text_cray">
                                        由字母、数字或“_”组成，长度不少于6位，不多于30位
                                    </td>
                                </tr>
                                <tr>
                                    <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                                    <td width="98" height="40" align="left" class="text_cray1">密码：</td>
                                    <td align="left" class="text_cray1"><input name="userPassword" type="password"
                                                                               class="text_cray"/></td>
                                    <td height="35" align="left" class="text_cray">不少于6位字符</td>
                                </tr>
                            </table>
                            <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td height="35" colspan="5" align="left" class="text_red1"><span class="text_title">个人信息</span>
                                    </td>
                                </tr>

                                <tr>
                                    <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                                    <td width="98" height="40" align="left" class="text_cray1">真实姓名：</td>
                                    <td height="35" colspan="3" align="left"><input name="userName" type="text"
                                                                                    class="text_cray"/></td>
                                </tr>
                                <tr>
                                    <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                                    <td width="98" height="40" align="left" class="text_cray1">性 别：</td>
                                    <td height="35" colspan="3" align="left" class="text_cray1">
                    <span class="mr25">
                    <input type="radio" name="userGender" value="male" checked="checked"/>
                    </span>
                                        <span class="text_cray">
                    <label>男</label>
                    <input type="radio" name="userGender" value="female"/>
                    <label>女</label>
                    </span>
                                        <label></label>
                                        <span><label></label>
                  </span></td>
                                </tr>
                                <tr>
                                    <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                                    <td width="98" height="40" align="left" class="text_cray1">证件类型：</td>
                                    <td height="35" colspan="3" align="left">
                                        <select class="text_cray" name="userIdCardType" id="cardType">
                                            <option value="二代身份证"><span>二代身份证</span></option>
                                            <option value="港澳通行证"><span>港澳通行证</span></option>
                                            <option value="台湾通行证"><span>台湾通行证</span></option>
                                            <option value="护照"><span>护照</span></option>
                                            <option value="其他"><span>其他</span></option>
                                        </select></td>
                                </tr>
                                <tr>
                                    <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                                    <td width="98" height="40" align="left" class="text_cray1">证件号码：</td>
                                    <td height="35" colspan="3" align="left"><input name="userIdCard" type="text"
                                                                                    class="text_cray"/></td>
                                </tr>
                                <tr>
                                    <td width="19" align="center" class="text_red1"></td>
                                    <td width="98" height="40" align="left" class="text_cray1">手机号码：</td>
                                    <td height="35" colspan="3" align="left"><input name="userPhoneNumber" type="text"
                                                                                    class="text_cray"/></td>
                                </tr>
                                <tr>
                                    <td width="19" align="center" class="text_red1"></td>
                                    <td width="98" height="40" align="left" class="text_cray1">电子邮箱：</td>
                                    <td height="35" colspan="3" align="left"><input name="userEmail" type="text"
                                                                                    class="text_cray"/></td>
                                </tr>
                            </table>
                            <br>
                            <table width="835" border="0" align="center" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td width="234">&nbsp;</td>
                                    <td width="147" height="30" align="center"><input name="button3" type="submit"
                                                                                      class="buttj" id="button3"
                                                                                      value="注&nbsp;册"></td>
                                    <td width="141" align="center">&nbsp;</td>
                                    <td width="147" align="center"><input name="button4"
                                                                          onclick="location='/User_Logout.servlet'"
                                                                          type="button" class="butcz" id="button4"
                                                                          value="退&nbsp;出"></td>
                                    <td width="166" align="center">&nbsp;</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <br>

    <table width="100%" border="0" cellspacing="0">
        <div style="margin-top:20px;" align="center">
            <img src="../../images/NavigationTop.jpg" style="width:745px;height:154px">
        </div>
    </table>
</form>
</body>
</html>
