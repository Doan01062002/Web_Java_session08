<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 5/15/2025
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>🌱 Cửa hàng hạt giống</h2>
<table border="1">
    <tr>
        <th>Ảnh</th>
        <th>Tên hạt giống</th>
        <th>Giá (VNĐ)</th>
    </tr>
    <c:forEach items="${allSeeds}" var="seed">
        <tr>
            <td><img src="${seed.seedImage}" width="100"/></td>
            <td>${seed.seedName}</td>
            <td>${seed.seedPrice}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
