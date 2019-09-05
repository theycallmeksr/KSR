<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category page</title>
</head>
<body>
<form action="<c:url value='/InsertCategory'/>" method="post">
<table>
<tr>
<td>Enter Category Name :</td><td><input type="text" name="catname"></td>
</tr>
<tr>
<td>Enter Category Description :</td><td><input type="text" name="catdesc"></td>
</tr>
<tr>
<td><input type="submit" value="submit"></td>
</tr>
</table>
</form>
</body>
</html>