package dao;

import interfaces.ProductoInterface;
import interfaces.CalificacionInterface;
import interfaces.ClienteInterface;

public abstract class DAOFactory {
	
	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;
	public static final int ORACLE = 3;
	
	public abstract ProductoInterface getProducto();
	public abstract CalificacionInterface getCalificacion();
	public abstract ClienteInterface getCliente();
	
	public static DAOFactory getDaoFactory(int tipo) {
		
		switch (tipo) {
		
		case MYSQL:
			return new MySqlDAOFactory();
		case SQLSERVER:
			return null;
		case ORACLE:
			return null;
		default:
			return null;
		}	
	}	
}
