<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/11/2020
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table id="mytable">
    <tr>
        <td>Id</td>
        <td>Product Name</td>
        <td>Price($)</td>
        <td>Description</td>
        <td>Producer</td>
        <td>Detail</td>
        <td>Update</td>
        <td>Action</td>
    </tr>
    <c:forEach items="${requestScope['products']}" var="product">
        <tr>
            <td><input name="id" placeholder="Product id"/> </td>
            <td><input name="name" placeholder="Product name"/> </td>
            <td><input name="price" placeholder="Price"/> </td>
            <td><input name="description" placeholder="Description"/> </td>
            <td><input name="producer" placeholder="Producer"/> </td>
            <td>
                <td><input name="detail" placeholder="Details"/> </td>
            </td>
            <td>
                <a href="/products?action=save&id=${product.getId()}">Apply</a>
            </td>
            <td>
                <a href="/product?action=cancel">Cancel</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td>
            <a href="/products?action=add">Add</a>
        </td>
    </tr>
</table>
</body>
</html>
