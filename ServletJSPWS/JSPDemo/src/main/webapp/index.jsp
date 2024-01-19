<!--  HTML COMMENT -->
<%-- JSP Comment - page directive --%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
</head>
<body>

	<h1>JSP DEMO</h1>
	<%-- JSP Expressions : out.println(); --%>
	<h2><%= "Shalini".toUpperCase()%></h2>
	<a href="home">Home Servlet</a>
	<%-- SCRIPLETS --%>
	<%
		out.println("<p>Hey there</p>");
		out.println("<p>"+LocalDate.now()+"</p>");
		for(int i=1;i<=10;i++)
		{
			out.println("<p>");
			out.println(i*i);
			out.println("</p>");
		}
	%>
	<form action="form.jsp" method="post">
	
		Name : <input type='text' name="username"/>
		<input type='submit'/>
	</form>
</body>
</html>