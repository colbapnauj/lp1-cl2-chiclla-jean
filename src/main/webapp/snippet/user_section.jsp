
<%@ page import="entidades.Cliente" %>

<%

	Cliente userSectionCliente = (Cliente) request.getAttribute("dataCliente");

%>

<nav class="navbar bg-body-tertiary">
  <form class="container-fluid">
  	<div class="input-group">
  		<span>  <%=userSectionCliente .getNombresApellidos() %></span>
  	</div>
    <div class="input-group">
      <span class="input-group-text" id="basic-addon1">@</span>
      <input type="text" value="<%=userSectionCliente .getEmail() %>" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" disabled>
    </div>
  </form>
</nav>