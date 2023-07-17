<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Producto" %>
<%@ page import="entidades.Cliente" %>
<%@ page import="entidades.Calificacion" %>
<%@ page import="java.util.List" %>

<%
	Producto producto = (Producto) request.getAttribute("dataProducto");
	Cliente cliente = (Cliente) request.getAttribute("dataCliente");
	List<Calificacion> calificaciones = (List<Calificacion>) request.getAttribute("dataCalificaciones");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="snippet/header.jsp" %>
<title><%=producto.getNombre() %></title>
<style>
	.rate {
    float: left;
    height: 46px;
    padding: 0 10px;
	}
	.rate:not(:checked) > input {
	    position:absolute;
	    top:-9999px;
	}
	.rate:not(:checked) > label {
	    float:right;
	    width:1em;
	    overflow:hidden;
	    white-space:nowrap;
	    cursor:pointer;
	    font-size:30px;
	    color:#ccc;
	}
	.rate:not(:checked) > label:before {
	    content: '★ ';
	}
	.rate > input:checked ~ label {
	    color: #ffc700;    
	}
	.rate:not(:checked) > label:hover,
	.rate:not(:checked) > label:hover ~ label {
	    color: #deb217;  
	}
	.rate > input:checked + label:hover,
	.rate > input:checked + label:hover ~ label,
	.rate > input:checked ~ label:hover,
	.rate > input:checked ~ label:hover ~ label,
	.rate > label:hover ~ input:checked ~ label {
	    color: #c59b08;
	}
</style>
</head>
<body>
	
	<%@ include file="snippet/nav_main.jsp" %>
	<%@ include file="snippet/user_section.jsp" %>
	
	<div class="container mt-3">
		<div class="row">
			<% if (calificaciones.isEmpty() || (!calificaciones.isEmpty()) && (calificaciones.get(0).getIdCliente() != cliente.getIdCliente())) { %>
			<div class="col-lg-6 py-1">
			<%
			} else {
			%>
			<div class="col-lg-12 py-1">
			<%
			}
			%>
				<div class="card m-auto" style="width: 27rem;">
					<div class="row">
						<div class="col-6">
					<img src="<%=producto.getUrlFoto() %>" class="card-img-top" alt="Foto de Producto">
					</div>
							<div class="col-6 card-body">
			  					<h5 class="card-title"><%=producto.getNombre() %></h5>
			  					<p class="card-text">S/. <%=producto.getPrecio() %></p>
			  					<span><%=producto.getPromedioRating() %></span>
			  					<span>|</span>
			  					<span><%=producto.getCantidadCalificaciones() %></span>
				
							</div>
					</div>
				</div>
			
			</div>
			<% if (calificaciones.isEmpty() || (!calificaciones.isEmpty()) && (calificaciones.get(0).getIdCliente() != cliente.getIdCliente())) { %>
			
				<div class="col-lg-6 py-1">
					<form action="CalificacionServlet" method="post" accept-charset="UTF-8">
						<input type="hidden" name="type" value="register" />
						<input type="hidden" name="idCliente" value="<%=cliente.getIdCliente() %>">
						<input type="hidden" name="idProducto" value="<%=producto.getIdProducto() %>">
						
						<h4>Registrar calificación</h4>
						
						<div class="form-check">
						  <input class="form-check-input" type="radio" name="rboTipoTexto" id="flexRadioDefault1" value="1" checked />
						  <label class="form-check-label" for="flexRadioDefault1">
						    Comentario
						  </label>
						</div>
						<div class="form-check">
						  <input class="form-check-input" type="radio" name="rboTipoTexto" id="flexRadioDefault2" value="2" />
						  <label class="form-check-label" for="flexRadioDefault2">
						    Sugerencia
						  </label>
						</div>
						
						<div class="form-floating">
					  		<textarea class="form-control" name="txtS" placeholder="Registre su comentario/sugerencia" id="floatingTextarea">Este producto es grandioso!</textarea>
					  		<label for="floatingTextarea">Comentarios</label>
						</div>
						
						<br />
						<h5>Rating</h5>
						
						<div class="rate">
						    <input type="radio" id="star5" name="rate" value="5" checked />
						    <label for="star5" title="text">5 stars</label>
						    <input type="radio" id="star4" name="rate" value="4" />
						    <label for="star4" title="text">4 stars</label>
						    <input type="radio" id="star3" name="rate" value="3" />
						    <label for="star3" title="text">3 stars</label>
						    <input type="radio" id="star2" name="rate" value="2" />
						    <label for="star2" title="text">2 stars</label>
						    <input type="radio" id="star1" name="rate" value="1" />
							<label for="star1" title="text">1 star</label>
						</div>
						  
						  
						<input type="submit" class="btn btn-primary" value="Calificar" />
						  
					</form>
				</div>
			</div>
		<%
			}
		%>
		
		<div class="row my-3">
			<% if (calificaciones.isEmpty()) { %>
				<div class="alert">No hay calificaciones registradas para este producto</div>
			<%
			} else {
				for (Calificacion item: calificaciones) {		
			%>
				<div class="row mt-3">
					<div class="col-2"></div>
					<div class="col-8 card py-3 px-3 mt-3">
						<div class="row">
							<div class="col">
								<p><%=item.getTexto() %></p>
								<div class="row">
									<div class="col"><p><%=item.getTipoTextoName() %></p></div>
									<div class="col"><p><%=item.getNombreCliente() %></p></div>
									<div class="col">
										<%
											for (int i = 0; i < item.getCalificacion(); i++) {
										%>
											<img src="img/yellow-star.png" width="15" height="15" alt="star" />
										<%
											}
										%>
									</div>
									<div class="col">
										<p><%=item.getFechaCalificacion() %></p>
									</div>
								</div>
							</div>
						</div>
						<% if (item.getIdCliente() == cliente.getIdCliente()) { %>
							<div class="row">
								<div class="col">
									<form action="CalificacionServlet" method="post" accept-charset="UTF-8">
					
									<input type="hidden" name="type" value="delete" />
									<input type="hidden" name="idProducto" value="<%=item.getIdProducto() %>" />
									<input type="hidden" name="idCalificacion" value="<%=item.getIdCalificacion() %>">
									
									<input type="submit" class="btn btn-danger" value="Eliminar" />
								</form>
								</div>
							</div>
						<% 
						}
						%>
					</div>
					<div class="col-2"></div>
				</div>
			
			<%
				}
			}
			%>		
		</div>
	</div>

	<%@ include file="snippet/footer.jsp" %>
</body>
</html>