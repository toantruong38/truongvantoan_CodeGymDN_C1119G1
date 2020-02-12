<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/11/2020
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

<table class="w3-table-all w3-card-4">
    <tr>
        <td>Id</td>
        <td>Product Name</td>
        <td>Price($)</td>
        <td>Description</td>
        <td>Producer</td>
        <td>Affirm</td>
        <td>Abort</td>
    </tr>
    <c:forEach items="${requestScope['products']}" var="product">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getProducer()}</td>
            <td>
<%--                <a href="/products?action=details&id=${product.getId()}">Details</a>--%>
            </td>
            <td>
<%--                <a href="/products?action=save&id=${product.getId()}">Apply</a>--%>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td><input name="id" placeholder="Product id"/> </td>
        <td><input name="name" placeholder="Product name"/> </td>
        <td><input name="price" placeholder="Price"/> </td>
        <td><input name="description" placeholder="Description"/> </td>
        <td><input name="producer" placeholder="Producer"/> </td>
        <td>
            <a href="/products?action=save" >Apply</a>
        </td>
        <td>
            <a href="/products?action=cancel">Cancel</a>
        </td>
    </tr>
</table>
</body>
</html>
