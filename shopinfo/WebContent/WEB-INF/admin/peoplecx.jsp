<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工查询</title>
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
        <form action="People" method="post">
			<table>
			<tr>
				<td>员工编号</td>
				<td>员工姓名</td>
				<td>员工性别</td>
				<td>员工电话</td>
				<td>员工职位</td>
				<td>员工账号</td>
				<td>员工密码</td>
				<td>操作</td>
				<td>操作</td>
			</tr>
		 	<c:forEach items="${list }" var="s">
			<tr>
				<td>${s.people_id }</td>
				<td>${s.people_name }</td>
				<td>${s.people_sex }</td>
				<td>${s.people_tel }</td>
				<td>${s.people_job }</td>
				<td>${s.name }</td>
				<td>${s.pass }</td>
				<td>
				<a href="People?k=deletepeople&id=${s.people_id }">删除</a>
				</td>
				<td>
				<a href="People?k=updatepeople&id=${s.people_id }">修改</a>
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