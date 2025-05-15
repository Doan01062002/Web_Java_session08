<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách nhân viên</title>
</head>
<body>
<h2>Danh sách nhân viên</h2>

<c:if test="${not empty success}">
    <p style="color: green;">${success}</p>
</c:if>

<a href="${pageContext.request.contextPath}/employees/add">Thêm nhân viên mới</a>

<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>Họ tên</th>
        <th>Email</th>
        <th>Vị trí</th>
    </tr>
    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.name}</td>
            <td>${emp.email}</td>
            <td>${emp.position}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
