<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>新闻中国</title>

<base href="http://localhost:8080/news/">

<meta charset="utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords"	content="新闻" />
<meta http-equiv="description" content="Navy新闻网,为广大人民建立了网络新闻平台,方便用户随时、随地的了解世界的相关动态" />
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />

<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/login.css" />

<script src="js/jquery-1.9.1.js" charset="utf-8"></script>
<script src="js/login.js" charset="utf-8"></script>

</head>

<body>
	<div id="bg" class="bg" style="display:none;"></div>
	<div id="header">
    	<div id="top_login">
    		<div class="top_login_left">
					<ul>
						<li><a href="javascript:void(0);"
							onclick="SetHome(this,'http://www.baidu.com');">设为首页</a>
						</li>
						<li><a href="javascript:void(0);"
							onclick="AddFavorite('Navy新闻网',location.href)">点击收藏</a>
						</li>
						<li><a href="javascript:writerToLetter()" title="">联系我们</a>
						</li>
					</ul>
			</div>
    		<div id="top_login_right">
	    		<a href="javascript:showlogin()"><font color="#FF0000" size="2">请登录</font></a>
				&nbsp;&nbsp;
				<a href="javascript:showzc()"><font color="#FF0000" size="2">免费注册</font></a>
				&nbsp;&nbsp;
				<a href="javascript:location.href='back/login.html'"><font color="#FF0000" size="2">管理入口</font></a>
			</div>
        	
        <div id="nav">
        	<div id="logo"><img src="images/logo.jpg" /></div>
            <div><img src="images/a_b01.gif" style="margin:10px 0px 0px 2px;"/></div>
        </div>
       </div>
    </div>