<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
  <title>古典小说文学网_章节</title>
  <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
  <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <style>
	.gw_nav{ height:60px; line-height:50px; font-size:18px; overflow:hidden; padding-top:20px;}.gw_nav a{ color:#61452c; margin:0 30px; font-weight:normal;}.gw_nav a:hover,.gw_nav a:active{ color:#e36c02;text-decoration:none;}
  </style>
   <script>
	  function pinglun(name){
		  if(document.getElementById("form").style.display=="none"){
				document.getElementById("form").style.display="inline";
				if(name!='null'){
					  document.getElementById("show").value="回复"+name;
					}
				  else{
					  document.getElementById("show").value="评论文章";
				  }
			}
			else{
				document.getElementById("form").style.display="none";
		  }
		  document.getElementById("valuename").value=name;
		}
	</script>
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
							<a href="${pageContext.request.contextPath }/booktypequery.action?bookflag=F">杂文小说</a>							</div>
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
			<div class="row" style="height:200px;">
				<div class="col-xs-2">
					<img src="/bookpic/${book.bookpic}" style="height:200px;width:150px">
				</div>
				<div class="col-xs-6" >
					<h3>${book.name }</h3>
					<p>${book.introduce }</p>
				</div>
				<div>
				<button onclick="pinglun('null')">添加评论</button>
				</div>
			</div>
			<div style="height:20px;"></div>
			<div class="row" >
				<ul class="nav nav-tabs">
					<li class="active">
						 <a href="#mulu" data-toggle="tab">章节目录</a>
					</li>
					<li>
						 <a href="#pinglun" data-toggle="tab">评论内容</a>
					</li>
				</ul>
				<div style="height:10px;">
				</div>
				<div class="tab-content">
					<!-- 章节 -->
					<div class="tab-pane fade in active" id="mulu">
						<c:forEach items="${chapter}" var="chapter">
							<div class="col-xs-4">
								<a href="${pageContext.request.contextPath }/bookvalue.action?flag=${chapter.chapterflag}" style="font-size:15px">${chapter.value}</a>
							</div>
						</c:forEach>
					</div>
					<!-- 评论 -->
					<div class="tab-pane fade" id="pinglun">
						<c:forEach items="${bookcomment }" var="comment">
							<c:set value="${comment.note}" var="bookcomment" />
							<!-- 章节评论 -->
							<c:forEach items="${bookcomment}" var="comment1">
								<div class="container" style="height:60px;">
									<div  class="col-md-8 column"><p>${comment1.message}</p></div>
									<div class="col-md-1 column">
									<p>发表人</p>
									<p>发表时间</p></div>
									<div  class="col-md-2 column"><p><a href="${pageContext.request.contextPath}/personal.action?id=${comment1.person}">${comment1.user_name}</a></p>
									<fmt:formatDate value="${comment1.time}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
									<div  class="col-md-1 column">
									<button onclick="pinglun('${comment1.user_name}')">回复</button>
									</div>
								</div>
							</c:forEach>
							<c:set value="${comment.comment}" var="commentcomment" />
							<!-- 章节评论的评论  -->
							<c:forEach items="${commentcomment}" var="comment2">
								<div class="container" style="height:80px;">
									<div  class="col-md-8 column">
									<div  class="col-md-1"><p>----</p></div>
									<div  class="col-md-6 col-offset-1"><p>${comment2.message}</p></div>
									</div>
									<div class="col-md-2 column">
									<p>发表人</p>
									<p>发表时间</p></div>
									<div  class="col-md-2 column"><p><a href="${pageContext.request.contextPath}/personal.action?id=${comment2.person}">${comment2.userName}</a></p>
									<fmt:formatDate value="${comment2.time}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
									
								</div>
							</c:forEach>
							<div style="height:10px;"></div>
						</c:forEach>
						<form id="form" action="${pageContext.request.contextPath}/addcomment.action" method="post" style="display:none">
						<input type="text" id="show" style="width:100px" value="添加评论"readonly/>
						<!-- 评论内容 -->
						<input type="text"  value=""name="message"style="line-height:60px;width:100%"/> 
						<!-- 评论flag -->
						<input type="text" name="flag" value="${book.bookflag}"style="display:none">
						<!-- 评论flag -->
						<input type="text" name="name" id="valuename" value=""style="display:none">
						<!-- 评论note -->
						<input type="text" name="note1"  value="0"style="display:none">
						<!-- 评论人员 -->
						<input type="text" name="username" value="${user.name}"style="display:none">
						<c:if test="${user!=null}">
							<button type="submit" >提交评论</button>
						</c:if>
						<c:if test="${user==null}">
							<button type="submit" disabled="disabled">提交评论</button>
						</c:if>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>