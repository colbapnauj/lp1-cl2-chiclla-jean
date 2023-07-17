package dao;

import interfaces.ProductoInterface;
import interfaces.CalificacionInterface;
import interfaces.ClienteInterface;
import modelo.mysql.ProductoModel;
import modelo.mysql.CalificacionModel;
import modelo.mysql.ClienteModel;

public class MySqlDAOFactory extends DAOFactory {
	
	@Override
	public ProductoInterface getProducto() {
		return new ProductoModel();
	}

	@Override
	public CalificacionInterface getCalificacion() {
		return new CalificacionModel();
	}

	@Override
	public ClienteInterface getCliente() {
		return new ClienteModel();
	}

}
