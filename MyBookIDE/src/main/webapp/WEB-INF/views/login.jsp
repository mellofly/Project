<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-image:url('/bookpic/back.gif')">
 <div style="padding-top:50px;padding-left:6%;padding-right:6%">
	<div class="container">
		<div class="row" >
			<div class="col-xs-12 col-xs-offset-1"style="background-image:url('/bookpic/3.jpg');height:500px;width:88%;padding-left:200px">
				
				<div style="width:400px;height:400px;">
					<div style="padding:0px 100px ;height:60px;width:400px">
						<c:if test="${error!=null }">
								<p style="font-size:25px">${error }</p>
						</c:if>
					</div>
					<form style="padding:80px 100px;" action="${pageContext.request.contextPath}/usercheck.action" method="post">
						<div class="form-group">
							<label >帐号</label>
							<input type="text" class="form-control" value="邮箱帐号/手机号" name="username"/>
						</div>
						<div class="form-group">
							<label >密码</label>
							<input type="password" class="form-control" value="密码" name="password"/>
						</div>
						<button type="submit" class="btn btn-default">登陆</button>
					</form >
					
				</div>
			</div>
		</div>
	</div>
</div>
 </body>
</html>