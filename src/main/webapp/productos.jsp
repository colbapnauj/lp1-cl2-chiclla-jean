<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="snippet/header.jsp" %>
<title>Productos</title>
</head>
<body>

	<%@ include file="snippet/nav_main.jsp" %>
	<%@ include file="snippet/user_section.jsp" %>

	<div class="container">
	
		<%@ page import="entidades.Producto" %>
		<%@ page import="java.util.List" %>
		
		<%
			List<Producto> listaProductos = (List<Producto>) request.getAttribute("dataProductos");
		%>
		
		<div class="row mt-4">
		
			<%				
			if (listaProductos != null) {
				for (Producto item: listaProductos) {
			%>		
						
				<div class="col-lg-6 py-1">
					<div class="card" style="width: 27rem;">
						<div class="row">
							<div class="col-6">
						<img src="<%=item.getUrlFoto() %>" class="card-img-top" alt="Foto de Producto">
						</div>
	  					<div class="col-6 card-body">
	    					<h5 class="card-title"><%=item.getNombre() %></h5>
	    					<p class="card-text">S/. <%=item.getPrecio() %></p>
	    					<span><%=item.getPromedioRating() %></span>
	    					<span>|</span>
	    					<span><%=item.getCantidadCalificaciones() %></span>
	    					
	    					<form action="ProductoServlet" method="post" accept-charset="UTF-8">
				
								<input type="hidden" name="type" value="info" />
								<input type="hidden" name="idProducto" value="<%=item.getIdProductoString()  %>">
								
								<input type="submit" class="btn btn-primary" value="Detalles" />
							</form>
					
					
	  					</div>
						</div>
					</div>
				
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