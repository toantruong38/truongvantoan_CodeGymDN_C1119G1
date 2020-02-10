<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/10/2020
  Time: 9:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="/convert">
    <div>
      <label>Rate</label>
        <input type="text" name="rate" value="22000"/>
      <br/>
      <label>USD</label>
        <input type="text" name="usd"/>
      <br/>
      <button name="convert">Convert</button>
    </div>
  </form>
  </body>
</html>
