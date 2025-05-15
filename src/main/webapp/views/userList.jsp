<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách người dùng</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: auto;
        }
        th, td {
            padding: 10px;
            border: 1px solid #666;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h2 style="text-align:center;">Danh sách người dùng</h2>

<table>
    <tr>
        <th>STT</th>
        <th>Họ tên</th>
        <th>Tuổi</th>
        <th>Ngày sinh</th>
        <th>Email</th>
        <th>Số điện thoại</th>
    </tr>

    <c:forEach var="user" items="${users}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td><fmt:formatDate value="${user.birthday}" pattern="dd/MM/yyyy"/></td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
