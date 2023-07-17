package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import dao.DAOFactory;
import entidades.Calificacion;
import interfaces.CalificacionInterface;

@WebServlet("/CalificacionServlet")
public class CalificacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CalificacionServlet () {
		super();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		
		switch (type) {
		
		case "register": registrarCalificacion(req, resp); break;
		case "delete": borrarCalificacion(req, resp); break;
		default:
			req.setAttribute("mensaje", "Ocurrió un problema");
			req.getRequestDispatcher("404.jsp").forward(req,  resp);
		}
	}
	
	protected void registrarCalificacion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Entradas
		String idCliente = req.getParameter("idCliente");
		String idProducto = req.getParameter("idProducto");
		String tipoTexto = req.getParameter("rboTipoTexto");
		String txtS = req.getParameter("txtS");
		String rate = req.getParameter("rate");
		
		System.out.println(idCliente);
		System.out.println(idProducto);
		System.out.println(tipoTexto);
		System.out.println(txtS);
		System.out.println(rate);
		
//		// Creamos objecto
		Calificacion calificacion = new Calificacion();
		calificacion.setIdCliente(Integer.parseInt(idCliente));
		calificacion.setIdProducto(Integer.parseInt(idProducto));
		calificacion.setTipoTexto(Integer.parseInt(tipoTexto));
		calificacion.setTexto(txtS);
		calificacion.setCalificacion(Integer.parseInt(rate));
		
		// Procesos
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		CalificacionInterface daoCalificacion = daoFactory.getCalificacion();
		int value = daoCalificacion.calificarProducto(calificacion);
		
		if (value == 1) {
			 // Obtiene el contexto de la aplicación
	        String contextPath = req.getContextPath();

	        // Construye la URL de destino a la que deseas redireccionar
	        String targetUrl = contextPath + "/ProductoServlet";
	        
	        req.setAttribute("type", "info");
	        req.setAttribute("idProducto", calificacion.getIdProducto());

	        // Realiza la redirección
	        resp.sendRedirect(targetUrl);
		} else {
			req.setAttribute("mensaje", "Ocurrió un problema");
//			req.getRequestDispatcher("crudestudiantes.jsp").forward(req, resp);
			
		}
	}

	
	protected void borrarCalificacion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String id = req.getParameter("idCalificacion");
		String idProducto = req.getParameter("idProducto");
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		
		CalificacionInterface daoCalificacion = daoFactory.getCalificacion();
		int value = daoCalificacion.eliminarCalificacion(Integer.parseInt(id));

		if (value != 1) {
			req.setAttribute("mensaje", "Ocurrió un problema al intentar eliminar registro de calificación con id " + id);
		}
	
		String contextPath = req.getContextPath();
        String targetUrl = contextPath + "/ProductoServlet";
        req.setAttribute("type", "info");
        req.setAttribute("idProducto", idProducto);
        resp.sendRedirect(targetUrl);
	}
}
	