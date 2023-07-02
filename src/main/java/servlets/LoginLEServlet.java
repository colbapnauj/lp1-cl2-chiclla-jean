package servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import entidades.UsuarioLE;

@WebServlet("/LoginLEServlet")
public class LoginLEServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginLEServlet() {
        super();
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String correo = req.getParameter("txtCorreo");
		String clave = req.getParameter("txtPass");
		
		if (correo.equals("jean@abcorp.net.pe") && clave.equals("123456789")) {
			
			UsuarioLE usuario = new UsuarioLE();
			usuario.setName("Jean");
			usuario.setApellido("Chiclla");
			usuario.setCodigo(100);
			usuario.setClave(clave);
			usuario.setUsuario(correo);
			
			req.setAttribute("usuario", usuario);
			req.setAttribute("mensaje", "Jean Chiclla");
			req.getRequestDispatcher("principalLE.jsp").forward(req, resp);
		} else {
			req.setAttribute("mensaje", "Error en usuario y/o clave");
			req.getRequestDispatcher("loginLE.jsp").forward(req, resp);
		}
	}

}
