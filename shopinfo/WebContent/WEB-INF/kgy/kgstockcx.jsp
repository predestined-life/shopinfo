<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>库存查询</title>
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
			<c:import url="kgmenu.jsp" charEncoding="UTF-8"></c:import>
			</div>
        <div class="right" style="position:relative;top:55px;left:40px">
	   <form action="Stock" method="post">
			<table>
			<tr>
				<td>库存编号</td>
				<td>仓库编号</td>
				<td>商品编号</td>
				<td>商品数量</td>
				<td>操作</td>
				<td>操作</td>
			</tr>
		 	<c:forEach items="${list }" var="s">
			<tr>
				<td>${s.stock_id }</td>
				<td>${s.store_id }</td>
				<td>${s.g_id }</td>
				<td>${s.stock_num }</td>
				<td>
				<a href="Stock?k=kgdeletestock&stock_id=${s.stock_id }">删除</a>
				</td>
				<td>
				<a href="Stock?k=kgupdatestock&stock_id=${s.stock_id }">修改</a>
				</td>
			</tr>
			</c:forEach>
			</table>
			</form>
	   </div>
</body>
</html>