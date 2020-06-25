<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加库存</title>
<link rel="stylesheet" href="css/menu.css" type="text/css" media="screen">
</head>
    <body>
		<div >
		<c:import url="logo.jsp" charEncoding="UTF-8"></c:import>
		</div>
      	 <div class="left">
			<c:import url="kgmenu.jsp" charEncoding="UTF-8"></c:import>
			</div>
			<div class="right" style="position:relative;top:60px;left:40px">
			 <form  action="Stock" method="post"  >
				<table>
					<tr>
						<td>仓库编号</td>
						<td>
							<input type="text" name="Store_id" >
						</td>
					</tr>
					<tr>
						<td>商品编号</td>
						<td>
							<input type="text" name="G_id">
						</td>
					</tr>
					<tr>
						<td>库存数量</td>
						<td>
							<input type="text" name="Stock_num">
						</td>
					</tr>
					
					<tr>
						<td></td>
						<td>
							<input type="hidden" name="k" value="kgstockAdddo">
							<input type="submit" value="添加">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div >
		<c:import url="foot.jsp" charEncoding="UTF-8"></c:import>
		</div>
</body>
</html>