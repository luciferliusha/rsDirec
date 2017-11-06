<%--suppress ALL --%>
<%--suppress ALL --%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.zjcds.xa.bean.UserInfoBean"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    UserInfoBean userinfo = (UserInfoBean)request.getSession().getAttribute("loginuserinfo");
    String uname ="" ;
    String gname ="" ;
    String ualias ="" ;
    if(userinfo!=null){
        uname = userinfo.getLogin_name();
        gname = userinfo.getGroupname();
        ualias = userinfo.getUsername();
        if(ualias==null){
            ualias = uname;
        }
    }else{

    }

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>HOME</title>
    <%@include file="common/taglibs.jsp"%>
    <%@include file="common/meta.jsp"%>
    <%@include file="common/js.jsp"%>
    <script type="text/javascript" src="<%= basePath %>js/app/query_report.js"></script>
    <script type="text/javascript" src="<%= basePath %>js/app/createmytree.js"></script>
    <link type="text/css" rel="stylesheet" href="<%= basePath %>themes/default/css/main.css"></link>
    <link type="text/css" rel="stylesheet" href="<%= basePath %>themes/default/css/home.css"></link>
    <script type="text/javascript">
        var ualias = '<%= ualias %>';

        $(document).ready(function(){
            $("#top_user").text(ualias);
            $("#top_quit").click(quitSystem);

            /**
             * 首页导航菜单事件
             */
            $("#a_sjzygk").click(nav_opera);
            $("#a_sjzyml").click(nav_opera);
            $("#a_sjfwml").click(nav_opera);
            $("#a_sjzyzc").click(nav_opera);
            $("#a_sjfwzc").click(nav_opera);
            $("#a_sjfwfb").click(nav_opera);


            // 根据用户控制页面权限
            if(ualias!="管理员"){
                $("#check_param").parent().hide();
                $("#check_cash").parent().hide();
            }

            querydatascan();

        });

        function    querydatascan(){

            var paraMap={};//存放查询数据的参数
            $.ajax({
                type:"POST",   //http请求方式
                url:'datarsdir/sjzygk.do',
                async:false,
                data:JSON.stringify(paraMap), //发送给服务器的参数  ,JSON.stringify将json对象转换成json字符串，否则后台bean接收不到,报400,415错误
                //dataType:"json",  //告诉JQUERY返回的数据格式(注意此处数据格式一定要与提交的controller返回的数据格式一致,不然不会调用回调函数complete)
                contentType:'application/json;charset=UTF-8',
                success:function(result){
                    var s = result.data;
                    //alert(s.toString());
                    $("#dg").datagrid('loadData',s);
                }//定义交互完成,并且服务器正确返回数据时调用回调函数
            });

        }

        function nav_opera(){
            var nav_id=$(this).attr("id");
            var opera_url;
            var redirecturl;//执行完后台操作要跳转的页面
            var paraMap={};//存放查询数据的参数
            paraMap["username"]="管理员"//;
            //alert(paraMap);
            if(nav_id=="a_sjzyml"){//资源目录查询
               //opera_url='main/selectDataTabs.do';
                redirecturl='/app/home.jsp';
                window.location = rootPath+redirecturl;
            }else if(nav_id=="a_sjfwml"){//服务查询
                //opera_url='main/selectServices.do';
                redirecturl='/app/servicehome.jsp';
                window.location = rootPath+redirecturl;
            } else if(nav_id=="a_sjzyzc"){//资源注册
                $('#data_dept').combobox({//给弹出框的下拉框组件绑定点击事件
                    onSelect:function(){
                        loadTableByDept();
                    }
                });
                $('#w1').window('open');

            } else if(nav_id=="a_sjfwfb"){//服务发布
                $('#w2').window('open');

            }

//            $.ajax({
//                type:"POST",   //http请求方式
//                url:opera_url,
//                async:false,
//                data:JSON.stringify(paraMap), //发送给服务器的参数  ,JSON.stringify将json对象转换成json字符串，否则后台bean接收不到,报400,415错误
//                //dataType:"json",  //告诉JQUERY返回的数据格式(注意此处数据格式一定要与提交的controller返回的数据格式一致,不然不会调用回调函数complete)
//                contentType:'application/json;charset=UTF-8',
//                complete:function(msg) {
//                    var vstatus=eval("(" + msg.responseText + ")").vstatus;
//                    var messages=eval("(" + msg.responseText + ")").messages;
//                    var returnstr;
//                    alert(vstatus);
//                    if (vstatus=='false'){
//                        //alert(messages);
//                    } else{
//                        window.location = rootPath+redirecturl;
//                    }
//                }//定义交互完成,并且服务器正确返回数据时调用回调函数
//            });

        }

        function quitSystem(){
            window.location = rootPath;
        }

    </script>
