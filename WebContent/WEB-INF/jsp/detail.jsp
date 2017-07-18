<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>

<center><b>${news.title }</b></center>
<center>作者：${news.auth }    创建时间：${news.ndate }    浏览量：${news.views }</center>
<p>${news.content }</p>
<center><a href="javascript:history.go(-1)">后退</a></center>

<%@ include file="../../footer.jsp" %>