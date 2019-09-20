<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   

<html>

<body>
<h2>HI WELCOME TO E-COMMERCE</h2>
  <%-- <jsp:forward page="WEB-INF/views/views.jsp"></jsp:forward>  --%>
  <%-- <jsp:forward page="WEB-INF/views/supplier.jsp"></jsp:forward>  --%>

 <%--<a href ="<c:url value='/admin/views'></c:url>">Category</a>
<a href=  "<c:url value='product'></c:url>">Product</a>
<a href=  "<c:url value='supplier'></c:url>">Supplier</a>          --%>


<%-- <a href=  "<c:url value='registration'></c:url>">REGISTRATION</a>
<a href=  "<c:url value='login'></c:url>">LOGIN</a>
<!-- <a href=  "WEB-INF/views/registration.jsp">aboutus</a> -->
 <%-- <a href=  "<c:url value='aboutus'></c:url>">aboutus</a> --%>

 <%--<a href=  "<c:url value='cart'></c:url>">CART</a>

   <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>   --%>
  
  <jsp:forward page="/WEB-INF/views/home.jsp"></jsp:forward> 

</body>
</html>