</head>

<body>
<div class="top">
    <div class="top-logo-title">数据资源目录查询系统</div>
    <ul class="top-ul">
        <li id="top_quit">退出</li>
        <li id="top_user"></li>
    </ul>
</div>
<div style="text-align:center">
    <div id="w1" class="easyui-window" title="数据资源注册" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:800px;height:500px;padding:10px;">
            <div class="easyui-layout" data-options="fit:true">
                <div style="margin-bottom:20px">
                    <div style="margin-bottom:20px">
                        <div>资源获取方式（数据库连接字符串（例如：jdbc:oracle:thin:@127.0.0.1:1521:dbname;username;password））</div>
                        <input id="data_gettype" class="easyui-textbox" style="width:50%;height:32px">
                    </div>
                    <div>资源所属单位</div>
                    <select id="data_dept" class="easyui-combobox"  name="dept" style="width:400px;">
                        <option value="000">交通厅</option><!-- 依据新疆运维文档0-1-2里面的编号规则-->
                        <option value="2">交通建设管理局</option>
                        <option value="1">公路管理局</option>
                        <option value="4">道路运输管理局</option>
                        <option value="3">路政管理局</option>
                        <option value="8">地方海事局</option>
                        <option value="6">厅农村公路处</option>
                        <option value="7">厅路网中心</option>
                    </select>
                </div>
                <div style="margin-bottom:20px">
                    <div>资源所属分类</div>
                    <input id="data_group" class="easyui-combotree" data-options="url:'<%= basePath %>json/zyssdw_tree.json',method:'get',label:'Select Node:',labelPosition:'top'" style="width:400px;">
                </div>

                <div style="margin-bottom:20px">
                    <div>资源名称</div>
                    <input  id="data_name" class="easyui-combotree" style="width:400px;">
                </div>


                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="javascript:adddata()" style="width:80px">提交</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="$('#w1').window('close')" style="width:80px">取消</a>
                </div>
            </div>
    </div>
    <div id="w2" class="easyui-window" title="数据服务发布" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:800px;height:500px;padding:10px;">
        <div class="easyui-layout" data-options="fit:true">
            <div style="margin-bottom:20px">
                <div>服务所属单位</div>
                <input id="service_dept" class="easyui-textbox"  style="width:50%;height:32px">
            </div>
            <div style="margin-bottom:20px">
                <div>服务所属分类</div>
                <input  id="service_group" class="easyui-textbox" style="width:50%;height:32px">
            </div>
            <div style="margin-bottom:20px">
                <div>服务名称</div>
                <input  id="service_name" class="easyui-textbox" style="width:50%;height:32px">
            </div>
            <div style="margin-bottom:20px">
                <div>服务接口</div>
                <input id="service_gettype" class="easyui-textbox" style="width:50%;height:32px">
            </div>
            <div style="margin-bottom:20px">
                <div>服务说明</div>
                <input id="service_description" class="easyui-textbox" style="width:50%;height:32px">
            </div>

            <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="javascript:addservice()" style="width:80px">提交</a>
                <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="$('#w2').window('close')" style="width:80px">取消</a>
            </div>
        </div>
    </div>
    <div>
        <nav role="full-horizontal" style="margin:50px 200px;">
            <ul>
                <li id="a_sjzyml"><a >数据资源目录</a></li>
                <li id="a_sjfwml"><a>数据服务目录</a></li>
                <li id="a_sjzyzc"><a >数据资源注册</a></li>
                <li id="a_sjfwfb"><a >数据服务发布</a></li>
            </ul>
        </nav>
    </div>
<div style="margin-left: 170px;margin-top: 20px;">
        <table id="dg" class="easyui-datagrid" title="数据资源概况" style="width:1010px;height:440px;" >
            <thead>
            <tr>

                <th data-options="field:'data_from_dept',width:200,align:'center'">数据来源单位名称</th>
                <th data-options="field:'data_from_system',width:200,align:'center'">数据来源业务系统名称</th>
                <th data-options="field:'data_etl_type',width:150,align:'center'">数据交换类型</th>
                <th data-options="field:'data_etl_freq',width:100">数据交换频率</th>
                <th data-options="field:'data_tab_rows',width:150,align:'center'">表记录数（条）</th>
                <th data-options="field:'data_space_usage',width:150,align:'center'">占用磁盘空间（M）</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<div class="copyright">
		<span>
			<a id="xjjtt" >新疆维吾尔族自治区  交通厅 版权所有</a> |
			<a id="zjcds">浙江协同数据系统有限公司 技术支持</a>
		</span>
</div>
</body>
</html>
