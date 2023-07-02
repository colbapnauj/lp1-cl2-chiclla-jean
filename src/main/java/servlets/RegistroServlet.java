package servlets;

import modelo.SubjectModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import entidades.Subject;

/**
 * Servlet implementation class RegistroServlet
 */
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String type = request.getParameter("type");
    	
    	switch (type) {
    	case "list": listSubjects(request, response); break;
    	case "register": registerSubject(request, response); break;
    	case "edit": editSubject(request, response); break;
    	case "delete": deleteSubject(request, response); break;
    	default:
    		request.setAttribute("mensaje", "Ocurrió un problema");
    		request.getRequestDispatcher("subject.jsp").forward(request,  response);
    		
    	}
    }
    
    protected void listSubjects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	SubjectModel subjectModel = new SubjectModel();
    	
    	List<Subject> data = subjectModel.listSubject();
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("subject.jsp").forward(request, response);
    }
    
    protected void getSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String idSubject = request.getParameter("id");
    	
    	SubjectModel subjectModel = new SubjectModel();
    	
    	Subject subject = subjectModel.getSubject(idSubject);
    	List<Subject> data = subjectModel.listSubject();
    	
    	request.setAttribute("subjectData", data);
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("subject2.jsp").forward(request, response);
    }
    
    protected void registerSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO
    }
    
    protected void editSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO
    }
    
    protected void deleteSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO
    }
    
    

}
