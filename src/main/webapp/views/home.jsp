<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><body>
<h2>Product List</h2>
<a href="add">Add Product</a>
<form action="search" method="get">
    <input name="name" placeholder="Search..."/>
    <button>Search</button>
</form>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Price</th><th>Actions</th></tr>
    <c:forEach items="${list}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>
                <a href="view?id=${p.id}">View</a>
                <a href="edit?id=${p.id}">Edit</a>
                <a href="delete?id=${p.id}" onclick="return confirm('Delete?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body></html>
