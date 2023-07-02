package interfaces;

import entidades.TipoDocumento;
import entidades.Estudiante;

import java.util.List;

public interface EstudianteInterface {
	
	public List<TipoDocumento> listTipoDocumentos();
	
	public List<Estudiante> listEstudiantes();
	
	public int createEstudiante(Estudiante estudiante);
	
	public int editEstudiante(Estudiante estudiante);
	
	public Estudiante getEstudiante(String id);
	
	public int deleteEstudiante(String id);

}
