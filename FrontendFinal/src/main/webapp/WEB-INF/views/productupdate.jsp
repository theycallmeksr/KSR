<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
 
  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>product update</title>
</head>
<body>

<c:url value="/admin/updateproduct" var="url"></c:url>
  <form:form modelAttribute="Product" action="${url}" method="post" enctype="multipart/form-data">    <!-- enctype="multipart/form-data" > -->
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
           
           <tr>
              <td>select Supplier</td>
              <td><form:select path="supplier.supplierId">
              <c:forEach items="${suppliers}" var="s"> 
             <form:option value="${s.supplierId}">${s.supplierName}</form:option>
              </c:forEach>
              </form:select></td>
           </tr>
           
           <tr>
			  <td>Upload image</td>
			  <td><form:input path="image" type="file"/>
			  </td>
		   </tr>

           <tr>
               <td><input type="submit" value="submit"></td>
           </tr>
    </table>

</form:form>





</body>
</html>