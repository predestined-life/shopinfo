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
	   	<form action="Suppier" method="post">
	   <table>
	   <c:forEach items="${list1 }" var="s">
	   	<tr>
	   		<td>供应编号</td>
	   		<td><input type="text" name="sup_id" value="${s.sup_id}" readonly="readonly"></td>
	   	</tr>
	   	<tr>
	   		<td>供应公司</td>
	   		<td><input type="text" name="sup_name" value="${s.sup_name}"></td>
	   	</tr>
	   	<tr>
	   		<td>供应商名</td>
	   		<td><input type="text" name="name" value="${s.name}"></td>
	   	</tr>
	   	<tr>
	   		<td>供应商电话</td>
	   		<td><input type="text" name="tel" value="${s.tel}"></td>
	   	</tr>
	   	<tr>
	   		<td>供应商地址</td>
	   		<td><input type="text" name="add" value="${s.address}"></td>
	   	</tr>
	   	</c:forEach>
	   	<tr>
	   		<td>
				<input type="hidden" name="k" value="supxgdo">
				<input type="submit" value="修改">
			</td>
			</tr>
	   </table>
	   </form>
	   </div>
</body>
</html>