package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.MysqlConexion;
import entidades.Usuario;
import interfaces.AuthInterface;

public class AuthModel implements AuthInterface {
	
	@Override
	public Usuario verificarInicioSesion(String correo, String clave) {
		
		Usuario usuario = null;
		PreparedStatement psmt = null;
		Connection cn = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlConexion.getConexion();
			String mysql = "SELECT usr.iduser, usr.email, pe.name, pe.lastname, \r\n"
					+ "ro.rolName FROM  user AS usr \r\n"
					+ "INNER JOIN people AS pe ON usr.people_idpeople = pe.idpeople\r\n"
					+ "INNER JOIN rol AS ro ON usr.rol_idrol = ro.idrol\r\n"
					+ "WHERE email = ? AND password = ? ";
			
			psmt = cn.prepareStatement(mysql);
			psmt.setString(1,  correo);
			psmt.setString(2,  clave);
			rs = psmt.executeQuery();
			
			if (rs.next() ) {
				usuario = new Usuario();
				usuario.setId(rs.getString("iduser"));
				usuario.setNombre(rs.getString("name"));
				usuario.setApellidos(rs.getString("name"));
				usuario.setEmail(rs.getString("name"));
				usuario.setRol(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rs != null) rs.close();
				if (psmt != null) psmt.close();
				if (cn != null) cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return usuario;
	}

}
