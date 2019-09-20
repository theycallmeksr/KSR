<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>registration here</title>
</head>
<body>

<div class="container">

  <c:url value="/all/registercustomer" var="url"></c:url>
  <form:form modelAttribute="customer" action="${url}" id="form">
    <br>
    <b>USER DETAILS</b><br>
        <br>
            <form:hidden path="id"/>
       
              <form:label path="firstname">Enter Firstname</form:label>  
            <form:input path="firstname" id="firstname"/>                          &nbsp; &nbsp;  &nbsp; &nbsp;
            
              <form:label path="lastname">Enter lastname</form:label>          
            <form:input path="lastname" id="lastname"/>                                  &nbsp; &nbsp;  &nbsp; &nbsp;
            
              <form:label path="phonenumber">Enter Phonenumber</form:label>
            <form:input path="phonenumber" id="phonenumber"/>
              
   <br>  
<hr>
<br>   <br>
<b>LOGIN CREDENTIALS</b><br>
<br>

  <form:label path="user.email">Enter Email</form:label>
  <form:input path="user.email" id="email" type="email"/>          &nbsp; &nbsp;  
  <span style="color:red">${error}</span>                                               &nbsp; &nbsp;  &nbsp; &nbsp;
  <form:label path="user.password">Enter Password</form:label>
  <form:input path="user.password" id="password" type="password"/>
 <hr> 
  <br>   <br>
 
 <b>BILLING ADDRESS</b><br>   
 <br> 
<pre>
  <form:label path="billingaddress.appartmentnumber">Enter apartmentnumber</form:label>
  <form:input path="billingaddress.appartmentnumber" id="billingaddress.appartmentnumber"/>         &emsp;
  
   <form:label path="billingaddress.streetname">Enter StreetName</form:label>
  <form:input path="billingaddress.streetname" id="billingaddress.streetname"/>                    &emsp;
  
   <form:label path="billingaddress.city">Enter City</form:label>
  <form:input path="billingaddress.city" id="billingaddress.city"/>                                      &emsp;
  
   <form:label path="billingaddress.state">Enter State</form:label>
  <form:input path="billingaddress.state" id="billingaddress.state"/>                               &emsp;
  
   <form:label path="billingaddress.country">Enter Country</form:label>
  <form:input path="billingaddress.country" id="billingaddress.country"/>                   &emsp;     &emsp;
  
   <form:label path="billingaddress.zipcode">Enter Zipcode</form:label>
  <form:input path="billingaddress.zipcode" id="billingaddress.zipcode"/> 
 </pre>
 <hr>     <br>
    <b>SHIPPING ADDRESS</b><br>
    <pre>
	<form:label path="shippingaddress.appartmentnumber">Enter Apartment Number</form:label> <form:input path="shippingaddress.appartmentnumber" id="shippingaddress.appartmentnumber"/>     <form:label path="shippingaddress.streetname">Enter Street Name</form:label> <form:input path="shippingaddress.streetname" id="shippingaddress.streetname"/>	<form:label path="shippingaddress.city">Enter City</form:label> <form:input path="shippingaddress.city" id="shippingaddress.city"/>
  
  
	<form:label path="shippingaddress.state">Enter State</form:label> <form:input path="shippingaddress.state" id="shippingaddress.state"/>     <form:label path="shippingaddress.country">Enter Country</form:label> <form:input path="shippingaddress.country" id="shippingaddress.country"/>     <form:label path="shippingaddress.zipcode">Enter Zipcode</form:label> <form:input path="shippingaddress.zipcode" id="shippingaddress.zipcode"/>
    </pre>
     <br>
	&ensp;&ensp;   <input type="submit" value="register" style="background-color:light-grey;">
     
     
     </form:form> 
     
     
     
           
</div>


</body>
</html>