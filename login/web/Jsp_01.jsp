<%@ page import="com.yunhe.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: rock-Ma
  Date: 2023/7/26
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    session.setAttribute("str1","满园春色啼不住");
    application.setAttribute("str2","一枝红杏出墙来");
    User u = new User(17,"高棋","sakfaskfsa");
    List list = new ArrayList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    request.setAttribute("u1",u);
    request.setAttribute("list",list);
    out.println(u);

%>
</body>
</html>
