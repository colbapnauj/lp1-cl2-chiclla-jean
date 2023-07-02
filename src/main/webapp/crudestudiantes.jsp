<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="entidades.Estudiante" %>
<%@ page import="entidades.TipoDocumento" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="snippet/header.jsp" %>
<meta charset='utf-8'>
<title>CRUD Estudiante</title>
<style>
	html, body {
	  height: 100%;
	  margin: 0;
	}
	.wrapper {
		min-height: 100%;
		margin-bottom: -60px;
	}
	
	.footer {
	  	height: 60px;
	
	}
</style>
</head>
<body>

	<%@ include file="snippet/nav_main.jsp" %>

	<div class="wrapper">
	<div class="container">
		
		<br />
		<div class="row">
			<div class="col-6 col-sm-4">
				
				<%
					List<TipoDocumento> listDocumentos = (List<TipoDocumento>) request.getAttribute("dataDocumentos");
					Estudiante estudianteForm = (Estudiante) request.getAttribute("estudianteData");
				%>
				
				<% if(estudianteForm == null) {
				
				%>
					<h3>Registrar Estudiante</h3>
				<% } else {
					
				%>
					<h3>Editar Estudiante</h3>
				<%
				}
				%>
				
				
				<form action="EstudianteServlet2" method="post" accept-charset="UTF-8">
				
					<input type="hidden" name="type" value="register" />
					<input type="hidden" name="idEstudiante" value="<%=(estudianteForm!=null)? estudianteForm.getId():""%>">
					
					<div class="form-group">
						<label class="text-secondary">Nombres y Apellidos</label>
						<input class="form-control" type="text" name="txtNombres"
							value="<%=(estudianteForm!=null)?estudianteForm.getNombresApellidos():"" %>">
					</div>
					
					<div class="form-group">
						<label class="text-secondary">Tipo Documento</label>
						<select class="form-control" name="cboTipoDocumento">
							<%
							if (listDocumentos != null) {
								for (TipoDocumento item: listDocumentos) {
							
							%>
								<option value="<%=item.getId() %>" <%=((estudianteForm!=null)
									&& (item.getId().equals(estudianteForm.getTipoDocumento())))? "selected='selected'":""%>
									><%=item.getDocumento()%>
								</option>
								
							<%
								}
							}
							%>
							
						</select>
					</div>
					
					<div class="form-group">
						<label class="text-secondary">Nro Documento</label>
						<input class="form-control" type="text" name="txtNumeroDocumento"
							value="<%=(estudianteForm!=null)?estudianteForm.getDocumento():"" %>" />
					</div>
					
					<div class="form-group">
						<label class="text-secondary">Teléfono</label>
						<input class="form-control" type="text" name="txtTelefono"
							value="<%=(estudianteForm!=null)?estudianteForm.getTelefono():"" %>" />
					</div>
					
					<div class="form-group">
						<label class="text-secondary">Carrera</label>
						<input class="form-control" type="text" name="txtCarrera"
							value="<%=(estudianteForm!=null)? estudianteForm.getCarrera():"" %>" />
					</div>
					
					<br />
					<input type="submit" class="btn btn-primary" value=<%=(estudianteForm!=null)? "Actualizar": "Enviar Datos" %> />
					
				</form>
			
			</div>
			
			<div class="col-6 col-sm-7">
				<h3>Mantenedor Estudiantes</h3>
				
				<table class="table">
					<thead>
						<tr>
							<td>Id</td>
							<td>Nombres y Apellidos</td>
							<td>Tipo Documento</td>
							<td>Documento</td>
							<td>Carrera</td>
							<td>Acciones</td>
						</tr>
					</thead>
					
					<tbody>
					
						<%
						List<Estudiante> listEstudiante = (List<Estudiante>) request.getAttribute("dataEstudiantes");
						
						if (listEstudiante != null) {
							for (Estudiante item: listEstudiante) {
						%>
						
						<tr>
							<td><%=item.getId() %></td>
							<td><%=item.getNombresApellidos() %></td>
							<td><%=item.getDocumento() %></td>
							<td><%=item.getNumeroDocumento() %></td>
							<td><%=item.getCarrera() %></td>
							<td>
								<a href="EstudianteServlet2?type=info&idEstudiante=<%=item.getId()%>">
									<img alt="" src="img/ic_info.svg" width="20" height="20" title="Editar" />
								</a>
								
								<a href="EstudianteServlet2?type=delete&idEstudiante=<%=item.getId()%>">
									<img alt="" src="img/ic_delete.svg" width="20" height="20" title="Eliminar" />
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
		
		<div class="mt-3">
			<%@ include file="snippet/message_alert.jsp" %>
		</div>
		
		
	</div>
	
	</div>
	<footer class="footer text-center text-lg-start text-white" style="background-color: #1c2331">
			<div
		         class="text-center p-3"
		         style="background-color: rgba(0, 0, 0, 0.2)"
		         >
		      Lenguaje de Programación I - Jean Chiclla - 2023
		      
		      <a class="text-white" href="https://abcorp.net.pe/">abcorp.net.pe</a>
		    </div>
	</footer>

</body>
</html>