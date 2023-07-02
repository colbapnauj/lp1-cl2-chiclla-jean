<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="entidades.Subject" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../../snippet/header.jsp" %>
<meta charset="UTF-8">
<title>Registro de Cursos</title>
</head>
<body>

	<%@ include file="../../snippet/nav_main.jsp" %>

	<div class="container mt-3">
		<div class="row">
			<div class="col-lg-2"></div>
			
			<div class="col-lg-8">
				<h3>Registrar Cursos</h3>
				
				<%
					Subject subject = (Subject) request.getAttribute("data");
				%>
				
				<form action="/ProyectoImplementacion/SubjectServlet?type=register" method="post" accept-charset="UTF-8">
				
					<input type="hidden" name="type" value="register">
					<input type="hidden" name="idSubject" value="<%=(subject!=null)? subject.getId():"" %>">
					
					<div class="form-group">
						<label>Código</label>
						<input class="form-control" type="text" name="txtCode" value="<%=(subject!=null) ? subject.getCode():"" %>" />
					</div>
					
					<div class="form-group">
						<label>Nombre</label>
						<input class="form-control" type="text" name="txtName" value="<%=(subject!=null) ? subject.getName():"" %>" />
					</div>
					
					<div class="form-group">
						<label>Nivel</label>
						<input class="form-control" type="text" name="txtLevel" value="<%=(subject!=null) ? subject.getLevel():"" %>" />
					</div>
					
					<div class="form-group">
						<label>Profesor</label>
						<input class="form-control" type="text" name="txtTeacher" value="<%=(subject!=null) ? subject.getTeacher():"" %>" />
					</div>
					
					<div class="btn-group mt-3" role="group" aria-label="Basic example">
						<input type="submit" class="btn btn-primary" value="Enviar Datos">
					</div>
				</form>
				
				<div class="btn-group mt-3" role="group">
					<a class="btn btn-warning" href="/ProyectoImplementacion/SubjectServlet">Listar</a>
				</div>
			</div>
			
			<div class="col-lg-2"></div>
		</div>
	</div>
</body>
</html>