<%@page import="java.util.Base64"%>
<%@page import="dto.Movie"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%Movie m=(Movie)request.getAttribute("movies");%>

<form action="updatemovie" method="post" enctype="multipart/form-data">
	
	<label for="mid">Movie ID:</label>
	<input type="number" name="movieid" id="mid" value="<%=m.getMovieid()%>" readonly><br><br>
	<label for="mname">Movie Name:</label>
	<input type="text" name="moviename" id="mname" value="<%=m.getMoviename()%>"><br><br>
	<label for="mprice">Movie Price:</label>
	<input type="number" name="movieprice" id="mprice" value="<%=m.getMovieprice()%>"><br><br>
	<label for="mrating">Movie Rating:</label>
	<input type="number" name="movierating" id="mrating" value="<%=m.getMovierating()%>"><br><br>
	<label for="mgenre">Movie Genre:</label>
	<input type="text" name="moviegenre" id="mgenre" value="<%=m.getMoviegenre()%>"><br><br>
	<label for="mlanguage">Movie Language:</label>
	<input type="text" name="movielanguage" id="mlanguage" value="<%=m.getMovielanguage()%>"><br><br>
	<label for="mimage">Movie Image:</label>
	<input type="file" name="movieimage" id="mimage"><br><br>
	<input type="submit">
	
	<% String base64image=new String(Base64.getEncoder().encode(m.getMovieimage())); %>
	<img src="data:image/jpeg;base64,<%= base64image %>" height="150px" width="100px">
	
	</form>

</body>
</html>