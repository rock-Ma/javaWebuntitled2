<%--
  Created by IntelliJ IDEA.
  User: rock-Ma
  Date: 2023/8/1
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>当前登录的用户：${usernmae}</h1>
    <h2>当前在线人数：${list.size()},用户列表如下：</h2>
<ul>
    <c:if test="${list!=null}">
        <c:forEach items="${list}" var="name">
            <li>
                ${name}
            </li>
        </c:forEach>
    </c:if>
</ul>


</body>
</html>
