<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售车</title>
<script language = "JavaScript">
 

	
</script>
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
        <c:forEach items="${list }" var="s">
        <form action="Sales" method="post">
			<table class="car" id="salecar">
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
				 <input type="text" name="sum" value="${s.sale_sum }"readonly="readonly">
				</td>
				<td>
				${s.on_name }
				</td>
				<td>
				<a href="Sales?k=delcargood&sale_id=${s.sale_id }">移出购物车</a>
				</td>
			</tr>
			
			</table>
			<table>
			<tr>
			<td><input type="hidden" name="k" value="cleancar">
							<input type="submit" value="清空销售车"></td>
							<tr>
							</table>
			</form>
			</c:forEach>
		</div>
		<div >
	<c:import url="foot.jsp" charEncoding="UTF-8"></c:import>
		</div>
	
</body>
</html>