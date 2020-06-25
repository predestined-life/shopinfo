<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售车</title>
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
			<c:import url="xsmenu.jsp" charEncoding="UTF-8"></c:import>
			</div>
        <div class="right" style="position:relative;top:55px;left:40px">
        <form action="Sales" method="post">
			<table>
			<tr>
				<td>商品订单号</td>
				<td>商品编号</td>
				<td>商品名称</td>
				<td>商品数量</td>
				<td>商品价格</td>
				<td>单项总价</td>
				<td>操作账号</td>
				<td>可进行操作</td>
			</tr>
		 	<c:forEach items="${list }" var="s">
			<tr>
				<td>
				${s.sale_id }
				</td>
				<td>
				${s.g_id }
				</td>
				<td>
				${s.g_name }
				</td>
				<td>
				${s.sale_num }
				</td>
				<td>
				${s.g_price }
				</td>
				<td>
				${s.sale_sum }
				</td>
				<td>
				${s.on_name }
				</td>
				<td>
				<a href="Sales?k=xsdelcargood&sale_id=${s.sale_id }">移出购物车</a>
				</td>
			</tr>
			</c:forEach>
			</table>
			<table>
			<tr>
			<td><input type="button" value="结算价格"  onclick="f1()"></input></td>
			<td><input type="hidden" name="k" value="xscleancar">
							<input type="submit" value="清空销售车"></td>
							<tr>
							</table>
			</form>
			
		</div>
		<div >
	<c:import url="foot.jsp" charEncoding="UTF-8"></c:import>
		</div>
	
</body>
</html>