<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.col{
		color:blue;
		background-color:  yellow;
		padding:5px;
	}
</style>
</head>
<body>
	
	<h1>Demo to show data passed from servlet</h1>
	<p><%= request.getAttribute("msg")%></p>
	<p><%= request.getAttribute("colors")%></p>
	
	<!--  JSP Expression Language -->
	<p>message : ${msg }</p>
	<p>Colors : ${colors }</p>
	<%-- <%
		List<String> mycolors =  (List<String>)request.getAttribute("colors");
		for(String color:mycolors){
			out.println("<p class='col'>"+color.toUpperCase()+"</p>");	
		}
	%> --%>
	<%
		List<String> mycolors =  (List<String>)request.getAttribute("colors");
		for(String color:mycolors){
	%>
		<p class='col'><%= color.toUpperCase() %></p>
	<%} %>
	
	<h2>For loop using Tag LIbrary</h2>
	
	<core:forEach items="${colors }" var="color">
		<p class='col'>${color.toUpperCase()}</p>
	</core:forEach>

</body>
</html>