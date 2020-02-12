<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/12/2020
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<form action="/result" method="post">
    <div>
        <label>USD</label><input type="text" name="usd"/><br/>
        <label>Rate</label><input type="text" name="rate"/><br/>
        <button type="submit">Convert</button>
        <button type="reset">Reset</button>
    </div>
</form>
</body>
</html>
