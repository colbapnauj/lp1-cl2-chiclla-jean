<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
if (request.getAttribute("mensaje") != null) {
%>

<div class="alert alert-warning mt-3">
	<span><%=request.getAttribute("mensaje")%></span>
</div>

<%
}
%>