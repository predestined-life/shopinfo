<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结果</title>
  <link rel="stylesheet" href="css/menu.css" type="text/css" media="screen">
</head>
    <body>
		<div >
		<c:import url="logo.jsp" charEncoding="UTF-8"></c:import>
		</div>
      	 <div class="left">
			<c:import url="xsmenu.jsp" charEncoding="UTF-8"></c:import>
			</div>
        <div class="right">
			<div class="right">
					 	${msg }
		</div>
		</div>
		<c:import url="foot.jsp" charEncoding="UTF-8"></c:import>
		</div>
</html>