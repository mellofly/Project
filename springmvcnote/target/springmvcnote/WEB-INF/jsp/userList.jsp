<%--
  Created by IntelliJ IDEA.
  User: mellofly
  Date: 2021/2/26
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询人员列表</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/queryUser.action" method="post">
    查询条件：
    <table width="100%" border=1>
        <tr>
            <td><input type="submit" value="查询"/></td>
        </tr>
    </table>
    商品列表：
    <table width="100%" border=1>
        <tr>
            <td>姓名</td>
            <td>wx_id</td>
            <td>电话</td>
            <td>维护人员</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${accountlist}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.wx_id}</td>
                <td>${item.phone}</td>
                <td>${item.deFendName}</td>

                <td><a href="${pageContext.request.contextPath }/item/editItem.action?id=${item.id}">修改</a></td>

            </tr>
        </c:forEach>

    </table>
</form>
</body>

</html>
