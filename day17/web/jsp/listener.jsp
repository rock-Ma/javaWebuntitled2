<%--
  Created by IntelliJ IDEA.
  User: rock-Ma
  Date: 2023/7/31
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    span{
        color: black;
        font-family: '微软雅黑';
        font-size: 17px;
    }
</style>
<body>
<span>当前在线用户:&nbsp;${applicationScope.count }人&nbsp;</span>
<span>${applicationScope}</span>
</body>
</html>
