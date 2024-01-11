<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>ADMIN SIGNUP</h1>

<form action="adminsignup" method="post">

	<label for="aid">Admin ID:</label>
	<input type="number" name="adminid" id="aid"><br><br>
	<label for="aname">Admin Name:</label>
	<input type="text" name="adminname" id="aname"><br><br>
	<label for="acontact">Admin Contact:</label>
	<input type="tel" name="admincontact" id="acontact"><br><br>
	<label for="aemail">Admin Email:</label>
	<input type="email" name="adminemail" id="aemail"><br><br>
	<label for="apassword">Admin Password:</label>
	<input type="password" name="adminpassword" id="apassword"><br><br>
	<input type="submit">
	
</form>

</body>
</html>