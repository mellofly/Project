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
							<a class="active" href="${pageContext.request.contextPath}/index.action">首页</a><a href="#">文学小说</a><a href="#">历史著作</a><a href="#">人文知识</a><a href="#" >兵法著作</a><a href="#" >医学著作</a><a href="#">古典小说</a><a href="#">杂学</a>
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
			<div class="row" >
				<div class="col-md-1"></div>
				<div>
					<!-- Right -->
					<div class="col-md-3" >
						<!-- 个人信息 -->
						<div class="row" style="padding-top: 10px">
							<div class="col-md-4">
								<img src="/bookpic/${users.picture }" width="54px" height="54px">
							</div>
							<div class="col-md-8">
								<a href="${pageContext.request.contextPath}/personal.action?id=${users.id}"><div style="color: blue">${users.name }</div></a>
							</div>
							<c:if test="${isfriend==0&&users.name!=user.name}">
								<form action="${pageContext.request.contextPath}/addfriend.action" method="post">
									<input type="text" name="id"style="display:none" value="${users.id }"/>
									<input type="text" name="applyname"style="display:none" value="${user.name }"/> 
									<button type="submit" >关注</button>
								</form>
							</c:if>
							<c:if test="${isfriend==1||users.name==user.name }">
								<c:if test="${users.name!=user.name}">
									<form action="${pageContext.request.contextPath}/addfriend.action" method="post">
										<input type="text" name="id"style="display:none" value="${users.id }"/>
										<input type="text" name="applyname"style="display:none" value="${user.name }"/> 
										<button type="submit" disabled="disabled">已关注</button>
									</form>
								</c:if>
							</c:if>
							<br/>
						</div>
						<hr style="border:2px #79BDD1 solid;">
						<!-- 导航栏 -->
						<div class="row">
							<div class="nav nav-tabs">
								<ul class="list-unstyled">
									<li><a style="padding-left: 12px" href="#biji" data-toggle="tab">读书笔记</a></li>
									<hr style="border-top: 1px dotted #79BDD1;height: 1px;   border-bottom-style: none;">
									<li><a style="padding-left: 12px" href="#pinglun" data-toggle="tab">我的评论</a></li>
									<hr style="border-top: 1px dotted #79BDD1;height: 1px;   border-bottom-style: none;">
									<li><a style="padding-left: 12px" href="#guanzhu" data-toggle="tab">我的关注</a></li>
									<hr style="border-top: 1px dotted #79BDD1;height: 1px;   border-bottom-style: none;">
									<li><a style="padding-left: 12px" href="#shoucang" data-toggle="tab">我的收藏</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- Left -->
					<div class="col-md-6" >
						<div class="tab-content">
							<div class="tab-pane fade" id="biji">
								<p>笔记</p>
								<c:forEach items="${notes}" var="note">
									<div style="background-color:white">
										<p>${note.message}</p>
										<p>${note.time }</p>
									</div>
								</c:forEach>
							</div>
							<div class="tab-pane fade" id="pinglun">
							<p>评论</p>
							<c:forEach items="${comment}" var="comment">
									<div style="background-color:white">
										<p>${comment.message}</p>
										<p>${comment.time }</p>
									</div>
								</c:forEach>
							</div>
							<div class="tab-pane fade" id="guanzhu">
							<p>关注</p>
							<c:forEach	items="${friends}" var="friend">
									<div style="background-color:white">
									<a href="${pageContext.request.contextPath}/personal.action?id=${friend.id}">${friend.name }</a>
									</div>
							</c:forEach>
							</div>
							<div class="tab-pane fade" id="shoucang">
							<p>收藏</p>
							<c:forEach	items="${collectionsList}" var="collections">
									<div style="background-color:white">
									<p>${collections.book_name }</p>
									<a href="${pageContext.request.contextPath }/bookvalue.action?flag=${collections.chapter_flag}"><p>${collections.personalityname }</p></a>
									</div>
							</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>