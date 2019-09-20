<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update your data</title>
</head>
<body>

<form action="<c:url value='/admin/updateCategory'/>"  method="post">
<table border="1"><tr>
<td colspan="2">CategoryInfo</td>
</tr>
<tr>
<td>CategoryId</td>
<td><input type="text" name="cid" value="${category.categoryId}"/></td>
</tr><tr>
<td>CategoryName</td>
<td><input type="text" name="cname" value="${category.categoryName}"/>
</td>
</tr>
<tr>
<td>CategoryDesc</td>
<td><input type="text" name="cdesc" value="${category.categoryDesc}"/>
</td>
</tr>
<tr><input type="submit" value="submit"></tr>
</table>
</form>


</body>
</html>