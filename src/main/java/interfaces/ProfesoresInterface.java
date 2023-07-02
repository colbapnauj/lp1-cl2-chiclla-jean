package interfaces;

import java.util.List;
import entidades.Usuario;

public interface ProfesoresInterface {
	
	public int createProfesor(Usuario subject);
	
	public List<Usuario> listProfesor();
	
	public Usuario getProfesor(String id);
}
