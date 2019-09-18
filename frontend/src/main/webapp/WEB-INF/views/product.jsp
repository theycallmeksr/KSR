<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<%@include file="header.jsp"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="resources/images/bg1.jpg">
<br/><br/>
<form:form action="InsertProduct" modelAttribute="product" method="post" enctype="multipart/form-data">
<table align="center" class="table-bordered">
<tr>
<td colspan="2">Product Info </td>
</tr>
<tr>
<td>Product Name</td>
<td><form:input path="productName"/></td>
</tr>
<tr>
<td>Price</td>
<td><form:input path="price"/></td>
</tr>
<tr>
<td>Stock</td>
<td><form:input path="stock"/></td>
</tr>
<tr>
<td>Image</td>
<td><form:input type="file" path="pimage"/></td>
</tr>
<tr>
<td>Category</td>
<td>
<form:select path="categoryId">
<form:option value="0" label="--Select Category--"/>
<form:options items="${categoryList}"/>
</form:select>
</td>
</tr>
<tr>
<td>Supplier</td>
<td>
<form:select path="supplierId">
<form:option value="0" label="--Select Supplier--"/>
<form:options items="${supplierList}"/>
</form:select>
</td>
</tr>
<tr>
<td>Product Desc</td>
<td><form:input path="productDesc"/></td>
</tr>
<tr>
<td colspan="2"><center><input type="submit" value="InsertProduct"/></center></td>
</tr>
</table>		
</form:form>
</br>
<table align="center" border="1" >
<tr>
<td>Product ID</td>
<td>Product Name</td>
<td>Product Description</td>
<td>Price</td>
<td>Stock</td>
<td>Category ID</td>
<td>Supplier ID</td>
<td>Operations</td>
</tr>
<c:forEach items="${productList}" var="product">
<tr>
<td>${product.productid}</td>
<td>${product.productName}</td>
<td>${product.productDesc}</td>
<td>${product.price}</td>
<td>${product.stock}</td>
<td>${product.categoryId}</td>
<td>${product.supplierId}</td>
<td>
<a href="<c:url value="/editProduct/${product.productid}"/>"class="btn btn-success">Edit</a>
<a href="<c:url value="/deleteProduct/${product.productid}"/>"class="btn btn-danger">Delete</a>
</td>
</tr>
</c:forEach>       
</table>
</body>
</html>