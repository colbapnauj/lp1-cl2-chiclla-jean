package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import dao.DAOFactory;
import entidades.Estudiante;
import modelo.EstudianteModel;
import modelo.SubjectModel;
import entidades.TipoDocumento;
import interfaces.EstudianteInterface;

@WebServlet("/EstudianteServlet2")
public class EstudianteServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EstudianteServlet2() {
		super();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		
		if (type == null) {
			configuracionInicial(req, resp);	
			return;
		}
		
		switch (type) {
		
		case "load": configuracionInicial(req, resp); break;
		case "register": {
			String idEstudiante = req.getParameter("idEstudiante");
			if (idEstudiante.isEmpty()) {
				registrarEstudiante(req, resp);
			} else {
				editarEstudiante(req, resp);
			}
		}; break;
		case "delete": eliminarEstudiante(req, resp); break;
		case "info": obtenerEstudiante(req, resp); break;
		default:
			req.setAttribute("mensaje", "Ocurrió un problema");
			req.getRequestDispatcher("estudiante2.jsp").forward(req,  resp);
		}
	}
	
	protected void configuracionInicial(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		EstudianteInterface dao = daoFactory.getEstudiante();
		List<TipoDocumento> dataDocumentos = dao.listTipoDocumentos();
		List<Estudiante> dataEstudiantes = dao.listEstudiantes();
		
		req.setAttribute("dataDocumentos", dataDocumentos);
		req.setAttribute("dataEstudiantes", dataEstudiantes);
		req.getRequestDispatcher("crudestudiantes.jsp").forward(req, resp);
	}
	
	protected void registrarEstudiante(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Entradas
		String name = req.getParameter("txtNombres");
		String documentTypeId = req.getParameter("cboTipoDocumento");
		String document = req.getParameter("txtNumeroDocumento");
		String phone = req.getParameter("txtTelefono");
		String colllageCareer = req.getParameter("txtCarrera");
		
		System.out.println(name);
		System.out.println(documentTypeId);
		System.out.println(document);
		System.out.println(phone);
		System.out.println(colllageCareer);
		
		// Creamos objecto
		Estudiante student = new Estudiante();
		student.setNombresApellidos(name);
		student.setTipoDocumento(documentTypeId);
		student.setDocumento(document);
		student.setTelefono(phone);
		student.setCarrera(colllageCareer);
		
		// Procesos
		EstudianteModel model = new EstudianteModel();
		int value = model.createEstudiante(student	);
		
		if (value == 1) {
			// TODO clear register
			configuracionInicial(req, resp);
		} else {
			req.setAttribute("mensaje", "Ocurrió un problema");
			req.getRequestDispatcher("crudestudiantes.jsp").forward(req, resp);
			
		}
	}
	
	protected void editarEstudiante(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Entradas
		String id = req.getParameter("idEstudiante");
		String name = req.getParameter("txtNombres");
		String documentTypeId = req.getParameter("cboTipoDocumento");
		String document = req.getParameter("txtNumeroDocumento");
		String phone = req.getParameter("txtTelefono");
		String colllageCareer = req.getParameter("txtCarrera");
		
		// Creamos objecto
		Estudiante student = new Estudiante();
		student.setId(id);
		student.setNombresApellidos(name);
		student.setTipoDocumento(documentTypeId);
		student.setDocumento(document);
		student.setTelefono(phone);
		student.setCarrera(colllageCareer);
		
		// Procesos
		EstudianteModel model = new EstudianteModel();
		int value = model.editEstudiante(student);
		
		if (value == 1) {
			configuracionInicial(req, resp);
		} else {
			req.setAttribute("mensaje", "Ocurrió un problema");
			req.getRequestDispatcher("crudestudiantes.jsp").forward(req, resp);
			
		}
		
	}
	
	protected void eliminarEstudiante(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("idEstudiante");
    	
    	EstudianteModel model = new EstudianteModel();
    	int value = model.deleteEstudiante(id);
    	
    	if (value != 1) {
    		req.setAttribute("mensaje", "Ocurrió un problema al intentar eliminar registro estudiante con id " + id);
    	}
    	
    	configuracionInicial(req, resp);
	}
	
	protected void obtenerEstudiante(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("idEstudiante");
		
		EstudianteModel model = new EstudianteModel();
		Estudiante student = model.getEstudiante(id);
		
		
		req.setAttribute("estudianteData", student);    	
    	configuracionInicial(req, resp);
	}
}
