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
		<br />
		<div class="col-lg-6">
			<form action="LoginLEServlet" method="post" id="id_form">
				<input type="hidden" name="type" value="Login" />
				<div class="form-group">
					<label>Correo</label>
					<input class="form-control" type="text" name="txtCorreo" />
				</div>
				
				<div class="form-group">
					<label>Contraseña</label>
					<input class="form-control" type="password" name="txtPass" />
				</div>
				
				<input type="submit" class="btn btn-primary" name="validateBtn" value="Enviar Datos" />
			</form>
			
			<br />
			
			<%
			String mensaje = (String) request.getAttribute("mensaje");
			if (mensaje != null) {
			%>
				<div class="alert alert-danger">
					<strong>Error!</strong> <%=mensaje %>
				</div>
			<%
			}
			%>
			
		</div>
	
	</div>

</body>
</html>