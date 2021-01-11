<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
  <title>小说搜索</title>
  <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
  <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <style>
	.gw_nav{ height:60px; line-height:50px; font-size:18px; overflow:hidden; padding-top:20px;}.gw_nav a{ color:#61452c; margin:0 30px; font-weight:normal;}.gw_nav a:hover,.gw_nav a:active{ color:#e36c02;text-decoration:none;}
  </style>
</head>
<body>
<!-- 上半部分-->
	<div style="background-image:url('/bookpic/head.gif');height:200px">
		<div class="container" >
		   <div class="row" style="height:130px">
			  <!--标题连接 -->
			  <div class="col-xs-3"style="height:100px;padding-top:40px">
			  <a href="login.html"><img src="/bookpic/tou.png"></a>
			  </div>
			   <!--搜索 -->
			  <div class="col-xs-4 col-xs-offset-3"style="padding-top:50px;height:100px">
				<form action="${pageContext.request.contextPath}/bookquery.action" method="post"><!-- 添加一个下拉框-->
				<input type="text" style="line-height:30px;width:50px" value="关键字"readonly/>
				<input type="text" name="bookname"style="line-height:30px;width:200px" value="黄帝内经"/> 
				<button type="submit" >查找</button>
				</form>
			   </div>
			   <!-- 用户栏 -->
				<div class="col-xs-4" style="padding-top:50px;height:100px;width:180px">
					<c:if test="${user!=null}">
					当前用户：${user.name}<a href="${pageContext.request.contextPath}/logout.action">退出</a>
					<br>
					<a href="${pageContext.request.contextPath}/personal.action?id=${user.id}">个人信息</a>
					</c:if>
					<c:if test="${user==null}">
					<a href="${pageContext.request.contextPath }/login.action">登录</a>/
					<a href="${pageContext.request.contextPath }/changUser.action">注册</a>
					</c:if>
				</div>
		   </div>
		</div>
		 <!--分类栏 -->
		 <div class="container">
		 		<div class="row">
					<div class="col-xs-12 col-xs-offset-1">
						 <div class="nav nav-tabs">
							<div class="gw_nav">
							<a class="active" href="${pageContext.request.contextPath}/index.action">首页</a>
							<a href="${pageContext.request.contextPath }/booktypequery.action?bookflag=A">医学小说</a>
							<a href="${pageContext.request.contextPath }/booktypequery.action?bookflag=B">文学小说</a>
							<a href="${pageContext.request.contextPath }/booktypequery.action?bookflag=C">兵法著作</a>
							<a href="${pageContext.request.contextPath }/booktypequery.action?bookflag=D" >历史著作</a>
							<a href="${pageContext.request.contextPath }/booktypequery.action?bookflag=E" >诗词著作</a>
							<a href="${pageContext.request.contextPath }/booktypequery.action?bookflag=F">杂文小说</a>
							</div>
						 </div>
					</div>
				</div>
		 </div>
	</div>
	<!-- 中间部分-->
	<div style="background-image:url('/bookpic/mid.gif');height:10px">
	</div>
	<!-- 下面部分 -->
	<div style="background-image:url('/bookpic/back.gif');height:100%">
		<div class="container">
			<div class="row">
				<c:forEach items="${books}" var="book">
					<div class="col-sm-3"  >
						<div style="height:180px;width:100px;float:left">
							<img class="img-rounded" src="/bookpic/${book.bookpic}"style="height:180px;width:130px">
						</div>
						<div style="padding-left:150px;width:280px;height:180px;">
							<a href="${pageContext.request.contextPath }/getbook.action?flag=${book.bookflag}">
							<h5>${book.name}</h5></a>
							<p style="word-wrap:break-word;padding-top:60px">${book.introduce}</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>