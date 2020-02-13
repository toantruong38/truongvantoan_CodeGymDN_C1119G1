<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/13/2020
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments Selector</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form:form method="post" action="/home/listed">
    <c:forEach var="e" items="${condiments}">
    <input type="checkbox" name="condiments" value="${e.getName()}"/><lable>${e.getName()}</lable>
    </c:forEach><br/>
<button type="submit">Save</button>
</form:form>
</body>
</html>
