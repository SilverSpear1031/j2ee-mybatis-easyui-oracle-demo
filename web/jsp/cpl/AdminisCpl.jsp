<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>数字框</title>
    <!-- 引入Jquery -->
    <script type="text/javascript" src="../../../easyui/jquery.min.js" charset="utf-8"></script>
    <!-- 引入Jquery_easyui -->
    <script type="text/javascript" src="../../../easyui/jquery.easyui.min.js" charset="utf-8"></script>
    <!-- 引入easyUi国际化--中文 -->
    <script type="text/javascript" src="../../../easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
    <!-- 引入easyUi默认的CSS格式--蓝色 -->
    <link rel="stylesheet" type="text/css" href="../../../easyui/themes/default/easyui.css"/>
    <!-- 引入easyUi小图标 -->
    <link rel="stylesheet" type="text/css" href="../../../easyui/themes/icon.css"/>

    <script type="text/javascript">
        var cpltype = [{ "value": "投诉", "text": "投诉" }, { "value": "报修", "text": "报修" }, { "value": "建议", "text": "建议" }, { "value": "其他", "text": "其他" }];
        function cpltypeformatter(value, rowData, rowIndex) {
            if (value == 0) {
                return;
            }
            for (var i = 0; i < cpltype.length; i++) {
                if (cpltype[i].value == value) {
                    return cpltype[i].text;
                }
            }
        }
        var cplsolve = [{ "value": "未解决", "text": "未解决" }, { "value": "已解决", "text": "已解决" }];
        function cplsolveformatter(value, rowData, rowIndex) {
            if (value == 0) {
                return;
            }
            for (var i = 0; i < cplsolve.length; i++) {
                if (cplsolve[i].value == value) {
                    return cplsolve[i].text;
                }
            }
        }
        $.extend($.fn.datagrid.defaults.editors, {
            datebox: {
                init: function (container, options) {
                    var input = $('<input type="text">').appendTo(container);
                    input.datebox(options);
                    return input;
                },
                destroy: function (target) {
                    $(target).datebox('destroy');
                },
                getValue: function (target) {
                    return $(target).datebox('getValue');//获得旧值
                },
                setValue: function (target, value) {
                    console.info(value);
                    $(target).datebox('setValue', value);//设置新值的日期格式
                },
                resize: function (target, width) {
                    $(target).datebox('resize', width);
                }
            }
        });
        $(function () {
            $.extend($.fn.validatebox.defaults.rules, {     //自定义验证
                mobile: {// 验证手机号码
                    validator: function (value) {
                        return /^(13|15|18|17)\d{9}$/i.test(value);
                    },
                    message: '手机号码格式不正确'
                },
                intOrFloat: {// 验证整数或小数
                    validator: function (value) {
                        return /^\d+(\.\d+)?$/i.test(value);
                    },
                    message: '请输入数字，并确保格式正确'
                },
                myfloat: {// 验证小数
                    validator: function (value) {
                        return /^\d+\.+\d$/i.test(value);
                    },
                    message: '请输入数字，并确保格式正确'
                },
                length: {
                    validator: function (value, param) {
                        var len = $.trim(value).length;
                        return len >= param[0] && len <= param[1];
                    },
                    message: "输入内容长度必须介于{0}和{1}之间."
                },
            });
            obj = {
                editrow: undefined,
                add: function () {
                    $('#save,#redo').show();    //显示保存和取消按钮
                    if (this.editrow == undefined) {
                        $('#mydatagrid').datagrid(  //在第一行进行添加
                            'insertRow', {index: 0, row: {},}
                        );
                    }
                    $('#mydatagrid').datagrid(  //将第一行设为可编辑状态
                        'beginEdit', 0
                    );
                    this.editrow = 0;
                },
                remove: function () {
                    var rows = $('#mydatagrid').datagrid('getSelections');       //返回选中的行，没有时返回空数组
                    if (rows.length > 0) {
                        $.messager.confirm('确认', '确定删除吗？', function (flag) {
                            if (flag) {   //点击了确定
                                var ids = [];
                                for (var i = 0; i < rows.length; i++) {
                                    ids.push(rows[i].cplid);        //用ids.jpis(',')设置用逗号隔开
                                }
                                $.ajax({
                                    type: 'POST',
                                    url: '/AdminisCpl_Delete.servlet',    //  访问handle
                                    data: {
                                        ids: ids.join(','),        //用ids.jpis(',')设置用逗号隔开,可直接用In查询
//                                        ids:ids,
                                    },
                                    beforeSend: function () {
                                        $('#mydatagrid').datagrid('loading');
                                    },
                                    success: function (data) {
                                        if (data) {
                                            $('#mydatagrid').datagrid('loaded');
                                            $('#mydatagrid').datagrid('load');      //自动刷新
                                            $('#mydatagrid').datagrid('unselectAll');
                                            $.messager.show({
                                                title: "提示",
                                                msg: data + "个数据被成功删除！",
                                            });
                                        }
                                    },
                                })
                            }
                        });
                    } else {
                        $.messager.alert('提示', '请选择要删除的记录！', 'info');
                    }
                },
                search: function () {
                    $('#mydatagrid').datagrid(
                        'load', {
                            cplHolderName: $('input[name="cplHolderName"]').val(),
                            cplType: $('input[name="cplType"]').val(),
                        }
                    );
                },
                edit: function () {
                    var rows = $('#mydatagrid').datagrid('getSelections');       //返回选中的行，没有时返回空数组
                    if (rows.length == 1) {     //选中一条时才可点击修改
                        if (this.editrow != undefined) {
                            $('#mydatagrid').datagrid('endEdit', this.editrow);      //选中第二条时得到第一条的索引
                        }
                        if (this.editrow == undefined) {       //选中第一条时把索引保留
                            var index = $('#mydatagrid').datagrid('getRowIndex', rows[0]);       //得到当前行的索引,此时rows只有一条，但他是对象
                            $('#save,#redo').show();
                            $('#mydatagrid').datagrid('beginEdit', index);

                            // 得到单元格对象,index指哪一行,field跟定义列的那个一样
                            var cellEdit = $('#mydatagrid').datagrid('getEditor', {index: index, field: 'cplid'});
                            var $input = cellEdit.target; // 得到文本框对象
                            //$input.val('aaa'); // 设值
                            $input.prop('readonly', true); // 设值只读

                            this.editrow = index;
                            $('#mydatagrid').datagrid('unselectRow', index);    //取消这一行的选中
                        }//双击开始编辑
                    } else {
                        $.messager.alert('提示', '修改必须且只能选择一行！', 'info');
                    }
                },
                save: function () {    //完成编辑自动触发下面的afterEdit
//                    $('#save,#redo').hide();
//                    this.editrow = false;
                    $('#mydatagrid').datagrid(  //将当前行设为结束编辑状态
                        'endEdit', this.editrow
                    );
                },
                redo: function () {
                    $('#save,#redo').hide();
                    this.editrow = undefined;
                    $('#mydatagrid').datagrid(  //调用回滚方法
                        'rejectChanges'
                    );
                },
            };

            $('#mydatagrid').datagrid({
                title: '物业投诉管理',
                iconCls: 'icon-ok',
                width: 1530,
                pageSize: 15,//给后台传rows
                pageList: [15, 20, 25, 30],//可以选择的分页集合
                nowrap: true,//设置为true，当数据长度超出列宽时将会自动截取
                striped: true,//设置为true将交替显示行背景。
                collapsible: false,//显示可折叠按钮
                toolbar: "#tb",//在添加 增添、删除、修改操作的按钮要用到这个
                url: '/AdminisCpl_List.servlet',//url调用Action方法
                loadMsg: '数据装载中......',
                singleSelect: false,//为true时只能选择单行
                fitColumns: true,//允许表格自动缩放，与列宽相对应
//                sortName: 'stuid',//给后台传sort
//                sortOrder: 'DESC',//给后台传order,可以是'asc'或者'desc'（正序或者倒序）。
                remoteSort: false,   //true即从后台拿排了序的数据
//                frozenColumns : [ [ {
//                    field : 'ck',
//                    checkbox : true
//                } ] ],
                pagination: true,//分页
                rownumbers: true,//显示行数
                onDblClickRow: function (rowIndex, rowData) {       //双击时得到index为下标,data为对应数据
                    if (obj.editrow != undefined) {
                        $('#mydatagrid').datagrid('endEdit', obj.editrow);      //选中第二条时得到第一条的索引
                    }
                    if (obj.editrow == undefined) {       //选中第一条时把索引保留
                        $('#save,#redo').show();
                        $('#mydatagrid').datagrid('beginEdit', rowIndex);
                        obj.editrow = rowIndex;

                        // 得到单元格对象,index指哪一行,field跟定义列的那个一样
                        var cellEdit = $('#mydatagrid').datagrid('getEditor', {index: rowIndex, field: 'cplid'});
                        var $input = cellEdit.target; // 得到文本框对象
                        //$input.val('aaa'); // 设值
                        $input.prop('readonly', true); // 设值只读
                    }//双击开始编辑
                },
                onAfterEdit: function (rowIndex, rowData, changes) {     //编辑完成后执行
                    $('#save,#redo').hide();

                    var inserted = $('#mydatagrid').datagrid('getChanges', 'inserted');    //得到编辑情况，得到新增数据，json数组形式
                    var updated = $('#mydatagrid').datagrid('getChanges', 'updated');     //得到修改数据
//                    alert(inserted[0].stuid);
                    if (inserted.length > 0) {      //新增
                        $.ajax({
                            type: 'POST',
                            url: '/AdminisCpl_Add.servlet',    //  访问handle
                            data: {
                                cplid: inserted[0].cplid,
                                cpltype: inserted[0].cpltype,
                                cplholderaccount: inserted[0].cplholderaccount,
                                cplholdername: inserted[0].cplholdername,
                                cplholderphonenumber: inserted[0].cplholderphonenumber,
                                cpltime: inserted[0].cpltime,
                                cplsolve: inserted[0].cplsolve,
                                cplcontent: inserted[0].cplcontent,
                                cplreply: inserted[0].cplreply,
                            },
                            beforeSend: function () {
                                $('#mydatagrid').datagrid('loading');
                            },
                            success: function (data) {
                                if (data) {
                                    $('#mydatagrid').datagrid('loaded');
                                    $('#mydatagrid').datagrid('load');      //自动刷新
                                    $('#mydatagrid').datagrid('unselectAll');
                                    $.messager.show({
                                        title: "提示",
                                        msg: data + "个数据被成功添加！",
                                    });
                                }
                            },
                        })
                    }
                    if (updated.length > 0) {
                        $.ajax({
                            type: 'POST',
                            url: '/AdminisCpl_Update.servlet',    //  访问handle
                            data: {
                                cplid: updated[0].cplid,
                                cpltype: updated[0].cpltype,
                                cplholderaccount: updated[0].cplholderaccount,
                                cplholdername: updated[0].cplholdername,
                                cplholderphonenumber: updated[0].cplholderphonenumber,
                                cpltime: updated[0].cpltime,
                                cplsolve: updated[0].cplsolve,
                                cplcontent: updated[0].cplcontent,
                                cplreply: updated[0].cplreply,
                            },
                            beforeSend: function () {
                                $('#mydatagrid').datagrid('loading');
                            },
                            success: function (data) {
                                if (data) {
                                    $('#mydatagrid').datagrid('loaded');
                                    $('#mydatagrid').datagrid('load');      //自动刷新
                                    $('#mydatagrid').datagrid('unselectAll');
                                    $.messager.show({
                                        title: "提示",
                                        msg: data + "个数据被成功修改！",
                                    });
                                }
                            },
                        })
                    }
                    obj.editrow = undefined;
                },
            });

        });

    </script>

