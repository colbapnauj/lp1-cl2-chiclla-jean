package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.SubjectModel;

import java.io.IOException;
import java.util.List;

import entidades.Subject;

/**
 * Servlet implementation class RedirectServlet
 */
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String servletPath = request.getServletPath().substring(1);
		request.getMethod();
		
		switch (servletPath) {
		case "cursos": 
			manageSubjecRoutes(request, response);
		}
		
		System.out.println(servletPath);
		
		
	}
	
	protected void manageSubjecRoutes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pathInfo = request.getPathInfo().substring(1);
		System.out.println(pathInfo);
		switch (pathInfo) {
		case "lista": {
			SubjectModel subjectModel = new SubjectModel();
	    	
	    	List<Subject> data = subjectModel.listSubject();
	    	request.setAttribute("data", data);
	    	request.getRequestDispatcher("/views/subject/index.jsp").forward(request, response);
		}
		break;
		
		}
	}

}
