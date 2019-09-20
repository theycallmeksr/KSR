<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>supplier update</title>
</head>
<body>

<form action="<c:url value='/admin/updateSupplier'/>"  method="post">

<!-- <table border="1">  -->
<table> 

<tr>
<td colspan="2">SupplierInfo</td>
</tr>
<tr>
<td>supplierId</td>
<td><input type="text" name="updatesid" value="${supplier.supplierId}"/></td>
</tr><tr>
<td>supplierName</td>
<td><input type="text" name="updatesname" value="${supplier.supplierName}"/>
</td>
</tr>
<tr>
<td>suppliermobile</td>
<td><input type="text" name="updatesmobile" value="${supplier.supplierMobileNumber}"/>
</td>
</tr>
<tr>
<td>supplieradddress</td>
<td><input type="text" name="updatesadd" value="${supplier.supplierAddress}"/>
</td>
</tr>


<tr><td><input type="submit" value="submit"></td></tr>         
</table>
</form>

</body>
</html>