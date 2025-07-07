<%--
Brett Fuller
CSD-430 Assignment 5 and 6
6/22/2025
 This is one of the JSP page that displays the data from the fuller_movies_data table. It calls the read() method from the javabean file
 which returns all results from the table.
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CSD-430 Movies</title>
<%-- Link to my style sheet. I chose to mirror the style I used in CSD-340 --%>
<link href="style.css" type="text/css" rel="stylesheet" >
</head>
<body>
	<header>
		<h1>Brett Fuller CSD-430 Assignment 5 and 6</h1>
	</header>
	<jsp:useBean id='bean' class='myMovieBean.MyMovieBean'></jsp:useBean>
	<div id=container>
	<h2>The Academy Awards Best Picture Winners</h2>
	<form name="Brett" action="FullerAssignment-4_2-DisplayResults.jsp" method="post">
	
	</form>
	<%
	 
	  try{
		  out.print(bean.read());
	  }
	  catch(Exception e){
		  out.print("Error");
	  }
  	 
  %>
  <a href="index.html">Return to Index</a> <br />     
    </div>
	
    <footer>
            <p id="left">
                Fuller - 2025
            </p>  
            <p id="right">
            	<a href="index.html">Index</a> <br />
            </p>         
        </footer> 
</body>
</html>