<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
  <title>古典小说文学网_章节内容</title>
  <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
  <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <style>
	.gw_nav{ height:60px; line-height:50px; font-size:18px; overflow:hidden; padding-top:20px;}.gw_nav a{ color:#61452c; margin:0 30px; font-weight:normal;}.gw_nav a:hover,.gw_nav a:active{ color:#e36c02;text-decoration:none;}
  </style>
  <script type="text/javascript">
	  function displayshoucang(){
			if(document.getElementById("show").style.display=="none"){
				document.getElementById("show").style.display="inline";
			}
			else{
				document.getElementById("show").style.display="none";
			}
		}
		function displaybookchap(name,id,noteflag){
			if(document.getElementById("bookcomment"+id).style.display=="none"){
				document.getElementById("bookcomment"+id).style.display="inline";
				if(name=='添加笔记'){
					document.getElementById("showname"+id).value="添加笔记";
					document.getElementById("note"+id).value=noteflag;
					document.getElementById("valuename"+id).value=null;
					}
				else{
				if(name=='null'){
					  document.getElementById("showname"+id).value="评论文章";
					  document.getElementById("note"+id).value=noteflag;
					  document.getElementById("valuename"+id).value=null;
				  }
				else{
					document.getElementById("showname"+id).value="评论"+name;
					document.getElementById("note"+id).value=noteflag;
					document.getElementById("valuename"+id).value=name;
				}}
			}
			else{
				document.getElementById("bookcomment"+id).style.display="none";
			}
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
			<div class="row" style="height:100px">
				<div class="col-xs-4 col-xs-offset-2" >
					<h3>${chapter.value }</h3>
				</div>
				<br>
				<div>
				<button onclick="displayshoucang()">个性化书签</button>
				</div>
			</div>
			<div class="row" >
				<div class="col-xs-6" id="show" style="height:100px;width:100%;display:none">
					<form action="${pageContext.request.contextPath}/collection.action" method="post">
					<input type="text" name="bookname" value="${chapter.bookName}"style="display:none"><!-- style="display:none" -->
					<input type="text" name="chapterflag" value="${chapter.chapterflag}"style="display:none">
					<input type="text" name="username" value="${user.name}"style="display:none">
					<br>
					<input type="text" name="personalityname"style="width:60%;">
					<button type="submit">添加书签</button>
					</form>
				</div>
			</div>
			<div style="height:20px;"></div>
			<div class="row">
				<div class="col-md-12 column">
					<div class="panel-group">
						<c:forEach items="${cvalueQQ}" var="cvalueQ">
							<div class="panel panel-default">
								<!-- 内容的显示 -->
								<div class="panel-heading">
									 <a class="panel-title" data-toggle="collapse" href="#${cvalueQ.cvalue.id}">
									<p>${cvalueQ.cvalue.value }</p></a>
								</div>
								<!-- 评论与笔记的显示 -->
								<div id="${cvalueQ.cvalue.id}" class="panel-collapse collapse"style="background-image:url('/bookpic/back.gif');">
									<div class="panel-body">
									<div style="height:10px;float:right"><button onclick="displaybookchap('添加笔记','${cvalueQ.cvalue.id }','1')">添加书籍笔记</button></div>
										<div style="height:10px;float:right"><button onclick="displaybookchap('null','${cvalueQ.cvalue.id }','0')">添加书籍评论</button></div>
										<div>
										<!-- 笔记与笔记评论的显示 -->
											<c:set value="${cvalueQ.comment1ist}" var="commentlist"/>
											<c:forEach items="${commentlist}" var ="Comments">
												<!-- 笔记评论 -->
												<c:set value="${Comments.note}" var="notelist"/>
												<div><p>笔记部分</p></div>
												<c:forEach items="${ notelist}" var="note">
													<div class="container" style="height:60px;" >
														<div  class="col-md-8 column"><p>${note.message}</p></div>
														<div class="col-md-1 column">
														<p>发表人</p>
														<p>发表时间</p></div>
														<div  class="col-md-2 "><p><a href="${pageContext.request.contextPath}/personal.action?id=${note.person}">${note.user_name}</a></p>
														<fmt:formatDate value="${note.time}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
														<div  class="col-md-1 column">
														<button onclick="displaybookchap('${note.user_name}','${cvalueQ.cvalue.id }','1')">回复</button>
														</div>
													</div>
													<!-- TODO -->
												</c:forEach>
												<!-- 笔记评论 -->
												<c:set value="${Comments.comment}" var="comment"/>
												<c:forEach items="${comment}" var="comment">
												<div class="container" style="height:30px;" >
													<div  class="col-md-8 column">
														<div  class="col-md-1"><p>----</p></div>
														<div  class="col-md-6 col-offset-1"><p>${comment.message}</p></div>
														<div  class="col-md-1 column"><p><a href="${pageContext.request.contextPath}/personal.action?id=${comment.person}">${comment.userName}</a></p></div>
														<div class="col-md-2 column">
														<fmt:formatDate value="${comment.time}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
													</div>
												</div>
												<div style="height:10px"></div>
												</c:forEach>
											</c:forEach>
											<!-- 段落评论的显示 -->
											<c:set value="${cvalueQ.chaptercomment}" var="chaptercomment"/>
											<div><p>评论部分</p></div>
											<c:forEach items="${chaptercomment}" var ="Comment">
												<c:set value="${Comment.note }" var="duancomment"></c:set>
												<c:forEach items="${duancomment}" var="comment1">
												<div class="container" style="height:60px;">
													<div  class="col-md-8 column"><p>${comment1.message}</p></div>
													<div class="col-md-1 column">
													<p>发表人</p>
													<p>发表时间</p></div>
													<div  class="col-md-2 column"><p><a href="${pageContext.request.contextPath}/personal.action?id=${comment1.person}">${comment1.user_name}</a></p>
													<fmt:formatDate value="${comment1.time}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
													<div  class="col-md-1 column">
													<button onclick="displaybookchap('${comment1.user_name}','${cvalueQ.cvalue.id }','0')">回复</button>
													</div>
												</div>
												</c:forEach>
												<c:set value="${Comment.comment }" var="commentcomment"></c:set>
												<!-- 段落评论的评论部分 -->
												<c:forEach items="${commentcomment }" var="comment2">
													<div class="container" style="height:80px;">
														<div  class="col-md-8 column">
														<div  class="col-md-1"><p>----</p></div>
														<div  class="col-md-6 col-offset-1"><p>${comment2.message}</p></div>
														</div>
														<div class="col-md-1 column"><p><a href="${pageContext.request.contextPath}/personal.action?id=${comment2.person}">${comment2.userName}</a></p></div>
														<div class="col-md-2 column">
														<fmt:formatDate value="${comment2.time}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
													</div>
												</c:forEach>
												
												<div style="height:10px"></div>
											</c:forEach>
											<!-- 评论添加部分 -->
											<div id="bookcomment${cvalueQ.cvalue.id }" style="display:none">
												<form action="${pageContext.request.contextPath}/addcomment.action" method="post">
												<input type="text" id="showname${cvalueQ.cvalue.id }" style="width:100px" value="添加评论"readonly/>
												<!-- 评论内容 -->
												<input type="text"  value=""name="message"style="line-height:60px;width:100%"/> 
												<!-- 评论flag -->
												<input type="text" name="flag" value="${cvalueQ.cvalue.valueflag}" style="display:none">
												<!-- 被评论人 -->
												<input type="text" name="name" id="valuename${cvalueQ.cvalue.id }" value="" style="display:none">
												<!-- 被评论人 -->
												<input type="text" name="note1" id="note${cvalueQ.cvalue.id}" value="" style="display:none">
												<!-- 评论人员 -->
												<input type="text" name="username" value="${user.name}" style="display:none">
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
						</c:forEach>
					</div>
				</div>
				
			</div>
			
		</div>
	</div>
</body>
</html>