<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/11/2020
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #customers {
        font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    #customers td, #customers th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    #customers tr:nth-child(even){background-color: #f2f2f2;}

    #customers tr:hover {background-color: #ddd;}

    #customers th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: #4CAF50;
        color: white;
    }

    .myButton {
        box-shadow:inset 0px 1px 8px 0px #54a3f7;
        background:linear-gradient(to bottom, #007dc1 5%, #0061a7 100%);
        background-color:#007dc1;
        border-radius:3px;
        border:1px solid #124d77;
        display:inline-block;
        cursor:pointer;
        color:#ffffff;
        font-family:Arial;
        font-size:13px;
        padding:10px 13px;
        text-decoration:none;
        text-shadow:0px 1px 0px #154682;
    }
    .myButton:hover {
        background:linear-gradient(to bottom, #0061a7 5%, #007dc1 100%);
        background-color:#0061a7;
    }
    .myButton:active {
        position:relative;
        top:1px;
    }
</style>
<body>
<h1 align="center">Customer</h1>
<p>
    <a href="/customer?action=create" class="myButton">Create new customer</a>
</p>
<table border="1" id="customers">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${requestScope['customers']}" var="customer">
        <tr>
            <th>${customer.getName()}</th>
            <th>${customer.getEmail()}</th>
            <th>${customer.getAddress()}</th>
            <th>
                <a href="/customer?action=edit&id=${customer.getId()}">Edit</a>
            </th>
            <th>
                <p>
                <a href="/customer?action=delete&id=${customer.getId()}">Delete</a></p>
            </th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
