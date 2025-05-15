<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 5/15/2025
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dangnhap" method="post">
    Tên người chơi: <input type="text" name="farmerName" required /><br/>
    Mật khẩu: <input type="password" name="farmerPass" required /><br/>
    <button type="submit">Đăng nhập</button>
</form>
<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>
<a href="/dangky">Chưa có tài khoản? Đăng ký</a>

</body>
</html>
