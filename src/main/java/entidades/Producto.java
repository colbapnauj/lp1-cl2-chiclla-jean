package entidades;

public class Producto {
	private int idProducto;
	private String nombre;
	private double precio;
	private double promedioRating;
	private int cantidadCalificaciones;
	private String urlFoto;
	
	// TODO para promedioRating setter
	// si value es null setear en 0
	
	public int getIdProducto() {
		return idProducto;
	}
	
	public String getIdProductoString() {
		return idProducto + "";
	}
	
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getPromedioRating() {
		return promedioRating;
	}
	public void setPromedioRating(double promedioRating) {
		this.promedioRating = promedioRating;
	}
	public int getCantidadCalificaciones() {
		return cantidadCalificaciones;
	}
	public void setCantidadCalificaciones(int cantidadCalificaciones) {
		this.cantidadCalificaciones = cantidadCalificaciones;
	}
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
}