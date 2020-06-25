<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>货物查询</title>
<script language="javascript">
 	function check(){
		var myReg=new RegExp("^[0-9]+(\.[0-9]{1,4})?$");
		var identityCard = /^(\d{15}|\d{18})$/;
		var agetest=/^(\d{1,3})$/;
		if(document.opform.Sale_num.value==""){
			alert("请输入商品数量！");
			return false;
		}
		if(document.opform.g_price.value==""){
			alert("请输入商品单价！");
			return false;
		}
		if(document.opform.Sale_sum.value==""){
			alert("请输入金额数量！");
			return false;
		}
	   document.all.regButton.disabled = true;
		 
	 	
	}
</script>
<script language = "JavaScript">
 
function changelocation()
    {
    document.opform.Sale_sum.value=document.opform.Sale_num.value*document.opform.g_price.value
    }
	
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
			<c:import url="xsmenu.jsp" charEncoding="UTF-8"></c:import>
			</div>
        <div class="right" style="position:relative;top:55px;left:40px">
        <form  name="opform" action="Sales" method="post"  onSubmit="javascript:return check();">
			<table>
			<tr>
				<td>商品编号</td>
				<td>商品名称</td>
				<td>商品数量</td>
				<td>商品价格</td>
				<td>商品总价</td>
				<td>操作</td>
			</tr>
		 	<c:forEach items="${list2 }" var="s">
			<tr>
				<td>
				<input type="text" id="g_id" value="${s.g_id }" name="g_id" readonly="readonly">
				</td>
				<td>
				<input type="text" id="g_name" value="${s.g_name}" name="g_name" readonly="readonly">
				</td>
				<td>
				<input type="text" id="Sale_num"  name="Sale_num" onChange="changelocation( )">
				</td>
				<td>
				<input type="text" id="g_price" value="${s.g_price}" name="g_price" onChange="changelocation( )">
				</td>
				<td>
				<input type="text" id="Sale_sum"  name="Sale_sum"   onChange="changelocation( )" readonly="readonly">
				</td>
				<td>
				<input type="hidden" name="k" value="xsaddsalesdo" >
							<input type="submit" value="添加销售车">
			
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