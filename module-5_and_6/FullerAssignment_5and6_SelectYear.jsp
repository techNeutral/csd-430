<%--
Brett Fuller
CSD-430 Assignment 5 and 6
6/22/2025
 This is one of the JSP page that displays the data from the fuller_movies_data table. First it asks the user to select a year from a list of years that the oscars occurrred. From there it calls the 
 getOscarFromYear() method which returns a single entry of that year's best picture winner. It then calls the read() method from the javabean file which returns all results from the table. The results are shown in two 
 separate tables
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
	 <%
	    if(request.getMethod().equals("GET")){
	    	
	    	String value = bean.formGetPK("FullerAssignment_5and6_SelectYear.jsp");
	    	
	    	out.print(value);
	    	
	    }
	    %>

	    <%
	    if(request.getMethod().equals("POST")){
	    	
	    	out.print(bean.formGetPK("FullerAssignment_5and6_SelectYear.jsp"));

	    	String year = request.getParameter("Year");

	    	out.print(bean.getOscarFromYear(Integer.parseInt(year)));

	    	out.println("<br />");

	     	out.print(bean.read());
	    }
	    %>     
	    <a href="FullerAssignment_5and6_index.html">Return to Index</a> <br />
    </div>

    <footer>
            <p id="left">
                Fuller - 2025
            </p>      
            <p id="right">
	            	<a href="FullerAssignment_5and6_index.html">Index</a> <br />
            </p>     
        </footer> 
</body>
</html>