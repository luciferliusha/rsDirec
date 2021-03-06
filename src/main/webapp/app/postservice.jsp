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
	<%@include file="../common/taglibs.jsp"%>
	<%@include file="../common/meta.jsp"%>
	<%@include file="../common/js.jsp"%>
	<script type="text/javascript" src="<%= basePath %>js/app/query_report.js"></script>
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

        function    addservice(){

            var service_dept=$("#service_dept").val();
            var service_group=$("#service_group").val();
            var service_name=$("#service_name").val();
            var service_gettype=$("#service_gettype").val();
            var service_description=$("#service_description").val();

            //alert(data_gettype);
            var paraMap={};//存放查询数据的参数
            paraMap["service_dept"] = service_dept;
            paraMap["service_group"] = service_group;
            paraMap["service_name"] = service_name;
            paraMap["service_gettype"] = service_gettype;
            paraMap["service_description"] = service_description;

            $.ajax({
                type:"POST",   //http请求方式
                url:'datarsdir/addservice.do',
                async:false,
                data:JSON.stringify(paraMap), //发送给服务器的参数  ,JSON.stringify将json对象转换成json字符串，否则后台bean接收不到,报400,415错误
                //dataType:"json",  //告诉JQUERY返回的数据格式(注意此处数据格式一定要与提交的controller返回的数据格式一致,不然不会调用回调函数complete)
                contentType:'application/json;charset=UTF-8',
                success:function(result){
                    var s = result.data;
                    alert("发布服务成功");
                    window.location = rootPath+'/main.jsp';
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
            }else if(nav_id=="a_sjfwml"){//服务查询
                //opera_url='main/selectServices.do';
                redirecturl='/app/home.jsp';
            } else if(nav_id=="a_sjzyzc"){//资源注册
                //opera_url='main/signupData.do';
                redirecturl='/app/signupdata.jsp';
            } else if(nav_id=="a_sjfwfb"){//服务发布
                //opera_url='main/serviceFb_.do';
                redirecturl='/app/postservice.jsp';
            }

            //alert(redirecturl);
            window.location = rootPath+redirecturl;

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
		<li id="top_update_password">修改密码</li>
		<li id="top_user"></li>
	</ul>
</div>
<div style="text-align:center">
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
		<table id="dg" class="easyui-datagrid" title="数据资源概况" style="width:1000px;height:480px;" >
			<thead>
			<tr>
				<th data-options="field:'id',width:50,align:'center'">序号</th>
				<th data-options="field:'data_from_dept',width:200,align:'center'">数据来源单位名称</th>
				<th data-options="field:'data_from_system',width:200,align:'center'">数据来源业务系统名称</th>
				<th data-options="field:'data_etl_type',width:150,align:'center'">数据交换类型</th>
				<th data-options="field:'data_etl_type',width:100">数据交换频率</th>
				<th data-options="field:'data_tab_rows',width:150,align:'center'">表记录数（条）</th>
				<th data-options="field:'data_space_usage',width:150,align:'center'">占用磁盘空间（M）</th>
			</tr>
			</thead>
		</table>
	</div>

	<div id="w" class="easyui-window" title="数据服务发布" data-options="iconCls:'icon-save'" style="width:800px;height:500px;padding:5px;">
		<div class="easyui-layout" data-options="fit:true">
			<div style="margin-bottom:20px">
				<div>服务所属单位</div>
				<input id="service_dept" class="easyui-textbox" data-options="prompt:'Enter a email address...',validType:'email'" style="width:50%;height:32px">
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
				<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="$('#w').window('close')" style="width:80px">取消</a>
			</div>
		</div>
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
