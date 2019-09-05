<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Category</title>
</head>
<body>
<form action="<c:url value='/UpdateCategory'/>" method="post">
<table>
<tr>
<td colspan="2">CategoryInfo</td>
</tr>
<tr>
<td>categoryId</td>
<td> <input type="text" name="catId" value="${category.categoryId}"/></td>
</tr>
<tr>
<td>categoryName</td>
<td><input type="text" name="catName" value="${category.categoryName}"/></td>
</tr>
<tr>
<td>categoryDesc</td>
<td><input type="text" name="catDesc" value="${category.categoryDesc}"/></td>
</tr>
</table>
</form>
</body>
</html>