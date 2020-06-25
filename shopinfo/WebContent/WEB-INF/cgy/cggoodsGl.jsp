<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>货物管理</title>
<link rel="stylesheet" href="css/menu.css" type="text/css" media="screen">
<style type="text/css">
	table{
		margin: 10px;
		border:1px solid black;
		border-collapse:collapse;
	}
	tr,td{
		border:1px solid black;
	}
</style>
</head>
<body>
		<div >
		<c:import url="logo.jsp" charEncoding="UTF-8"></c:import>
		</div>
        	<div class="left">
			<c:import url="cgmenu.jsp" charEncoding="UTF-8"></c:import>
			</div>
        <div class="right" style="position:relative;top:60px;left:40px">
        <form action="Goods" method="post">
			<table>
			<tr>
				<td>商品编号</td>
				<td>商品名称</td>
				<td>商品价格</td>
				<td>商品种类</td>
				<td>商品日期</td>
				<td>操作</td>
				<td>操作</td>
			</tr>
		 	<c:forEach items="${list }" var="s">
			<tr>
				<td>${s.g_id }</td>
				<td>${s.g_name }</td>
				<td>${s.g_price }</td>
				<td>${s.g_class }</td>
				<td>${s.g_date }</td>
				<td>
				<a href="Goods?k=cgdeletegoods&g_id=${s.g_id }">删除</a>
				</td>
				<td>
				<a href="Goods?k=cgupdategoods&g_id=${s.g_id }">修改</a>
				</td>
			</tr>
			</c:forEach>
			</table>
			</form>
		</div>
		<div >
	<c:import url="foot.jsp" charEncoding="UTF-8"></c:import>
		</div>
	
</body>
</html>