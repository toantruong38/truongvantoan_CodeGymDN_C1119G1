<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/15/2020
  Time: 10:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>City</th>
        <th>State</th>
        <th>Country</th>
    </tr>
    <tr>
        <td>${employee.id}</td>
        <td>${employee.name}</td>
        <td>${employee.address.city}</td>
        <td>${employee.address.state}</td>
        <td>${employee.address.country}</td>
    </tr>
</table>
</body>
</html>
