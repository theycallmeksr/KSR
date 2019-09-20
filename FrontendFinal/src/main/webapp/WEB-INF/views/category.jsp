<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
    
    <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>

<style type="text/css">
table td {
padding:10px;
}
table th {
padding:10px;
}
</style>

</head>


<body>
<c:url value="/admin/addcategory" var="url"></c:url>
<form action="${url}" method="post" >

Enter the Category Name:<input type="text" name="cname"><br> <br>
Enter the Category Desc:<input type="text" name="cdesc"><br> <br>
<input type="submit" value="Submit">
</form>



<table >
<tr><th>CategoryId</th><th>CategoryName</th><th>CategoryDesc</th>
</tr>
<c:forEach items="${CategoryList}" var="Category">
<tr>
<td>${Category.categoryId}
</td>
<td>${Category.categoryName}
</td>
<td>${Category.categoryDesc}
</td>
<td>
<a href="<c:url value="/admin/deleteCategory/${Category.categoryId}"></c:url>">Delete</a>
<a href="<c:url value="/admin/editCategory/${Category.categoryId}"></c:url>">Edit</a>

</td>

</tr>
</c:forEach>
</table>
</body>
</html>