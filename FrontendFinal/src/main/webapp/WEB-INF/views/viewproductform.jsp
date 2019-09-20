<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="panel-info">
			<div class="panel panel-heading"><h2>Product Details</h2></div>
			<div class="panel panel-body">
			<c:url value="/all/cart/addtocart/${productObj.productId}" var="url"></c:url>
			<form action="${url }" >
			<%-- <b>Product Name:</b>${productObj.productId }<br> --%>
			<b>Product Name:</b>${productObj.productName }<br>
			<%-- <b>Product Desc:</b>${productObj.productdesc }<br> --%>
			<b>Quantity:</b>${productObj.productQty }<br>
			<b>Price:</b>${productObj.productPrice }<br>
			<b>Category:</b>${productObj.category.categoryName}<br>
			<%-- <b>Supplier:</b>${productObj.supplier.supplierName}<br> --%>
			<img src="<c:url value='/resources/images/${productObj.productId}.png'></c:url>"  height="30%" width="30%"><br>
			<c:if test="${productObj.productQty==0 }">
			<button class="btn btn-primary btn-lg" disabled>Out Of Stock</button>
			</c:if>
			<c:if test="${productObj.productQty>0 }">
			<security:authorize access="hasRole('ROLE_USER')">
			Enter Quantity:<input type="number" min="1" max="${productObj.productQty }" name="requestedQuantity">
			<button class="btn btn-primary btn-lg" type="submit"><span class="glyphicon glyphicon-shopping-cart" ></span>Add To Cart</button>
			</security:authorize>
			</c:if>
			
			</form>
			<a href="<c:url value='/all/getallproducts'></c:url>">Browse all products</a>
			</div>
		</div>
	</div>

</body>
</html>