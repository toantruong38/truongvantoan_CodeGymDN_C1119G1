<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/13/2020
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Site</title>
</head>
<body>
<form:form action="status" method="post" modelAttribute="login">
    <div>
        <label>UserName: </label>
        <form:input path="user"></form:input>
        <br/>
        <label>Pass: </label>
        <form:input path="pass"></form:input><br/>
        <button type="submit">Login</button>
    </div>
</form:form>

</body>
</html>
