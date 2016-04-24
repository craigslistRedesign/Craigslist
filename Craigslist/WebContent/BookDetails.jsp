<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <title>Book Details</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="bootstrap.css">
  <link rel="stylesheet" href="boot_override.css">
  <script src="jquery.js"></script>
  <script src="bootstrap.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div>
    
    <div class = "col-sm-8 text-left">
<%@ page language="java" %>
<%@ page import = "com.listings.*"%>
<%@ page import = "java.util.*"%>

<jsp:useBean id ="listing" class ="com.listings.Listing" scope ="request"/> 

<% listing = (Listing)session.getAttribute("Listing");	%>

<h1>Book Details</h1>
<div class="thumbnail" >
<img src="./images/<%=listing.getImage()%>" alt="unavailable" style="width:140px;height:180px">
<h4>Title: <%= listing.getTitle() %></h4>
<h4>Description: <%= listing.getDescription() %></h4>
<h4> Category: <%= listing.getCategory() %></h4>
<h4> Sub-category: <%= listing.getSubcategory() %></h4>

</div>
  </div>
  <div class="col-sm-2 sidenav">
      <div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div>
    </div>
</div>	
    
  </div>
  
  <jsp:include page="footer.jsp"/>

</body>
</html>
