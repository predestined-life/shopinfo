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
	   	<form action="People" method="post">
	   <table>
	   <c:forEach items="${list1 }" var="s">
	   	<tr>
	   		<td>员工编号</td>
	   		<td><input type="text" name="people_id" value="${s.people_id}"></td>
	   	</tr>
	   	<tr>
	   		<td>员工姓名</td>
	   		<td><input type="text" name="people_name" value="${s.people_name}"></td>
	   	</tr>
	   	<tr>
	   		<td>员工性别</td>
	   		<td><input type="text" name="people_sex" value="${s.people_sex}"></td>
	   	</tr>
	   	<tr>
	   		<td>员工电话</td>
	   		<td><input type="text" name="people_tel" value="${s.people_tel}"></td>
	   	</tr>
	   	<tr>
	   		<td>员工职业</td>
	   		<td><input type="text" name="people_job" value="${s.people_job}"></td>
	   	</tr>
	   	<tr>
	   		<td>员工账号</td>
	   		<td><input type="text" name="name" value="${s.name}"></td>
	   	</tr>
	   	<tr>
	   		<td>员工密码</td>
	   		<td><input type="text" name="pass" value="${s.pass}"></td>
	   	</tr>
	   	</c:forEach>
	   	<tr>
	   		<td>
				<input type="hidden" name="k" value="peoplexgdo">
				<input type="submit" value="修改">
			</td>
			</tr>
	   </table>
	   </form>
	   </div>
</body>
</html>