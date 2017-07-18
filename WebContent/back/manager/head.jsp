<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>" >
<link rel="stylesheet" type="text/css" href="back/manager/easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="back/manager/easyui-1.5.2/themes/icon.css">
<script type="text/javascript" src="back/manager/easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="back/manager/easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="back/manager/easyui-1.5.2/jquery.edatagrid.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">