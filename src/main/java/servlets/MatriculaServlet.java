package servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import entidades.Subject;
import entidades.Matricula;
import entidades.DetalleMatricula;

public class MatriculaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MatriculaServlet() {
        super();
    }

    protected void matricular(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	int idEstudiante = (int) req.getSession().getAttribute("idUsuario");
    	Subject subject = (Subject) req.getSession().getAttribute("dataSubject");
    	double total = (double) req.getSession().getAttribute("total");
    	
    	DetalleMatricula detalleMatricula = new DetalleMatricula();
    	detalleMatricula.setIdCurso(Integer.parseInt(subject.getId()));
    	detalleMatricula.setPrecio(total);
    	
    	req.getSession().setAttribute("matricula", detalleMatricula);
    	req.getSession().setAttribute("estudiante", idEstudiante);
    	
    	resp.sendRedirect("matriculaConfirmar.jsp");
    	
    	
    }

}
