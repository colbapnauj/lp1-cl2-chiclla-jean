package entidades;

import java.util.Date;

public class Calificacion {
	private int idCalificacion;
	private int idCliente;
	private String nombreCliente;
  	private int idProducto;
  	private int calificacion;
  	private int tipoTexto;
  	private String texto;
  	private Date fechaCalificacion;
  	
  	public int getIdCalificacion() {
		return idCalificacion;
	}
	public void setIdCalificacion(int idCalificacion) {
		this.idCalificacion = idCalificacion;
	}
  	
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public Date getFechaCalificacion() {
		return fechaCalificacion;
	}
	public void setFechaCalificacion(Date fechaCalificacion) {
		this.fechaCalificacion = fechaCalificacion;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	public int getTipoTexto() {
		return tipoTexto;
	}
	public void setTipoTexto(int tipoTexto) {
		this.tipoTexto = tipoTexto;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String getTipoTextoName() {
		if (tipoTexto == 1) {
			return "Comentario";
		} else if (tipoTexto == 2) {
			return "Sugerencia";
		} else {
			return "Desconocido";
		}
	}	
}