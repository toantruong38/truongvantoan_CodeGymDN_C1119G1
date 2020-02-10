<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/10/2020
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="/product_discount_calculator" method="post">
      <div>
        <h1>Product Discount Calculator</h1>
        <label>Product Description</label>
        <input type="text" size="30" name="descr"><br/>
        <label>List price</label>
        <input type="text" size="30" name="price"><br/>
        <label>Discount Percent</label>
        <input type="text" size="30" name="percent"><label>(%)</label><br/>
        <button>Calculate</button>
      </div>
    </form>
  </body>
</html>
