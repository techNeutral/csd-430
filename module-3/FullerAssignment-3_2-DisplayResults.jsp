<%--
Brett Fuller
CSD-430 Assignment 3.2
6/8/2025
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%--Link to CSS file --%>
	<link href="style.css" type="text/css" rel="stylesheet" >
	<title>Application Summary</title>
</head>
<%--Declare variables and get the values from the form --%>
<%
	String firstName = request.getParameter("first");
	String lastName = request.getParameter("last");
	String education = request.getParameter("education");
	String employer = request.getParameter("employer");
	String contact = request.getParameter("radioButton");
	
	
%>
<body>
	<header>
		<h1>Application Summary</h1>
	</header>
	<div id=container>
		<%--Table to store the data from the application --%>
		<table>
			<tbody>
				<%--Table row to display the results from the application form - First Name --%>
				<tr>
					<td>First Name:</td>
					<td><%= firstName %></td>
					
				</tr>
				<%--Table row to display the results from the application form - Last Name --%>
				<tr>
					<td>Last Name:</td>
					<td><%= lastName %></td>
					
				</tr>
				<%--Table row to display the results from the application form - Previous Employer --%>
				<tr>
					<td>Previous Employer:</td>
					<td><%= employer %></td>
					
				</tr>
				<%--Table row to display the results from the application form - Permission to contact employer --%>
				<tr>
					<td>Contact Permission:</td>
					<td><%= contact %></td>
					
				</tr>
				<%--Table row to display the results from the application form - Highest level of education --%>
				<tr>
					<td>Education:</td>
					<td><%= education %></td>
					
				</tr>
			</tbody>
		</table>
	</div>
	<footer>
            <p id="left">
                Fuller - 2025
            </p>
            <%--Link to return to the application --%>
            <p>
                <a href="./FullerAssignment-3-2-Form.jsp">Back to Application Form</a>
            </p>           
        </footer>
</body>
</html>