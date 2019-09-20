<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
     
       <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>supplier</title>

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

<c:url value="/admin/addsupplier" var="url"></c:url>
<form action="${url}" method="post">
		
			<table>
				<tr>
					<td>Supplier Id</td>            
					<td><input type="hidden" name="sid"></td>
				</tr>
				<tr>
					<td>Supplier Name</td>
					<td><input type="text" name="sname"></td>
				</tr>
				
				<tr>
					<td>Supplier MobileNo</td>
					<td><input type="text" name="smobile" ></td>
				</tr>
				
				<tr>
					<td>supplier Address</td>
					<td><input type="text" name="sadd"></td>
					
				</tr>
				
				<tr>
					<td><input type="submit" value="Save Supplier"></td>
				</tr>
			</table>

	</form>
	
	<table>
		<tr
			style="background-color: rgba(43, 187, 231, 0.911); color: black; font-family: serif; text-align: center; height: 30px;">

			<th>supplierId</th>                        
			<th>supplierName</th>                        
			<th>supplierMobileNumber</th>               
			<th>supplierAddress</th>             
		</tr>
  
  <c:forEach items="${getListOfSupplier}" var="supplier">
<tr>
<td>${supplier.supplierId}            
</td>
<td>${supplier.supplierName}              
</td>
<td>${supplier.supplierMobileNumber}                
</td>
<td>${supplier.supplierAddress}                   
</td>
<td>
<a href="<c:url value="/admin/deleteSupplier/${supplier.supplierId}"></c:url>">Delete</a>
<a href="<c:url value="/admin/editsupplier/${supplier.supplierId}"></c:url>">Edit</a>

</td>

</tr>
</c:forEach>
 	 
		
		<%-- <c:forEach items="${getListOfSupplier}" var="supplier">                                   
			<tr>
				<td>${supplier.supplierId}</td>
				<td>${supplier.supplierName}</td>
				<td>${supplier.supplierMobileNumber}</td>
				<td>${supplier.supplierAddress}</td>

				<td><a href="/deletesupplier/${supplier.supplierId}">Delete</a>
					<a href="/editsupplier/${supplier.supplierId}">Edit</a></td>
			</tr>
		</c:forEach> 
 			 --%>
 
 </table>

	 	<%-- <a href = "<c:url value='viewSupplierlist'></c:url>">view supplier list</a>  --%>
	

</body>
</html>