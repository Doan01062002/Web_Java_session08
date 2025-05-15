<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trò chơi đoán hình ảnh</title>
</head>
<body>
<h2>Đoán hình ảnh!</h2>
<img src="${question.imageUrl}" alt="Câu hỏi" width="300"/>

<c:if test="${not correct and not gameOver}">
    <form action="${pageContext.request.contextPath}/guess" method="post">
        <input type="text" name="userAnswer" placeholder="Nhập đáp án" required/>
        <button type="submit">Đoán</button>
    </form>
</c:if>

<h3 style="color:red;">${message}</h3>

<c:if test="${correct or gameOver}">
    <form action="${pageContext.request.contextPath}/quiz" method="get">
        <button type="submit">Chơi lại</button>
    </form>
</c:if>
</body>
</html>
