<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/11/2020
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Details</title>
</head>
<body>
<h1 align="center">Hello World</h1>
<a href="/products" class="return">Back to menu</a>
<table id="mytable">
    <tr>
        <th>Product Id</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Producer</th>
        <th>Description</th>
    </tr>
    <tr>
        <c:set var="product" value="${requestScope['product']}"></c:set>
        <th>${product.getId()}</th>
        <th>${product.getName()}</th>
        <th>${product.getPrice()}</th>
        <th>${product.getProducer()}</th>
        <th>${product.getDescription()}</th>
    </tr>
</table>
</body>
</html>
