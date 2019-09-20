<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
 
 
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1"> 
<meta name="viewport" content="width=device-width,initial-scale=1">
<%-- <link rel="stylesheet" href="<c:url value='/resources/css/navbar.css'></c:url>"> --%>

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- JQuery -->
<!--     <script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>   -->
   <!--  <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
     <link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet"> -->
     
     
    <!-- <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <link href="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js" rel="stylesheet"> -->
    
    
    
    <link rel="stylesheet" href="//cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css"/>
    <!-- <script src="//code.jquery.com/jquery-1.11.3.min.js"></script> -->
    <script src="//cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>

   
   <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
  
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
   

    
    
<!-- <link href="frontend/recources/css_style/styles.css" rel="stylesheet"> -->
<!-- <link rel="stylesheet" href="/resources/css_style/styles.css">  -->
<!-- <link href="https://fonts.googleapis.com/css?family=Chilanka&display=swap" rel="stylesheet"> -->

<title>header page</title>


</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
				<a href="" class="navbar-brand"><img src="<c:url value='/WEB-INF/resources/images/wall.jpg'></c:url>" alt="ES" height="100px" width="100px"></a>
			<button type="button" class="navbar-toggle collapsed" 
   data-toggle="collapse" data-target="#navbardemo" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
			</div> 
			<div class="collapse navbar-collapse" id="navbardemo">
			<ul class="nav navbar-nav">
				<li><a href='<c:url value='/home'></c:url>' class="fontSize">Home</a></li>
				<%-- <li><a href='<c:url value='/views'></c:url>' class="fontSize">Category</a></li>
				<li><a href='<c:url value='/supplier'></c:url>' class="fontSize">Supplier</a></li>
				<li><a href=  "<c:url value='product'></c:url>">Product</a></li> --%>
				<li><a href="<c:url value='/aboutus'></c:url>" >About Us</a></li>
				<li><a href="<c:url value='/all/getallproducts'></c:url>">Browse all products</a>
				
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Select By Category<span class="caret"></span></a>
					
				<ul class="dropdown-menu">
				<c:forEach items="${categoriess}" var="category">
				<li><a href="<c:url value='/all/searchByCategory?searchCondition=${category.categoryName }'></c:url>">${category.categoryName }</a>
				</li>
				
				</c:forEach>
				<li>
				<a href="<c:url value='/all/searchByCategory?searchCondition=All'></c:url>">All</a>
				</li>
				</ul>
			   </li>
			  
			   <security:authorize access="hasRole('ROLE_ADMIN')">
			   <li><a href="<c:url value='/admin/views'></c:url>">Add Category</a></li>
			    <li><a href="<c:url value='/admin/supplier'></c:url>">Add Supplier</a></li>
			     <li><a href="<c:url value='/admin/product'></c:url>">Add Product</a></li>
				</security:authorize>    
			   
			   <security:authorize access="hasRole('ROLE_USER')">
			   <li><a href="<c:url value='/cart/getcart'></c:url>"><span class="glyphicon glyphicon-shopping-cart"></span>(${cartSize})</a></li>
			   </security:authorize>
			   
			   <c:if test="${pageContext.request.userPrincipal.name==null }">
				<li><a href="<c:url value='/registration'></c:url>">Sign Up</a></li>
				<li><a href="<c:url value='/login'></c:url>">Sign In</a></li>
				</c:if>
				
				<c:if test="${pageContext.request.userPrincipal.name!=null }">
				<li><a href="#">Welcome ${pageContext.request.userPrincipal.name }</a></li>
				 <li><a href="<c:url value='/j_spring_security_logout'></c:url>">Sign out</a></li> 
			    </c:if>
			</ul>
			</div>
         </div>	
		</nav>
	

</body>
</html>