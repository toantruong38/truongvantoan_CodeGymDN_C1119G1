<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/14/2020
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Email validate</h1>
<h3 style="color: red">${message}</h3>
<form action="/validate" method="post">
    <input type="text" name="email"/><br>
    <input type="submit" value="validate"/>
</form>
</body>
</html>
