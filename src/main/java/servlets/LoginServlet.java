package servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.DAOFactory;
import entidades.Usuario;
import interfaces.AuthInterface;
import listeners.SessionProject;
import util.Constantes;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	String type = req.getParameter("type");
    	
    	if (type.equals("login")) {
    		String correo = req.getParameter("txtCorreo");
    		String clave = req.getParameter("txtPass");
    		
    		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
    		AuthInterface dao = daoFactory.getAuth();
    		
    		Usuario usuario = dao.verificarInicioSesion(correo, clave);
    		if (usuario != null) {
    			SessionProject sessionProject = new SessionProject();
    			sessionProject.saveSessionTimeOut(req, 30);
    			sessionProject.saveSessionString(req, Constantes.NAME, usuario.getNombre());
    			sessionProject.saveSessionString(req, Constantes.LASTNAME, usuario.getApellidos());
    			sessionProject.saveSessionString(req, Constantes.EMAIL, usuario.getEmail());
    			sessionProject.saveSessionString(req, Constantes.ROL, usuario.getRol());
    			resp.sendRedirect("home.jsp");
    		} else {
    			req.setAttribute("mensaje", "Error en usuario y/o clave");
    			req.getRequestDispatcher("index.jsp");
    		}
    	} else if (type.equals("logout")) {
    		SessionProject sessionProject = new SessionProject();
    		sessionProject.invalidateSession(req);
    		resp.sendRedirect("index.jsp");
    	}
    }
}
