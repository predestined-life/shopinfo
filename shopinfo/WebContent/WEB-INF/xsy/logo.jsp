<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="logo">
	<p>欢迎<%=session.getAttribute("job") %>：<%=session.getAttribute("On_name") %></p>
		</div>
</body>
</html>