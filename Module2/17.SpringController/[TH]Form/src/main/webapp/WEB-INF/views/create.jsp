<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/14/2020
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create a new employee</title>
</head>
<body>
<h3>Welcome,enter employee details</h3>
<form:form modelAttribute="employee" action="/addEmployee" method="post">
    <table>
        <tr>
            <td><label>Employee ID</label></td>
            <td><form:input path="id"></form:input></td>
        </tr>
        <tr>
            <td><label>Employee name</label></td>
            <td><form:input path="name"></form:input></td>
        </tr>
        <tr>
            <td><label>Contact Number</label></td>
            <td><form:input path="contactNumber"></form:input></td>
        </tr>
        <tr>
            <td><button type="submit">Submit</button> </td>
        </tr>
    </table>
</form:form>
</body>
</html>
