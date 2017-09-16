<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>TOC</title>
	<%@include file="../common/taglibs.jsp"%>
	<%@include file="../common/meta.jsp"%>
	<%@include file="../common/js.jsp"%>
	<link rel="stylesheet" type="text/css" href="<%= basePath %>themes/default/css/query_report.css"/>
	<script type="text/javascript" src="<%= basePath %>js/app/query_report.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			createInitComponents();
		});
	</script>
  </head>
  
  <body>
	<div class="bar-query">
		<label>路段名称</label>
		<select id="roadlist"></select>
		<label>年份：</label>
		<select id="years"></select>
		<span class="bar-checkbox">
			<input type="checkbox" id="checkbox_all"/>全部
			<input type="checkbox" id="checkbox_nochecked"/>未审核
			<input type="checkbox" id="checkbox_nopass"/>审核未通过
			<input type="checkbox" id="checkbox_pass"/>审核通过
		</span>
		<input type="button" id="searchBtn" class="login-button" value="查询"/>
		<input type="button" id="export_excel" class="login-button" value="导出成Excel表格"/>
	</div>
	<div>
		<div class="content-unit">单位：万元	</div>
		<table id="tt"></table>
	</div>
  </body>
</html>
