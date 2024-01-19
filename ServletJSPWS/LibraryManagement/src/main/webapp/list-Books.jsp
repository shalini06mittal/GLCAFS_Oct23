<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Books Directory</title>
</head>

<body>

	<div class="container">

		<h3>Books Directory</h3>
		<hr>

		

		<!-- Add a button -->
		<a href="/LibraryManagement/books/add"
			class="btn btn-primary btn-sm mb-3"> Add Book </a>
			
		
		
		<c:if test="${Books.size() == 0 }">
			<h3>No books added Yet!!</h3>
		</c:if>
		<c:if test="${Books.size() != 0 }">
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Name</th>
					<th>Category</th>
					<th>Author</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Books}" var="tempBook">
					<tr>
						<td><c:out value="${tempBook.name}" /></td>
						<td><c:out value="${tempBook.category}" /></td>
						<td><c:out value="${tempBook.author}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/LibraryManagement/books/edit?id=${tempBook.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a href="/LibraryManagement/books/delete?id=${tempBook.id}"
							class="btn btn-danger btn-sm"
							>
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>
		</c:if>

	</div>

</body>
</html>



