package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dao.DAOFactory;
import entidades.Calificacion;
import entidades.Cliente;
import entidades.Producto;
import interfaces.CalificacionInterface;
import interfaces.ClienteInterface;
import interfaces.ProductoInterface;

@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductoServlet() {
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
		case "info": obtenerProducto(req, resp); break;
		default:
			req.setAttribute("mensaje", "Ocurrió un problema");
			req.getRequestDispatcher("404.jsp").forward(req,  resp);
		}
	}

	protected void configuracionInicial(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		ProductoInterface dao = daoFactory.getProducto();
		List<Producto> dataProductos = dao.obtenerProductos();
		
		ClienteInterface daoCliente = daoFactory.getCliente();
		Cliente cliente = daoCliente.obtenerCliente(0);
		req.setAttribute("dataCliente", cliente);
			
		req.setAttribute("dataProductos", dataProductos);
		req.getRequestDispatcher("productos.jsp").forward(req, resp);
	}
	
	protected void obtenerProducto(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("idProducto"));
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		ProductoInterface daoProducto = daoFactory.getProducto();
		Producto producto = daoProducto.obtenerProductoById(id);
		
		ClienteInterface daoCliente = daoFactory.getCliente();
		Cliente cliente = daoCliente.obtenerCliente(0);
		
		CalificacionInterface daoCalificacion = daoFactory.getCalificacion();
		List<Calificacion> calificaciones = daoCalificacion.obtenerCalificacionesDeProducto(producto.getIdProducto());
		
		// Ordena la lista de calificaciones según el idCliente
		Collections.sort(calificaciones, new Comparator<Calificacion>() {
		    @Override
		    public int compare(Calificacion c1, Calificacion c2) {
		        if (c1.getIdCliente() == cliente.getIdCliente()) {
		            // c1 tiene el idCliente igual a cliente.getIdCliente(), lo colocamos primero
		            return -1;
		        } else if (c2.getIdCliente() == cliente.getIdCliente()) {
		            // c2 tiene el idCliente igual a cliente.getIdCliente(), lo colocamos primero
		            return 1;
		        } else {
		            // Ninguno de los dos tiene el idCliente igual a cliente.getIdCliente()
		            return 0;
		        }
		    }
		});
		
		req.setAttribute("dataProducto", producto);    	
		req.setAttribute("dataCliente", cliente);
		req.setAttribute("dataCalificaciones", calificaciones);
		req.getRequestDispatcher("producto.jsp").forward(req, resp);
	}
  
  
}