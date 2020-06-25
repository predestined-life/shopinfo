<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>供应商查询</title>
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
        <form   action="Suppier" method="post"  >
			<table>
			<tr>
				<td>供应编号</td>
				<td>供应公司</td>
				<td>供应商名</td>
				<td>供应商电话</td>
				<td>供应商地址</td>
				<td>操作</td>
				<td>操作</td>
			</tr>
		 	<c:forEach items="${list }" var="s">
			<tr>
				<td>
				${s.sup_id }
				</td>
				<td>
				${s.sup_name}
				</td>
				<td>
				${s.name }
				</td>
				<td>
				${s.tel }
				</td>
				<td>
				${s.address }
				</td>
				<td>
				<a href="Suppier?k=delsup&sup_id=${s.sup_id }">删除供应商</a>
				</td>
				<td>
				<a href="Suppier?k=xgsup&sup_id=${s.sup_id }">修改供应商</a>
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