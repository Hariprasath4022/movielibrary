<%@page import="java.util.Base64"%>
<%@page import="dto.Movie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	table,th,td{
		border: 1px solid black;
		border-collapse: collapse;
		padding:5px;
		text-align: center;
	}
	th{
		font-size: x-large;
		background-color: darksalmon;
		padding: 10px;
	}
	td{
		font-size: larger;
		background-color: lightcyan;
		font-family: sans-serif;
	}
	table{
		margin-left: 210px;
	}
	body{
		background-color: ivory;
	}
	h1{
		color: crimson;
	}
	#addmovie{
		background-color: blue;
		color: white;
		text-decoration: none;
		padding: 10px;
	}
</style>
</head>
<body>

<h1>Welcome OnBoard !!!</h1>

<% List<Movie> mov=(List)request.getAttribute("movies");%>
<table>
	<thead>
		<tr>
			<th>Movie Id</th>
			<th>Movie Name</th>
			<th>Movie Price</th>
			<th>Movie Ratings</th>
			<th>Movie Genre</th>
			<th>Movie Language</th>
			<th>Movie Image</th>
			<th>Delete</th>
			<th>Edit</th>
		</tr>
	</thead>
	<%for(Movie m:mov){%>
		
			<tr>
				<td><%=m.getMovieid() %></td>
				<td><%=m.getMoviename() %></td>
				<td><%=m.getMovieprice() %></td>
				<td><%=m.getMovierating() %></td>
				<td><%=m.getMoviegenre() %></td>
				<td><%=m.getMovielanguage() %></td>
				<%String base64image=new String(Base64.getEncoder().encode(m.getMovieimage())); %>
				<td><img src="data:image/jpeg;base64,<%=base64image%>" height="150px" width="150px"></td>
				<td><a href="deletemovie?movieid=<%=m.getMovieid()%>">Delete</a></td>
				<td><a href="editmovie?movieid=<%=m.getMovieid()%>">Edit</a></td>
			</tr>
			<%}%>
		
</table>

<a href="addmovie.jsp" id="addmovie">Add Movie</a>

</body>
</html>