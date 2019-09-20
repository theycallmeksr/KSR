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


<!--   <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
      Slide One - Set the background image for this slide in the line below
      <div class="carousel-item active" style="background-image: resources/images/bike1.png" alt="Watches" height="100%" width="100%">
        <div class="carousel-caption d-none d-md-block">
          <h2 class="display-4">First Slide</h2>
          <p class="lead">This is a description for the first slide.</p>
        </div>
      </div>
      Slide Two - Set the background image for this slide in the line below
      <div class="carousel-item" style="background-image:resources/images/Bugatti.jpg">
        <div class="carousel-caption d-none d-md-block">
          <h2 class="display-4">Second Slide</h2>
          <p class="lead">This is a description for the second slide.</p>
        </div>
      </div>
      Slide Three - Set the background image for this slide in the line below
      <div class="carousel-item" style="background-image: url('https://source.unsplash.com/szFUQoyvrxM/1920x1080')">
        <div class="carousel-caption d-none d-md-block">
          <h2 class="display-4">Third Slide</h2>
          <p class="lead">This is a description for the third slide.</p>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
  </div>
 -->


 <div class="container">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
           
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
                <li data-target="#myCarousel" data-slide-to="3"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="" src="resources/images/H11.jpg" alt="Watches" height="100%" width="100%">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>ESTORE WELCOMES YOU</h1>
                            <p>SHOWCASING DIFFERENT VARITIES TO YOUR LIKING</p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="" src="resources/images/H2.jpg" alt="Second slide" height="100%" width="100%">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>PURCHASE FROM YOUR HOME</h1>
                            <p>THE PRODUCT WILL BE AT YOUR DOOR STEP</p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="img-circle" src="resources/images/H3.jpg" alt="Third slide" height="100%" width="100%">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>ENJOY YOUR WORK, MAKE TIME RELAX TO SEE THE WORLD</h1>
                            <p>TIME IS OF THE ESSENCE!!!</p>
                        </div>
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" ></span>
                <span class="sr-only">Next</span>
            </a>
        </div>


</div>


</body>
</html>