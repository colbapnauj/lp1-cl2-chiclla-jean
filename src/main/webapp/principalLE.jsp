<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<%@ include file="snippet/nav_main.jsp" %>
		
		<br />
		<div class="col-lg-6 jumbotron">
			<h2>Bienvenido ${mensaje}</h2>
		</div>
		
		<div class="col-lg-6">
			<h3>Cursos Virtuales</h3>
			<p>Plataforma de cursos online</p>
		</div>
	</div>

</body>
</html>