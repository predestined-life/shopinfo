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
        	<div class="left">
			<c:import url="menu.jsp" charEncoding="UTF-8"></c:import>
			</div>
        <div class="right" style="position:relative;top:60px;left:40px">
	   	<form action="Stock" method="post">
	   <table>
	   <c:forEach items="${list1 }" var="s">
	   	<tr>
	   		<td>库存编号</td>
	   		<td><input type="text" name="stock_id" value="${s.stock_id}" readonly="readonly"></td>
	   	</tr>
	   	<tr>
	   		<td>仓库编号</td>
	   		<td><input type="text" name="store_id" value="${s.store_id}" readonly="readonly"></td>
	   	</tr>
	   	<tr>
	   		<td>商品编号</td>
	   		<td><input type="text" name="g_id" value="${s.g_id}" readonly="readonly"></td>
	   	</tr>
	   	<tr>
	   		<td>库存数量</td>
	   		<td><input type="text" name="stock_num" value="${s.stock_num}"></td>
	   	</tr>
	   	</c:forEach>
	   	<tr>
	   		<td>
				<input type="hidden" name="k" value="stockUpdatedo">
				<input type="submit" value="修改">
			</td>
			</tr>
	   </table>
	   </form>
	   </div>
</body>
</html>