</head>
<body>
<br/><br/><br/><br/><br/><br/>

<div align="center">
    <table id="mydatagrid">
        <thead>
        <tr>
            <th data-options="field:'cplid',width:70,align:'center',editor:{type:'validatebox',options:{required:true,validType:['length[6,30]'],},}">
                &nbsp;投诉ID
            </th>
            <th data-options="field:'cpltype',width:50,align:'center'">
                类型
            </th>
            <th data-options="field:'cplholderaccount',width:70,align:'center'">
                投诉人帐号
            </th>
            <th data-options="field:'cplholdername',width:80,align:'center'">
                投诉人
            </th>
            <th data-options="field:'cplholderphonenumber',width:80,align:'center'">
                联系方式
            </th>
            <th data-options="field:'cpltime',width:80,align:'center'">
                时间
            </th>
            <th data-options="field:'cplsolve',width:80,align:'center'">
                是否解决
            </th>
            <th data-options="field:'cplcontent',width:400,align:'center'">
                内容
            </th>
            <th data-options="field:'cplreply',width:370,align:'center',editor:{type:'validatebox',options:{required:false,validType:['length[1,80]'],},}">
                回复
            </th>
        </tr>
        </thead>
    </table>
</div>
<div id="tb">
    <div>
        <%--<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="obj.add();">增加</a>--%>
        <%--<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="obj.remove();">删除</a>--%>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="obj.edit();">回复</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" style="display: none" id="save"
           onclick="obj.save();">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" style="display: none" id="redo"
           onclick="obj.redo();">取消</a>
        <%--<a href="<c:url value='/Logout'/>" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" >退出</a>--%>
    </div>
    <div>
        投诉人<input type="text" name="cplHolderName"/>&nbsp;&nbsp;&nbsp;
        类型<input type="text" name="cplType"/>&nbsp;&nbsp;&nbsp;
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="obj.search();">查询</a>
    </div>
</div>

</body>
</html>


