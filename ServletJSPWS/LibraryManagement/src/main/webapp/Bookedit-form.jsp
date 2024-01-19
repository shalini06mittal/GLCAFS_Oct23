<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
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

<title>Save Book</title>
</head>

<body>

	<div class="container">

		<h3>Book Directory</h3>
		<hr>

		<p class="h4 mb-4">Book</p>

		<form action="/LibraryManagement/books/edit" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" />

			<div class="form-inline">
				<input type="text" name="name" 
					class="form-control mb-4 col-4" placeholder="Name">



			</div>

			<div class="form-inline">

				<input type="text" name="category" 
					class="form-control mb-4 col-4" placeholder="Category">



			</div>

			<div class="form-inline">

				<input type="text" name="author"
					class="form-control mb-4 col-4" placeholder="Author">



			</div>

			<button type="submit" class="btn btn-info col-2">Update</button>

		</form>

		<hr>
		<a href="/LibraryManagement/books/list">Back to Books List</a>

	</div>
</body>

</html>










