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
	<meta charset="UTF-8" content="text/html; charset=UTF-8">
	<%--Link to css file --%>
	<link href="application.css" type="text/css" rel="stylesheet" >
	<title>Fuller Assignment 4.2</title>
</head>
<body>
	<header>
		<h1>Application</h1>
	</header>
	<div id=container>
		<%--Create form and link to the results page, set method as post --%>
		<form name="Brett" action="FullerAssignment-4_2-DisplayResults.jsp" method="post">
			<%--Created a table to hold the first few fields in the form --%>
			<table>
				<tbody>
					<%--Table row for free text entry - First name --%>
					<tr>
						<td>First Name:</td>
						<td><input type="text" name="first" value="" size="50"></td>
						
					</tr>
					<%--Table row for free text entry - Last Name --%>
					<tr>
						<td>Last Name:</td>
						<td><input type="text" name="last" value="" size="50"></td>
						
					</tr>
					<%--Table  row for free text entry - Previous employer --%>
					<tr>
						<td>Last Employer:</td>
						<td><input type="text" name="employer" value="" size="50"></td>
						
					</tr>
				</tbody>
			</table>
			<%--Radio button that asks the applicant if it is Ok to contact their previous employer --%>
			<label class=left>Can we contact your last employer: </label>
			<label>
	           Yes
	           <input name='radioButton' type='radio' value='Yes' checked='checked' />
	       </label>
	       <label>
	           No
	           <input name='radioButton' type='radio' value='No' />
	       </label>
	       <br />
	       <br />
	       <%--Selection box to select the highest level of education --%>
	       <label class=left>
		        Highest Level of Education:           
		    </label>
		    <select name="education" id="education">
		        <option selected='selected' value='College Graduate'>College Graduate</option>
		        <option value='Some College'>Some College</option>
		        <option value='High School Graduate or GED'>High School Graduate or GED</option>
		        <option value='No Degree'>No Degree (Did not Graduate High School)</option>
		    </select>
	       
	       <br />
	       <br />
	       	<%--Button to submit the form --%>
			<input type="submit" value="Submit" id="submit" class=left>
			<%--Button to clear the form --%>
			<input type="reset" value="Clear" id="clear">
		</form>
	</div>
	<footer>
            <p id="left">
                Fuller - 2025
            </p>          
    </footer>
	
</body>
</html>