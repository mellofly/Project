<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
  <title>古典小说文学网</title>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
	.gw_nav{ height:60px; line-height:50px; font-size:18px; overflow:hidden; padding-top:20px;}.gw_nav a{ color:#61452c; margin:0 30px; font-weight:normal;}.gw_nav a:hover,.gw_nav a:active{ color:#e36c02;text-decoration:none;}
  </style>
 </head>
 <body >
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
				<input type="text" name="bookname"style="line-height:30px;width:200px" placeholder="黄帝内经"/> 
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
					<a href="${pageContext.request.contextPath }/login.action">登录</a>-----
					<a href="${pageContext.request.contextPath }/setUser.action">注册</a>
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
							<a class="active" href="#home" data-toggle="tab">首页</a><a href="#yixue" data-toggle="tab">医学小说</a><a href="#wenxue" data-toggle="tab">文学小说</a><a href="#bingfa" data-toggle="tab">兵法著作</a><a href="#lishi" data-toggle="tab">历史著作</a><a href="#shici" data-toggle="tab">诗词著作</a><a href="#zawen" data-toggle="tab">杂文小说</a>
							</div>
						 </div>
					</div>
				</div>
		 </div>
	</div>
	<!-- 中间部分-->
	<div style="background-image:url('/bookpic/mid.gif');height:10px">
	</div>
	<!-- 下面部分-->
	<div style="background-image:url('/bookpic/back.gif');height:100%">
		<!--选项卡部分 -->
		<div class="tab-content">
			<div class="tab-pane fade in active" id="home">
			<!--首页部分-->
				<div class="container">
					<div class="row" style="padding-left:8%">
						<div class="col-sm-12" style="height:50px">
							<em style="font-size:40px;color:red">热门小说</em>
						</div>
						<c:forEach items="${books}" var="book">
							<div class="col-sm-2">
								<div class="thumbnail">
									<img src="/bookpic/${book.bookpic}"style="height:180px;width:130px">
									<div class="caption">
										<a href="${pageContext.request.contextPath }/getbook.action?flag=${book.bookflag}">
											<p>${book.name}</p>
										</a>
									</div>
								</div>
							</div>
						</c:forEach>
						<!-- 排行榜 -->
						<div class="col-sm-12" style="height:40px">
							<div class="col-md-6">
							<em style="font-size:30px">热门小说排行榜</em></div>
							<div class="col-md-6">
							<em style="font-size:30px">热门用户排行榜</em></div>
						</div>
						<div class="col-md-6">
							<ol style="font-size:20px">
								<c:forEach items="${booksort}" var="booksort">
									<li>
										<a style="letter-spacing:15px;line-height:20px;font-size:20px;color:black"
										href="${pageContext.request.contextPath }/getbook.action?flag=${booksort.bookflag}">${booksort.book_name}</a>
									</li>
								</c:forEach>
							</ol>
						</div>
						<div class="col-md-6 ">
							<ol style="font-size:20px">
								<c:forEach items="${usersort}" var="user">
									<li>
										<a style="letter-spacing:15px;line-height:20px;font-size:20px;color:black"
										href="${pageContext.request.contextPath}/personal.action?id=${user.id}">${user.name}</a>
									</li>
								</c:forEach>
							</ol>
						</div>
					</div>
				</div>
			</div>
			<div class="tab-pane fade" id="yixue">
			<!-- 医学部分 -->
				<div class="container">
					<div class="row" style="padding-left:8%">
						<div class="col-sm-12" style="height:50px">
							<em style="font-size:40px">医学小说</em>
							<a href="${pageContext.request.contextPath }/booktypequery.action?bookflag=A" style="float:right;padding-top:20px">更多</a>
						</div>
						<c:forEach items="${booka}" var="book">
							<div class="col-sm-2">
								<div class="thumbnail">
									<img src="/bookpic/${book.bookpic}"style="height:180px;width:130px">
									<div class="caption">
										<a href="${pageContext.request.contextPath }/getbook.action?flag=${book.bookflag}">
											<p>${book.name}</p>
										</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="tab-pane fade " id="wenxue">
			<!-- 人文部分 -->
				<div class="container">
					<div class="row" style="padding-left:8%">
						<div class="col-sm-12" style="height:50px">
							<em style="font-size:40px">文学小说</em>
							<a href="${pageContext.request.contextPath }/booktypequery.action?bookflag=B" style="float:right;padding-top:20px">更多</a>
						</div>
						<c:forEach items="${bookb}" var="book">
							<div class="col-sm-2">
								<div class="thumbnail">
									<img src="/bookpic/${book.bookpic}"style="height:180px;width:130px">
									<div class="caption">
										<a href="${pageContext.request.contextPath }/getbook.action?flag=${book.bookflag}">
											<p>${book.name}</p>
										</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="tab-pane fade" id="bingfa">
			<!-- 历史部分 -->
				<div class="container">
					<div class="row" style="padding-left:8%">
						<div class="col-sm-12" style="height:50px">
							<em style="font-size:40px">兵法著作</em>
							<a href="${pageContext.request.contextPath }/booktypequery.action?bookflag=C" style="float:right;padding-top:20px">更多</a>
						</div>
						<c:forEach items="${bookc}" var="book">
							<div class="col-sm-2">
								<div class="thumbnail">
									<img src="/bookpic/${book.bookpic}"style="height:180px;width:130px">
									<div class="caption">
										<a href="${pageContext.request.contextPath }/getbook.action?flag=${book.bookflag}">
											<p>${book.name}</p>
										</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="tab-pane fade " id="lishi">
			<!-- 兵法部分-->
				<div class="container">
					<div class="row" style="padding-left:8%">
						<div class="col-sm-12" style="height:50px">
							<em style="font-size:40px">历史著作</em>
							<a href="${pageContext.request.contextPath }/booktypequery.action?bookflag=D" style="float:right;padding-top:20px">更多</a>
						</div>
						<c:forEach items="${bookd}" var="book">
							<div class="col-sm-2">
								<div class="thumbnail">
									<img src="/bookpic/${book.bookpic}"style="height:180px;width:130px">
									<div class="caption">
										<a href="${pageContext.request.contextPath }/getbook.action?flag=${book.bookflag}">
											<p>${book.name}</p>
										</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="tab-pane fade" id="shici">
			<!-- 医学部分-->
				<div class="container">
					<div class="row" style="padding-left:8%">
						<div class="col-sm-12" style="height:50px">
							<em style="font-size:40px">诗词小说</em>
							<a href="${pageContext.request.contextPath }/booktypequery.action?bookflag=E" style="float:right;padding-top:20px">更多</a>
						</div>
						<c:forEach items="${booke}" var="book">
							<div class="col-sm-2">
								<div class="thumbnail">
									<img src="/bookpic/${book.bookpic}"style="height:180px;width:130px">
									<div class="caption">
										<a href="${pageContext.request.contextPath }/getbook.action?flag=${book.bookflag}">
											<p>${book.name}</p>
										</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="tab-pane fade " id="zawen">
			<!-- 古典部分-->
				<div class="container">
					<div class="row" style="padding-left:8%">
						<div class="col-sm-12" style="height:50px">
							<em style="font-size:40px">杂文小说</em>
							<a href="${pageContext.request.contextPath }/booktypequery.action?bookflag=F" style="float:right;padding-top:20px">更多</a>
						</div>
						<c:forEach items="${bookf}" var="book">
							<div class="col-sm-2">
								<div class="thumbnail">
									<img src="/bookpic/${book.bookpic}"style="height:180px;width:130px">
									<div class="caption">
										<a href="${pageContext.request.contextPath }/getbook.action?flag=${book.bookflag}">
											<p>${book.name}</p>
										</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
 </body>
</html>