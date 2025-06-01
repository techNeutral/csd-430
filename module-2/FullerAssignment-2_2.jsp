<%--
Brett Fuller
CSD-430 Assignment 2.2
5/31/2025
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CSD-430 Books</title>
<%-- Link to my style sheet. I chose to mirror the style I used in CSD-340 --%>
<link href="style.css" type="text/css" rel="stylesheet" >
</head>
<body>
	<header>
		<h1>Brett Fuller CSD-430 Assignment 2.2</h1>
	</header>
	<div id=container>
	<h2>Good Books</h2>
	<table border="1">
        <%--Table of some books I have enjoyed 
        all html headers are outside of the scriptlets 
        all data is displayed via Java scriptlets, though in this case the scriptlets are wholly unneccesary
        
        First I add the table headers with th then start a new row
        --%>
                       
            <tr>                                                    
	           	<th><%out.println("Title");%></th>       
	            <th><%out.println("Author");%></th>
	            <th><%out.println("Date");%></th>
            </tr>
	 	<%-- The next several segments are broken up into tr or table rows with 3 td or columns notated as
	 	table data with the data for the corresponding columns. I chose to sort them by release date --%>
	 	<tr>
	 		<td><%out.println("Three Body Problem");%></td>
	 		<td><%out.println("Liu Cixin");%></td>
	 		<td><%out.println("2008");%></td>
	 	</tr>
	 	
	 	<tr>
	 		<td><%out.println("Reamde");%></td>
	 		<td><%out.println("Neal Stephensen");%></td>
	 		<td><%out.println("2011");%></td>
	 	</tr>
	 	
	 	<tr>
	 		<td><%out.println("Station Eleven");%></td>
	 		<td><%out.println("Emily St. John Mandel");%></td>
	 		<td><%out.println("2014");%></td>
	 	</tr>
	 	
	 	<tr>
	 		<td><%out.println("Change Agent");%></td>
	 		<td><%out.println("Daniel Suarez");%></td>
	 		<td><%out.println("2017");%></td>
	 	</tr>
	 	
	 	<tr>
	 		<td><%out.println("Wind and Truth");%></td>
	 		<td><%out.println("Brandon Sanderson");%></td>
	 		<td><%out.println("2024");%></td>
	 	</tr>
	 	
    </table>
    </div>
    <footer>
            <p id="left">
                Fuller - 2025
            </p>           
        </footer> 
</body>
</html>