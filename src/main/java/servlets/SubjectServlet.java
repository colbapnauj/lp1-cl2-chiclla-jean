package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import modelo.SubjectModel;

import entidades.Subject;

public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		if (type == null) {
			listSubjects(request, response);
			return;
		}
		
    	
    	switch (type) {
    	case "list": listSubjects(request, response); break;
    	case "register": registerSubject(request, response); break;
    	case "info": getSubject(request, response); break;
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
    	
    	request.setAttribute("subjectData", subject);
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("views/subject/info.jsp").forward(request, response);
    }
	
	protected void registerSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Entradas
		String code = request.getParameter("txtCode");
		String name = request.getParameter("txtName");
		String level = request.getParameter("txtLevel");
		String teacher = request.getParameter("txtTeacher");
		
		// Creamos objecto
		Subject subject = new Subject();
		subject.setCode(code);
		subject.setName(name);
		subject.setLevel(level);
		subject.setTeacher(teacher);
		
		// Procesos
		SubjectModel model = new SubjectModel();
		int value = model.createSubject(subject);
		
		if (value == 1) {
			listSubjects(request, response);
		} else {
			request.setAttribute("mensaje", "Ocurrió un problema");
			request.getRequestDispatcher("subject.jsp").forward(request, response);
			
		}
    }
	
	protected void editSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Entradas
		String id = request.getParameter("txtId");
		String code = request.getParameter("txtCode");
		String name = request.getParameter("txtName");
		String level = request.getParameter("txtLevel");
		String teacher = request.getParameter("txtTeacher");
		
		// Creamos objecto
		Subject subject = new Subject();
		subject.setId(id);
		subject.setCode(code);
		subject.setName(name);
		subject.setLevel(level);
		subject.setTeacher(teacher);
		
		// Procesos
		SubjectModel model = new SubjectModel();
		int value = model.editSubject(subject);
		
		if (value == 1) {
			listSubjects(request, response);
		} else {
			request.setAttribute("mensaje", "Ocurrió un problema");
			request.getRequestDispatcher("subject.jsp").forward(request, response);
			
		}
    }
	
	protected void deleteSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idSubject = request.getParameter("id");
    	
    	SubjectModel subjectModel = new SubjectModel();
    	int value = subjectModel.deleteSubject(idSubject);
    	
    	if (value == 1) {
    		listSubjects(request, response);
    	} else {
    		request.setAttribute("mensaje", "Ocurrió un problema al intentar eliminar registro con id " + idSubject);
    		request.setAttribute("type", "list");
    		request.getRequestDispatcher("subject.jsp").forward(request, response);
    	}
    }
	
	

}
