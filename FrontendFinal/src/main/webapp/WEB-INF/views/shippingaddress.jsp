<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link type="text/css" rel="stylesheet" href='<c:url value="/resources/css/registration.css"></c:url>'>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
	<script type="text/javascript">
	
	$(document).ready(function(){
		$('#form').validate({
			rules:{
				"apartmentnumber":{required:true},
				"streetname":{required:true},
				"state":{required:true},
				"city":{required:true},
				"country":{required:true},
				"zipcode":{required:true,number:true}
			}
		})
	})
</script> 


<title>Insert title here</title>
</head>
<body>

<div class="container">
<c:url var="url" value="/cart/createorder"></c:url>
<form:form modelAttribute="shippingaddress" action="${url }" id="form">

<p align="center"><b>Shipping Address</b></p>	
<form:hidden path="id"/>

<form:label path="appartmentnumber">Enter Apartmentnumber</form:label>
<form:input path="appartmentnumber" id="apartmentnumber"/>


<form:label path="streetname">Enter Streetname</form:label>
<form:input path="streetname" id="streetname"/>


<form:label path="city">Enter city</form:label>
<form:input path="city" id="city"/>


<form:label path="state">Enter State</form:label>
<form:input path="state" id="state"/>


<form:label path="country">Enter country</form:label>
<form:input path="country" id="country"/>


<form:label path="zipcode">Enter zipcode</form:label>
<form:input path="zipcode" id="zipcode"/>


<button type="submit" >Next</button>
</form:form>
</div>

</body>
</html>