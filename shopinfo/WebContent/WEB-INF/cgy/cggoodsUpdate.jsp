<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>详细修改</title>
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
        	<div class="left" >
			<c:import url="cgmenu.jsp" charEncoding="UTF-8"></c:import>
			</div>
        <div class="right" >
	   	<form action="Goods" method="post">
	   <table>
	   <c:forEach items="${list1 }" var="s">
	   	<tr>
	   		<td>商品编号</td>
	   		<td><input type="text" name="g_id" value="${s.g_id}"></td>
	   	</tr>
	   	<tr>
	   		<td>商品名称</td>
	   		<td><input type="text" name="g_name" value="${s.g_name}"></td>
	   	</tr>
	   	<tr>
	   		<td>商品价格</td>
	   		<td><input type="text" name="g_price" value="${s.g_price}"></td>
	   	</tr>
	   	<tr>
	   		<td>商品种类</td>
	   		<td><input type="text" name="g_class" value="${s.g_class}"></td>
	   	</tr>
	   	<tr>
	   		<td>商品日期</td>
	   		<td><input type="text" name="g_date" value="${s.g_date}"></td>
	   	</tr>
	   	</c:forEach>
	   	<tr>
	   		<td>
				<input type="hidden" name="k" value="cggoodsUpdatedo">
				<input type="submit" value="修改">
			</td>
			</tr>
	   </table>
	   </form>
	   </div>
</body>
</html>