<%--
Brett Fuller
CSD-430 Assignment 1.2
5/31/2025
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Demo</title>
</head>
<body>
<h1>Brett Fuller</h1>
<h2>Table From M1_JSP_Example.zip - Table.jsp</h2>
<table border="1">
        <%--Java code courtesy of the example provided in class --%>
        <%
            for(int i = 0; i < 5; ++i){
                
                out.println("<tr>");
                
                for(int j = 0; j < 5; ++j){
                    
                    out.println("<td>");
        %>
        
        My Data i = <%= i + 1 %> j =  <%= j + 1 %>
        
        <%            
                out.println("</td>");            
                }

            out.println("</tr>");
        }

    %>
    
    </table>
</body>
</html>