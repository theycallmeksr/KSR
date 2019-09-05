<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit/Delete</title>
</head>
<body>
<table>
<tr>
<th>Category Id</th>
<th>Category Name</th>
<th>Description</th>
</tr><c:forEach items="${categorylist}" var="category">
<tr>
<td>${cat.catId}</td>
<td>${cat.catName}</td>
<td>${cat.catDesc}</td>
<td><a href="<c:url value="/editCategory/${category.categoryId}"></c:url>">Edit</a></td>
<td><a href="<c:url value="/deleteCategory/${category.categoryId}"></c:url>">Delete</a></td>
</tr>
<tr>
<td>
</tr>
</c:forEach>
</table>
</body>
</html>