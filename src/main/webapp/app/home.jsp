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
      <script type="text/javascript" src="<%= basePath %>js/app/tree.js"></script>
	<link type="text/css" rel="stylesheet" href="<%= basePath %>themes/default/css/home.css"></link>
	<script type="text/javascript">
		var ualias = '<%= ualias %>';
	
		$(document).ready(function(){
			$("#top_user").text(ualias);
			$("#top_quit").click(quitSystem);

            tree_leaf_opera('kyzkybxsj','yes');

		    // 根据用户控制页面权限
		    if(ualias!="管理员"){
		    	$("#check_param").parent().hide();
		    	$("#check_cash").parent().hide();
		    }
		});

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
    <div class="content">
        <div class="content-left-toc">
            <div class="easyui-tabs"   style="height:565px;" >
                <div title="数据资源目录">
                            <ul id="sjzy_tree" class="easyui-tree">
                                <li>
                                    <span>交通宏观数据</span>
                                    <ul>
                                        <li>
                                            <a id="zlghsj" >战略规划</a>
                                        </li>
                                        <li>
                                            <a id="ndjhsj" >年度计划</a>
                                        </li>
                                        <li>
                                            <a id="tjfxsj">统计分析</a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <span>交通基础数据</span>
                                    <ul>
                                        <li>
                                            <span>业户</span>
                                            <ul>
                                                <li><a id="jtysyhsj">交通运输业户</a></li>
                                                <li>   <a id=jdcwxjcyhsj">机动车维修/检测业户</a></li>
                                                <li>  <a id="jdcjsypxyhsj">机动车驾驶员培训业户</a></li>
                                                <li>  <a id="slysyhsj">水路运输业户</a></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <span>道路（水路）</span>
                                            <ul>
                                                <li> <a id="gljcssxxsj">公路基础设施信息</a></li>
                                                <li>  <a id="kjdlxxsj">空间地理信息</a></li>
                                                <li> <a id="gkjcssxxsj">港口基础设施信息</a></li>
                                                <li> <a id="hdjcssxxsj">航道基础设施信息</a></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <span>车辆（船舶）</span>
                                            <ul>
                                                <li> <a id="yyclsj" onclick="tree_leaf_opera('yyclsj','yes')">营运车辆</a></li>
                                                <li> <a id="cbxxsj">船舶信息</a></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <span>从业人员（船员）</span>
                                            <ul>
                                                <li ><a id="jtyscyrysj">交通运输从业人员</a></li>
                                                <li ><a id="cyxxsj">船员信息</a></li>
                                                <li ><a id="hyzcsj">货运站（场）</a></li>
                                                <li ><a id="kyzkybxsj" onclick="tree_leaf_opera('kyzkybxsj','yes')">客运站及客运班线</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <span>交通业务</span>
                                    <ul>
                                        <li>
                                            <span>工程建设</span>
                                            <ul>
                                                <li><a id="glgcjsxmsj">公路工程建设项目</a></li>
                                                <li><a id="jtgczljdsj">交通工程质量监督</a></li>
                                                <li><a id="jtgczjsj">交通工程造价</a></li>
                                                <li><a id="sygcjsxmsj">水运工程建设项目</a></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <span>养护</span>
                                            <ul >
                                                <li><a id="glyhxxsj">公路养护信息</a></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <span>交通管理</span>
                                            <ul >
                                                <li><a id="xzxksj">行政许可</a></li>
                                                <li><a id="yjxxsj">应急信息</a></li>
                                                <li><a id="gkjyfwglsj">港口经营和服务管理</a></li>
                                                <li><a id="czwxhwxxsj">船载危险货物信息</a></li>
                                                <li><a id="glcltxfsj">公路车辆通行费</a></li>
                                                <li><a id="gllzxxsj">公路路政信息</a></li>
                                            </ul>
                                        </li>
                                        <li >
                                            <span>交通运输</span>
                                            <ul >
                                                <li><a id="gljtlxxsj">公路交通量信息</a></li>
                                                <li><a id="glcxczsj">公路超限超载</a></li>
                                                <li><a id="thxxsj">通航信息</a></li>
                                                <li><a id="cbwrsj">船舶防污染</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <span>交通政务</span>
                                    <ul>
                                        <li><a id="jtkjsj">交通科技</a></li>
                                        <li><a id="jypxsj">教育培训</a></li>
                                        <li><a id="zcfgsj">政策法规</a></li>
                                        <li><a id="gzxxsj">港政信息</a></li>
                                        <li><a id="hzxxsj">航政信息</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <span>公众数据</span>
                                    <ul>
                                        <li><a id="gzxxfwsj">公众信息服务</a></li>
                                    </ul>
                                </li>
                            </ul>
                </div>
                <div title="数据服务目录"  style="height:565px;">
                            <ul id="sjfw_tree" class="easyui-tree">
                                <li>
                                    <span>交通宏观数据服务</span>
                                    <ul>
                                        <li>
                                            <a >战略规划</a>
                                        </li>
                                        <li>
                                            <a >年度计划</a>
                                        </li>
                                        <li>
                                            <a >统计分析</a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <span>交通基础数据服务</span>
                                    <ul>
                                        <li>
                                            <span>业户</span>
                                            <ul>
                                                <li><a id="jtysyh">交通运输业户</a></li>
                                                <li>   <a id=jdcwxjcyh">机动车维修/检测业户</a></li>
                                                <li>  <a id="jdcjsypxyh">机动车驾驶员培训业户</a></li>
                                                <li>  <a id="slysyh">水路运输业户</a></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <span>道路（水路）</span>
                                            <ul>
                                                <li> <a id="gljcssxx">公路基础设施信息</a></li>
                                                <li>  <a id="kjdlxx">空间地理信息</a></li>
                                                <li> <a id="gkjcssxx">港口基础设施信息</a></li>
                                                <li> <a id="hdjcssxx">航道基础设施信息</a></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <span>车辆（船舶）</span>
                                            <ul>
                                                <li> <a id="yycl">营运车辆</a></li>
                                                <li> <a id="cbxx">船舶信息</a></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <span>从业人员（船员）</span>
                                            <ul>
                                                <li ><a id="jtyscyry">交通运输从业人员</a></li>
                                                <li ><a id="cyxx">船员信息</a></li>
                                                <li ><a id="hyzc">货运站（场）</a></li>
                                                <li ><a id="kyzkybx" onclick="tree_leaf_opera('kyzkybx','no')">客运站及客运班线</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <span>交通业务数据服务</span>
                                    <ul>
                                        <li>
                                            <span>工程建设</span>
                                            <ul>
                                                <li><a id="glgcjsxm">公路工程建设项目</a></li>
                                                <li><a id="jtgczljd">交通工程质量监督</a></li>
                                                <li><a id="jtgczj">交通工程造价</a></li>
                                                <li><a id="sygcjsxm">水运工程建设项目</a></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <span>养护</span>
                                            <ul >
                                                <li><a id="glyhxx">公路养护信息</a></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <span>交通管理</span>
                                            <ul >
                                                <li><a id="xzxk">行政许可</a></li>
                                                <li><a id="yjxx">应急信息</a></li>
                                                <li><a id="gkjyfwgl">港口经营和服务管理</a></li>
                                                <li><a id="czwxhwxx">船载危险货物信息</a></li>
                                                <li><a id="glcltxf">公路车辆通行费</a></li>
                                                <li><a id="gllzxx">公路路政信息</a></li>
                                            </ul>
                                        </li>
                                        <li >
                                            <span>交通运输</span>
                                            <ul >
                                                <li><a id="gljtlxx">公路交通量信息</a></li>
                                                <li><a id="glcxcz">公路超限超载</a></li>
                                                <li><a id="thxx">通航信息</a></li>
                                                <li><a id="cbwr">船舶防污染</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <span>交通政务数据服务</span>
                                    <ul>
                                        <li><a id="jtkj">交通科技</a></li>
                                        <li><a id="jypx">教育培训</a></li>
                                        <li><a id="zcfg">政策法规</a></li>
                                        <li><a id="gzxx">港政信息</a></li>
                                        <li><a id="hzxx">航政信息</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <span>公众数据服务</span>
                                    <ul>
                                        <li><a id="gzxxfw">公众信息服务</a></li>
                                    </ul>
                                </li>
                            </ul>
                </div>
            </div>
        </div>
		<div class="content-right-panel">
            <div>

            </div>
            <table id="dg" ></table>
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
