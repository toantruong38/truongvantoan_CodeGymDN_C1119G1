<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/11/2020
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product list</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<%!
    public String getAddForm(){
        return "<tr>\n" +
                "        <td><input name=\"id\" placeholder=\"Product id\"/> </td>\n" +
                "        <td><input name=\"name\" placeholder=\"Product name\"/> </td>\n" +
                "        <td><input name=\"price\" placeholder=\"Price\"/> </td>\n" +
                "        <td><input name=\"description\" placeholder=\"Description\"/> </td>\n" +
                "        <td><input name=\"producer\" placeholder=\"Producer\"/> </td>\n" +
                "        <td>\n" +
                "            <a href=\"/products?action=save\" >Apply</a>\n" +
                "        </td>\n" +
                "        <td>\n" +
                "            <a href=\"/products?action=cancel\">Cancel</a>\n" +
                "        </td>\n" +
                "    </tr>";
    }
%>
<script>
    const getForm=()=>{
        return "<tr>\n        <td><input name=\"id\" placeholder=\"Product id\"/> </td>\n        <td><input name=\"name\" placeholder=\"Product name\"/> </td>\n        <td><input name=\"price\" placeholder=\"Price\"/> </td>\n        <td><input name=\"description\" placeholder=\"Description\"/> </td>\n        <td><input name=\"producer\" placeholder=\"Producer\"/> </td>\n        <td>\n            <a href=\"/products?action=save\" >Apply</a>\n        </td>\n        <td>\n            <a href=\"/products?action=cancel\">Cancel</a>\n        </td>\n    </tr>"
    };
</script>
<body>
<form method="post" action="/products?action=search">
    <input type="text" size="30" placeholder="Enter a product name" name="searchproduct"/>
    <button type="submit">Search</button>
</form>
<table class="w3-table-all w3-card-4">
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
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getProducer()}</td>
            <td>
                <a href="/products?action=details&id=${product.getId()}">Details</a>
            </td>
            <td>
                <a href="/products?action=update&id=${product.getId()}">Update</a>
            </td>
            <td>
                <a href="/product?action=delete&id=${product.getId()}">Delete</a>
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
            <button onclick="getForm()">Add</button>
        </td>
    </tr>
</table>
</body>
</html>
