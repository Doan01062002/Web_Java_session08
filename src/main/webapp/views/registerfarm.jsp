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
<form action="/dangky" method="post">
    Tên người chơi: <input type="text" name="farmerName" required /><br/>
    Mật khẩu: <input type="password" name="farmerPass" required /><br/>
    Email: <input type="email" name="farmerEmail" required /><br/>
    <button type="submit">Đăng ký</button>
</form>
<a href="/dangnhap">Đã có tài khoản? Đăng nhập</a>

</body>
</html>
