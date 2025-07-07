<%--
Brett Fuller
CSD-430 Assignment 7.2
6/29/2025
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" content="text/html; charset=UTF-8">
	<%--Link to css file --%>
	<link href="style.css" type="text/css" rel="stylesheet" >
	<title>Fuller Assignment 4.2</title>
</head>
<body>
	<jsp:useBean id='dbCRUD' class='myMovieBean.MyMovieBean'></jsp:useBean>
	<header>
		<h1>Application</h1>
	</header>
	<div id=container>
		<%--Create form and link to the results page, set method as post --%>
		<form name="Brett" action="FullerAssignment7_2_Add.jsp" method="post">
			<%--Created a table to hold the first few fields in the form --%>
	    	<h3><label for="Record You Wish To Change">Record You Wish To Update or Add:</label></h3><br><br>
	    	
	    	<label for="title">Movie Title:</label>
	    	<input type="text" id="title" name="title"><br><br>
	    	
	    	<label for="director">Director:</label>
	    	<input type="text" id="director" name="director"><br><br>
	    	
	    	<label for="year">Year:</label>
	    	<input type="text" id="year" name="year"><br><br>
	    	
	    	<label for=leadActor>Lead Actor:</label>
	    	<input type="text" id="leadActor" name="leadActor"><br><br>
	    	
	    	<label for="leadActress">Lead Actress:</label>
	    	<input type="text" id="leadActress" name="leadActress"><br><br>
	    	
	    	<input type='submit' value='Submit'>
    	
    	</form>
    	<%--Send values to bean and if the bean returns success display results if not say why --%>
    	<%
	    if(request.getMethod().equals("POST")){
	    	String message = dbCRUD.createRecord(request.getParameter("title"),
	    			request.getParameter("director"),
	    			Integer.parseInt(request.getParameter("year")),
	    			request.getParameter("leadActor"),
	    			request.getParameter("leadActress"));
	    	
	    	if(message.equals("Success")){
	    		out.print(dbCRUD.getOscarFromYear(Integer.parseInt(request.getParameter("year"))));

		    	out.println("<br />");

		     	out.print(dbCRUD.read());
	    	}
	    	
	    	else{
	    		out.print(message);
	    		out.println("<br />");
	    		
	    	}
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