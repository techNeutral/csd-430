<%--
Brett Fuller
CSD-430 Assignment 4.2
6/15/2025
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%--Link to CSS file --%>
	<link href="style.css" type="text/css" rel="stylesheet" >
	<title>Application Summary w/ beans</title>
</head>

<body>
	<header>
		<h1>Application Summary with JavaBeans</h1>
	</header>
	<%-- Set up the jsp file to use the JavaBean I created --%>
	<jsp:useBean id="bean" class='fullerAssignment_4_2_Bean.FullerAssignment_4_2_Bean'></jsp:useBean>
	<%--Set values in the bean by and getting the values from the form --%>
	<jsp:setProperty name='bean' property='firstName' value='<%= request.getParameter("first") %>' />
	<jsp:setProperty name='bean' property='lastName' value='<%= request.getParameter("last") %>' />
	<jsp:setProperty name='bean' property='education' value='<%= request.getParameter("education") %>' />
	<jsp:setProperty name='bean' property='employer' value='<%= request.getParameter("employer") %>' />
	<jsp:setProperty name='bean' property='contact' value='<%= request.getParameter("radioButton") %>' />
	
	<div id=container>
		<%--Table to store the data from the application --%>
		<table>
			<tbody>
				<%--Table row to display the results from the application form that are stored in the bean - First Name --%>
				<tr>
					<td>First Name:</td>
					<td><jsp:getProperty name='bean' property='firstName'/></td>
					
				</tr>
				<%--Table row to display the results from the application form that are stored in the bean - Last Name --%>
				<tr>
					<td>Last Name:</td>
					<td><jsp:getProperty name='bean' property='lastName'/></td>
					
				</tr>
				<%--Table row to display the results from the application form that are stored in the bean - Previous Employer --%>
				<tr>
					<td>Previous Employer:</td>
					<td><jsp:getProperty name='bean' property='employer'/></td>
					
				</tr>
				<%--Table row to display the results from the application form that are stored in the bean - Permission to contact employer --%>
				<tr>
					<td>Contact Permission:</td>
					<td><jsp:getProperty name='bean' property='contact'/></td>
					
				</tr>
				<%--Table row to display the results from the application form that are stored in the bean - Highest level of education --%>
				<tr>
					<td>Education:</td>
					<td><jsp:getProperty name='bean' property='education'/></td>
					
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
                <a href="./FullerAssignment4_2-Form.jsp">Back to Application Form</a>
            </p>           
        </footer>
</body>
</html>