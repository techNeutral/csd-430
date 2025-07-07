<%--
Brett Fuller
CSD-430 Assignment 5 and 6
6/22/2025
This is the JSP page that creates the table. It get's messages from the bean file that notifies the user on success
or failure of the table creation.
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>CSD-430 Movies</title>
	<link href="style.css" type="text/css" rel="stylesheet" >
	</head>
	<body>
		<header>
			<h1>Brett Fuller CSD-430 Assignment 5 and 6</h1>
		</header>
		<jsp:useBean id='bean' class='myMovieBean.MyMovieBean'></jsp:useBean>
	
		<div id=container>
		<h2>Oscar Winners - Table Creation</h2>
	    
	    <%
		 
		  try{
			  
			  out.print(bean.createTable());
		  }
		  catch(Exception e){
			  out.print("Exception occurred");
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