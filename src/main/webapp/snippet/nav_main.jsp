<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Instituto</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Cursos
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/ProyectoImplementacion/SubjectServlet">Listar</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="/ProyectoImplementacion/views/subject/register.jsp">Registrar</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/ProyectoImplementacion/EstudianteServlet2">Estudiantes</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled">Profesores</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled">Matrícula</a>
        </li>
        
      </ul>
      
    </div>
  </div>
</nav>