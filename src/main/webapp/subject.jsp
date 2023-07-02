<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="snippet/header.jsp" %>
<meta charset="UTF-8">
<title>Subjects</title>

</head>
<body>
	
	<%@ page import="entidades.Subject" %>
	<%@ page import="java.util.List" %>
	
	<%@ include file="snippet/nav_main.jsp" %>

	<div class="container mt-3">
		<div class="row">
			<div class="col-6 col-lg=4">
				
			</div>
			
			<div class="col-6 col-sm-12 col-lg=8">
				<h3>Cursos Disponibles</h3>
				
				<table class="table">
					<thead class="table">
						<tr>
							<th>Id</th>
							<th>Código</th>
							<th>Nombre</th>
							<th>Nivel</th>
							<th>Profesor</th>
							<th>Acciones</th>
						</tr>
					</thead>
					
					<tbody>
					
					<%
					
					List<Subject> listSubject = (List<Subject>) request.getAttribute("data");
					
					if (listSubject != null) {
						for (Subject item: listSubject) {
						
					%>
					
					<tr>
						<td><%=item.getId() %></td>
						<td><%=item.getCode() %></td>
						<td><%=item.getName() %></td>
						<td><%=item.getLevel() %></td>
						<td><%=item.getTeacher() %></td>
						<td>
							<a href="SubjectServlet?type=info&id=<%=item.getId()%>">
								<img alt="" src="img/ic_info.svg" width="20" height="20" title="Editar" />
							</a>
							
							<a href="SubjectServlet?type=delete&id=<%=item.getId()%>">
								<img alt="" src="img/ic_delete.svg" width="20" height="20" title="Eliminar" />
							</a>
						</td>
					</tr>
					
					<%
						}
					} else {
						
					
					%>
					
					<tr>
						<td colspan="6">No se encontró registros</td>
					</tr>
					<%
					}
					%>
					
					</tbody>
				</table>
				
				<div class="mt-3">
			      	<div class="btn-group">
			      		
				      		<a class="btn btn-outline-success"
				      			href="/ProyectoImplementacion/views/subject/register.jsp"
				      			type="submit"
				      		>Registrar
				      		</a>
			      		
			      	</div> 
			     </div>
			     
			     <%
			     	if (request.getAttribute("mensaje") != null) {
			     		
			     %>
			     
			     <div class="alert alert-warning mt-3">
			     	<span><%=request.getAttribute("mensaje")%></span>
			     </div>
			     
			     <%
			     }
			     %>
			</div>
			
			<div class="col-6 col-sm-1">
				
			</div>
			
		</div>
	</div>

</body>
</html>