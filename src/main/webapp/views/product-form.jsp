<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html><body>
<h2>${product.id == 0 ? 'Add' : 'Edit'} Product</h2>
<%--@elvariable id="product" type=""--%>
<form:form modelAttribute="product" action="${product.id == 0 ? 'save' : 'update'}" method="post">
    <form:hidden path="id"/> <!-- Thêm dòng này -->
    Name: <form:input path="name"/><br/>
    Description: <form:textarea path="description"/><br/>
    Price: <form:input path="price"/><br/>
    Stock: <form:input path="stock"/><br/>
    <button type="submit">Save</button>
</form:form>
</body></html>
