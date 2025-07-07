<%--
Brett Fuller
CSD-430 Assignment 8.2
7/6/2025
 This JSP page uses the formUpdate() method fro my java bean to create a form that allows the user to update the record for a movie, then shows the record that was updated.
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
		<h1>Brett Fuller CSD-430 Assignment 8.2</h1>
	</header>
	<%-- call the java bean --%>
	<%-- --%>
	<jsp:useBean id='dbCRUD' class='myMovieBean.MyMovieBean'></jsp:useBean>
	<div id=container>
	<h2>The Academy Awards Best Picture Winners</h2>
	 <%
    if(request.getMethod().equals("GET")){
    	//get the form and populate the list of all current unique entries but still allow free text in all of them but the date.
    	String value = dbCRUD.formUpdate("FullerAssignment_8_2-Update.jsp");
    	
    	out.print(value);
    }
    %>
    
    <%
    if(request.getMethod().equals("POST")){
    	//query the year and set it to a variable instead of doing repeat queries
    	String movieYear = request.getParameter("year");
    	
    	//send the data from the form to the update record method in my java bean
    	dbCRUD.updateRecord(request.getParameter("title"),
    			request.getParameter("director"),
    			Integer.parseInt(movieYear),
    			request.getParameter("leadActor"),
    			request.getParameter("leadActress"));

    	
    	out.println("<br /><br />");
		
    	//print the record that has just been updated
		out.print(dbCRUD.getOscarFromYear(Integer.parseInt(movieYear)));
    	
    	out.println("<br /><br />");
    	
    	//out.print(dbCRUD.read());
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