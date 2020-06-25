<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>货物上新</title>
<script language="javascript">
 	function check(){
		var myReg=new RegExp("^[0-9]+(\.[0-9]{1,4})?$");
		var identityCard = /^(\d{15}|\d{18})$/;
		var agetest=/^(\d{1,3})$/;
		if(document.opform.G_num.value==""){
			alert("请输入商品数量！");
			return false;
		}
		if(document.opform.G_price.value==""){
			alert("请输入商品单价！");
			return false;
		}
		if(document.opform.G_sum.value==""){
			alert("请输入商品总额！");
			return false;
		}
	   document.all.regButton.disabled = true;
		 
	 	
	}
</script>
<script language = "JavaScript">
 
function changelocation()
    {
    document.opform.G_sum.value=document.opform.G_num.value*document.opform.G_price.value
    }
	
</script>
<link rel="stylesheet" href="css/menu.css" type="text/css" media="screen">
</head>
    <body>
		<div >
		<c:import url="logo.jsp" charEncoding="UTF-8"></c:import>
		</div>
      	 <div class="left">
			<c:import url="cgmenu.jsp" charEncoding="UTF-8"></c:import>
			</div>
			<div class="right" style="position:relative;top:60px;left:40px">
			 <form  name="opform" action="Goods" method="post"  onSubmit="javascript:return check();">
				<table>
					<tr>
						<td>商品名称</td>
						<td>
							<input type="text" name="G_name">
						</td>
					</tr>
					<tr>
						<td>商品单价</td>
						<td>
							<input type="text" name="G_price" onChange="changelocation( )">
						</td>
					</tr>
					<tr>
						<td>商品种类</td>
						<td>
							<input type="text" name="G_class">
						</td>
					</tr>
					<tr>
						<td>商品日期</td>
						<td>
							<input type="text" name="G_date">
						</td>
					</tr>
					<tr>
						<td>商品数量</td>
						<td>
							<input type="text" name="G_num" onChange="changelocation( )">
						</td>
					</tr>
					<tr>
						<td>商品总价</td>
						<td>
							<input type="text" name="G_sum"  onChange="changelocation( )" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td>采购商名</td>
						<td>
							<input type="text" name="Sup_name">
						</td>
					</tr>
					<tr>	
						<td>采购日期</td>
						<td>
							<input type="text" name="Sup_date">
						</td>
					</tr>
					<tr>
						<td>操作人</td>
						<td>
							<input type="text" name="G_on_name" readonly="readonly" value="<%=session.getAttribute("On_name") %>">
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="hidden" name="k" value="cggoodsAdddo">
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