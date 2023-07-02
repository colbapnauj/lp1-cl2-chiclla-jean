package interfaces;

import entidades.Usuario;

public interface AuthInterface {
	
	public Usuario verificarInicioSesion(String correo, String clave);

}
