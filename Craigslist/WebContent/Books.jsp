<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <title>Books</title>
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
    <h1>Books Listing</h1>
<%@ page language="java" %>
<%@ page import = "com.listings.*"%>
<%@ page import = "java.util.*"%>
<div class="row">
  
<jsp:useBean id ="listing" class ="com.listings.Listing" scope ="request"/> 

<% List<Listing> list = new ArrayList<Listing>();
   list = (ArrayList<Listing>)session.getAttribute("list");
	for(Listing li:list){
		listing = li; %>


<div class="col-md-4">
    <a href="CraigslistServlet?image=<%=listing.getImage()%>" class="thumbnail">
      <p><%= listing.getTitle() %></p>
      <img src="./images/<%=listing.getImage()%>" alt="unavailable" style="width:120px;height:150px">
      <p style="text-align:center">price: <%= listing.getCurrency() %><%= listing.getPrice() %></p>
    </a>
  </div>
	
<% }%>

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
