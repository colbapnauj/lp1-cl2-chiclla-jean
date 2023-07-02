package modelo;

import entidades.Matricula;
import entidades.Subject;
import interfaces.MatriculaInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;

import db.MysqlConexion;

public class MatriculaModel implements MatriculaInterface {

	@Override
	public int generarMatricula(Matricula matricula, Subject subject) {
		
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;
		
		try {
			cn = MysqlConexion.getConexion();
			cn.setAutoCommit(false);
			
			String sql = "INSERT INTO tb_matricula VALUES(null, ?, ?)";
			psm = cn.prepareStatement(sql);
			psm.setString(1,  matricula.getFechaMatricula());
			psm.setInt(2, matricula.getIdEstudiante());
			value = psm.executeUpdate();
		} catch (Exception e) {
			value = 0;
			e.printStackTrace();
			try {
				cn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				
			}
		} finally {
			try {
				if (psm != null) psm.close();
				if (cn != null) cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return value;
		
	}
	
}
