<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/13/2020
  Time: 12:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Status</title>
</head>
<body>
<c:if test="${status.equals(\"good\")}">
    <h1>Login succeed</h1>
    <h1>Welcome user: ${user.getUser()}</h1>
    <h2>Name: ${user.getName()}</h2>
    <h2>Email: ${user.getEmail()}</h2>
    <h2>Age: ${user.getAge()}</h2>
</c:if>
<c:if test="${status.equals(\"fail\")}">
    <h1>Login failed</h1>
    <a href="/login/form">Get back home</a>
</c:if>
</body>
</html>
