<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/13/2020
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator-WebApp</title>
</head>
<%!
    public void sendCommand(String command){

    }
%>
<body>
<h1>Lame Calculator</h1>
<form:form method="post" action="/home" modelAttribute="calculation">
    <div>
        <form:input path="o1" type="text" size="30" placeholder="first operator" />
        <form:input path="o2" type="text" size="30" placeholder="second operator" />
        <br/>
        <button name="command" type="submit" value="+">Addition(+)</button>
        <button name="command" type="submit" value="-">Subtraction(-)</button>
        <button name="command" type="submit" value="/">Division(/)</button>
        <button name="command" type="submit" value="*">Multiplication(*)</button>
    </div>
</form:form>
<c:if test="${result!=null}">
    <p>Result : ${result}</p>
</c:if>
<c:if test="${errorMessage!=null}">
    <p>Error : ${errorMessage}</p>
</c:if>
</body>
</html>
