package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class SQLServerConexion {
	
	public static Connection getConexion() {
		Connection con = null;
				
		try {
			// con = DriverManager.getConnection(connectionUrl);
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://ab-win-host:1433;encrypt=true;trustServerCertificate=true;DatabaseName=Instituto;integratedSecurity=true";
			con = DriverManager.getConnection(connectionUrl);
		} catch (SQLException e) {
			System.out.println("Error >> de conexión con la BD" + e.getMessage());
		} catch (Exception e) {
			System.out.print("Error >> general: " + e.getLocalizedMessage());
		}
		
		return con;
	
	}
	
	public static void closeConexion(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Problemas al cerrar la conexion" + e.getMessage());
		}
	}
}
