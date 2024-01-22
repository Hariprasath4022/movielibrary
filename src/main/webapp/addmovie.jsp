<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

	<form action="savemovie" method="post" enctype="multipart/form-data">
	
	<label for="mid">Movie ID:</label>
	<input type="number" name="movieid" id="mid"><br><br>
	<label for="mname">Movie Name:</label>
	<input type="text" name="moviename" id="mname"><br><br>
	<label for="mprice">Movie Price:</label>
	<input type="number" name="movieprice" id="mprice"><br><br>
	<label for="mrating">Movie Rating:</label>
	<input type="number" name="movierating" id="mrating"><br><br>
	<label for="mgenre">Movie Genre:</label>
	<input type="text" name="moviegenre" id="mgenre"><br><br>
	<label for="mlanguage">Movie Language:</label>
	<input type="text" name="movielanguage" id="mlanguage"><br><br>
	<label for="mimage">Movie Image:</label>
	<input type="file" name="movieimage" id="mimage"><br><br>
	<input type="submit">
	
	</form>
	
</body>
</html>