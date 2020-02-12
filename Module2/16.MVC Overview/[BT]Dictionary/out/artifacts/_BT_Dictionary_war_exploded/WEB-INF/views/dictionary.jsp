<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/12/2020
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/dictionary">
    <label>Search</label>
    <input type="text" name="search"/><br/>
    <label>Result</label>
    <input type="text" name="result" value="${result}" disabled="true"/><br/>
    <button>Search</button>
</form>
</body>
</html>
