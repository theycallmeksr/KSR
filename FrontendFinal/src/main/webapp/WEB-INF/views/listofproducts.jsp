<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ include file="header.jsp"%>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=ISO-8859-1">
<title>Insert title here</title>

<!-- 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

JQuery
    <script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>


    <link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet"> -->

<meta charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
var searchCondition='${searchCondition}'
$('.table').DataTable({
"lengthMenu":[[5,7,-1],[5,7,"All"]],
   "oSearch" : {
"sSearch" : searchCondition
}
})
})
</script>

 <style type="text/css">
table th.bg 
{
padding:15px;
background:#ccc;
color:#000;

}
table td {
padding:15px;
}
 
</style>

</head>


<body>

<div class="container">
<center><h1>List Of Products</h1></center>
<table class="table table-stripped" style="text-align:center; margin:0  auto;" border="3" > 

<tr>
<th class="bg"><i>ProductId</i></th>
<th class="bg"><i>ProductName</i></th>
<th class="bg"><i>ProductQuantity</i></th>
<th class="bg"><i>ProductPrice</i></th>
<th class="bg"><i>CategoryName</i></th>
<!-- <th class="bg"><i>SupplierName</i></th> -->

<%-- <security:authorize access="hasRole('ROLE_USER')">
<th class="bg"></th>
</security:authorize> --%>


<th class="bg"><i>Image</i></th>
<%-- <security:authorize access="hasRole('ROLE_ADMIN')"> --%>
<th class="bg"><i>ProductOption</i></th>
<%-- </security:authorize> --%>
</tr>
<c:forEach items="${productsList}" var="prod">
<tr>
<td><b><i>${prod.productId}</i></b></td>
<td><b><i>${prod.productName}</i></b></td>
<td><b><i>${prod.productQty}</i></b></td>
<td><b><i>${prod.productPrice}</i></b></td>
<td><b><i>${prod.category.categoryName}</i></b></td> 
<%-- <td><b><i>${prod.supplier.supplierName}</i></b></td>  --%>
<td ><img src="<c:url value='/resources/images/${prod.productId}.png'></c:url>" height="30px"width="30px"></td>

<td>
<a href="<c:url value='/all//getproductview/${prod.productId }'></c:url>">
<span class="glyphicon glyphicon-info-sign"></span></a>
<security:authorize access="hasRole('ROLE_ADMIN')">

<a href="<c:url value='/admin/delete-gly/getallproducts/${prod.productId }'></c:url>"><span
class="glyphicon glyphicon-trash"></span></a>


<a href="<c:url value='/admin/editProduct/${prod.productId }'></c:url>"><span
class="glyphicon glyphicon-pencil"></span></a>
</td>


</security:authorize>
 <security:authorize access="hasRole('ROLE_ADMIN')">
<a href="<c:url value='/admin/delete-gly/getallproducts/${prod.productId }'></c:url>"><span
class="glyphicon glyphicon-trash"></span></a>


<a href="<c:url value='/admin/editProduct/${prod.productId }'></c:url>"><span
class="glyphicon glyphicon-pencil"></span></a>
</td>
</security:authorize>

</tr>
</c:forEach>
</table>
</div>
</body>
</html>
