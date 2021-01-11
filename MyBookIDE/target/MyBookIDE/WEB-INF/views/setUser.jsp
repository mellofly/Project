<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-image:url('/bookpic/back.gif')"> 
 <div style="padding-top:50px;padding-left:6%;padding-right:6%">
	<div class="container">
		<div class="row" >
			<div class="col-xs-12 col-xs-offset-1"style="background-image:url('/bookpic/3.jpg');height:500px;width:88%;padding-left:200px">
				<div style="width:700px;height:400px;">
					<div style="padding:0px 100px ;height:60px;width:400px">
						<c:if test="${error!=null }">
								<p style="font-size:25px">${error }</p>
						</c:if>
					</div>
					<form style="padding:100px 100px;" action="${pageContext.request.contextPath}/newUser.action " method="post"  enctype="multipart/form-data">
					<input type="hidden" name="id" />
					填写用户信息：
					<table width="100%" border=1>
					<tr>
						<td>用户名称</td>
						<td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<td>用户密码</td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td>用户电话</td>
						<td><input type="text" name="phone" /></td>
					</tr> 
					<tr>
						<td>用户头像</td>
						<td><input type="file"  name="picture_pic"/> </td>
					</tr>
					<tr>
						<td>用户邮箱</td>
						<td>
						<input type="text" name="mail" />
						</td>
					</tr>
					<tr>
					<td colspan="2" align="center"><input type="submit" value="提交"/>
					</td>
					</tr>
					</table>
					
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>

</html>