<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="left" style="position:relative;top:55px;left:40px">
            <ul id="nav">
                <li><a href="Goods">回到首页</a></li>
                <li><a href="#" class="sub" tabindex="1">采购员</a>
                    <ul>
                        <li><a href="Goods?k=GoodsAdd">货物上新</a></li>
                        <li><a href="Goods?k=GoodsGl">货物修改</a></li>
                        <li><a href="Suppier?k=supcx">供应商查询</a></li>
                    </ul>
                </li>
                <li><a href="#" class="sub" tabindex="1">销售员</a>
                    <ul>
                        <li><a href="Sales?k=SalesCX">货物查询</a></li>
                        <li><a href="Sales?k=Salescar">销售车</a></li>
                    </ul>
                </li>
                <li><a href="#" class="sub" tabindex="1">库管员</a>
                	<ul>
                        <li><a href="Stock?k=stockadd">添加商品库存</a></li>
                        <li><a href="Stock?k=stockkc">仓库库存</a></li>
                    </ul>
                    </li>
                     <li><a href="#" class="sub" tabindex="1">管理员</a>
                	<ul>
                        <li><a href="People?k=selpeople">员工管理</a></li>
                    </ul>
                    </li>
                <li><a href="Zhuxiao?k=zx">注销</a></li>
                <li><a href="#">功能暂定</a></li>
            </ul>
        </div>
</body>
</html>
