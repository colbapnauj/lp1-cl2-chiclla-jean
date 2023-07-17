package entidades;

public class Cliente {
	private int idCliente;
	private String nombresApellidos;
	private String email;
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int i) {
		this.idCliente = i;
	}
	public String getNombresApellidos() {
		return nombresApellidos;
	}
	public void setNombresApellidos(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}