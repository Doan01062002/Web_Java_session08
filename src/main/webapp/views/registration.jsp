<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký</title>
</head>
<body>
<h2>Form Đăng ký</h2>
<%--@elvariable id="user" type=""--%>
<form:form modelAttribute="user" method="post">

    Tên người dùng: <br>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error"/><br><br>

    Email: <br>
    <form:input path="email"/>
    <form:errors path="email" cssClass="error"/><br><br>

    Số điện thoại: <br>
    <form:input path="phone"/>
    <form:errors path="phone" cssClass="error"/><br><br>

    <input type="submit" value="Đăng ký"/>
</form:form>
</body>
</html>
