<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
       
      <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Product view page </title>
</head>
<body>

<div class="container">
<c:url value="/addproduct" var="url"></c:url>
  <form:form modelAttribute="pro" action="${url}" method="post" enctype="multipart/form-data" >    <!-- enctype="multipart/form-data" > -->
    <table>
        <tr>
             <td><form:hidden path="productId"></form:hidden></td>
         </tr>

         <tr>
             <td>ProductName</td>
             <td><form:input path="productName" placeholder="productname is mandatory"/></td>
              <td> <form:errors path="productName" cssStyle="color:red"/></td>
        </tr>
        <tr>
            <td>ProductQuantity</td>
            <td><form:input path="productQty" /></td>
            <td> <form:errors path="productQty" cssStyle="color:red"/></td>
        </tr>




         <tr>
            <td>Productprize</td>
            <td><form:input path="productPrice" /></td>
            <td><form:errors path="productPrice" cssStyle="color:red"/></td>
         </tr>

          <tr>
              <td>selectCategory</td>
              <td><form:select path="category.categoryId">
              <c:forEach items="${categories}" var="c"> 
             <form:option value="${c.categoryId}">${c.categoryName}</form:option>
              </c:forEach>
              </form:select></td>
           </tr>
           
           <%-- <tr>
              <td>select Supplier</td>
              <td><form:select path="supplier.supplierId">
              <c:forEach items="${suppliers}" var="s"> 
             <form:option value="${s.supplierId}">${s.supplierName}</form:option>
              </c:forEach>
              </form:select></td>
           </tr> --%>
           
			<tr>
			  <td>Upload image</td>
			  <td><form:input path="image" type="file"/>
			  </td>
		   </tr> 
 
           <tr>
               <td><input type="submit" value="submit"></td>
           </tr>
    </table>
    <c:out value="${Purchase.productName}"></c:out>
     <c:out value="${Purchase.productQty}"></c:out>
      <c:out value="${Purchase.productPrice}"></c:out>
        
</form:form>
</div>

<table>
<tr><th>ProductId</th><th>ProductName</th><th>ProductQty</th><th>Product Price</th><th>Product image</th>
</tr>



<c:forEach items="${ProductList}" var="Product">

<tr>
<td>${Product.productId}
</td>
<td>${Product.productName}
</td>
<td>${Product.productQty}
</td>
<td>${Product.productPrice}
</td>
<td><img src="<c:url value='/resources/images/${Product.productId}.png'></c:url>"height="30px" width="30px">
</td>


<security:authorize access="hasRole('ROLE_ADMIN')">
<td>
<a href="<c:url value="/admin/deleteProduct/${Product.productId}"></c:url>">Delete</a>
<a href="<c:url value="/admin/editProduct/${Product.productId}"></c:url>">Edit</a>
</td>
</security:authorize>

</tr>
</c:forEach>
</table>


<%-- <security:authorize access="hasRole('ROLE_USER')">
			Enter Quantity:<input type="number" min="1" max="${Product.productQty}" name="requestedQuantity">
			<button class="btn btn-primary btn-lg" type="submit"><span class="glyphicon glyphicon-shopping-cart" ></span>Add To Cart</button>
			</security:authorize> --%>


</body>
</html>