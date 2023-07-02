<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../snippet/header.jsp" %>
<meta charset="ISO-8859-1">
<title>Subjects</title>

</head>
<body>
	
	<%@ page import="entidades.Subject" %>
	<%@ page import="java.util.List" %>
	
	<%@ include file="../../snippet/nav_main.jsp" %>

	<div class="container">
		<div class="row">
			<div class="col-6 col-sm-4">
				
			</div>
			
			<div class="col-6 col-sm-7">
				<h3>Cursos Disponibles</h3>
				
				<table class="table">
					<thead class="table">
						<tr>
							<th>Id</th>
							<th>C�digo</th>
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
								<img alt="" src="../img/ic_info.svg" width="20" height="20" title="Editar" />
							</a>
							
							<a href="/ProyectoImplementacion/SubjectServlet?type=delete&id=<%=item.getId()%>">
								<img alt="" src="../img/ic_delete.svg" width="20" height="20" title="Eliminar" />
							</a>
						</td>
					</tr>
					
					<%
						}
					}
					%>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>