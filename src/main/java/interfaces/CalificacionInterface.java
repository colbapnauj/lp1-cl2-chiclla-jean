package interfaces;

import java.util.List;

import entidades.Calificacion;

public interface CalificacionInterface {

	public List<Calificacion> obtenerCalificacionesDeProducto(int idProducto);
	
	public int calificarProducto(Calificacion calificacion);
	
	public int eliminarCalificacion(int idCalificacion);
  
}