package modelo;

import java.util.List;

import db.MysqlConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.Estudiante;
import entidades.Subject;
import entidades.TipoDocumento;
import interfaces.EstudianteInterface;


public class EstudianteModel implements EstudianteInterface {

	@Override
	public List<TipoDocumento> listTipoDocumentos() {
		List<TipoDocumento> listDocumentos = new ArrayList<TipoDocumento>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlConexion.getConexion();
			String sql = "SELECT * FROM tipo_documento";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next() ) {
				
				TipoDocumento documento = new TipoDocumento();
				documento.setId(rs.getString("idTipo"));
				documento.setDocumento(rs.getString("documento"));
				
				listDocumentos.add(documento);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstm != null) pstm.close();
				if (cn != null) cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listDocumentos;
	}

	@Override
	public List<Estudiante> listEstudiantes() {
		List<Estudiante> listEstudiantes = new ArrayList<Estudiante>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlConexion.getConexion();
			String sql = "SELECT est.idEstudiante, est.nombresApellidos, est.tipoDocumento, tip.documento,\r\n"
					+ "est.documento AS 'numeroDocumento', est.telefono, est.carrera FROM estudiante as est \r\n"
					+ "INNER JOIN tipo_documento as tip on est.tipoDocumento = tip.idTipo";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next() ) {
				Estudiante estudiante = new Estudiante();
				estudiante.setId(rs.getString("idEstudiante"));
				estudiante.setNombresApellidos(rs.getString("nombresApellidos"));
				estudiante.setTipoDocumento(rs.getString("tipoDocumento"));
				estudiante.setDocumento(rs.getString("documento"));
				estudiante.setNumeroDocumento(rs.getString("numeroDocumento"));
				estudiante.setTelefono(rs.getString("telefono"));
				estudiante.setCarrera(rs.getString("carrera"));
				listEstudiantes.add(estudiante);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstm != null) pstm.close();
				if (cn != null) cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listEstudiantes;
	}

	@Override
	public int createEstudiante(Estudiante estudiante) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String sql = "INSERT INTO estudiante VALUES(null, ?, ?, ?, ?, ?)";
			psm = cn.prepareStatement(sql);
			psm.setString(1, estudiante.getNombresApellidos());
			psm.setString(2, estudiante.getTipoDocumento());
			psm.setString(3, estudiante.getTelefono());
			psm.setString(4, estudiante.getCarrera());
			psm.setString(5, estudiante.getDocumento());
			
			value = psm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
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

	@Override
	public int editEstudiante(Estudiante estudiante) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String sql = "UPDATE estudiante SET nombresApellidos=?, tipoDocumento=?, documento=?, telefono=?, carrera=? WHERE idEstudiante=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, estudiante.getNombresApellidos());
			psm.setString(2, estudiante.getTipoDocumento());
			psm.setString(3, estudiante.getDocumento());
			psm.setString(4, estudiante.getTelefono());
			psm.setString(5, estudiante.getCarrera());
			psm.setString(6, estudiante.getId());
			
			value = psm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
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

	@Override
	public Estudiante getEstudiante(String id) {
		Estudiante student = null;
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String sql = "SELECT est.* FROM estudiante AS est WHERE idEstudiante=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			rs = psm.executeQuery();
			
			if (rs.next() ) {
				student = new Estudiante();
				student.setId(rs.getString("idEstudiante"));
				student.setNombresApellidos(rs.getString("nombresApellidos"));
				student.setTipoDocumento(rs.getString("tipoDocumento"));
				student.setDocumento(rs.getString("documento"));
				student.setTelefono(rs.getString("telefono"));
				student.setCarrera(rs.getString("carrera"));
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				if (rs != null) rs.close();
				if (psm != null) psm.close();
				if (cn != null) cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return student;
	}

	@Override
	public int deleteEstudiante(String id) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String sql = "DELETE FROM estudiante WHERE idEstudiante=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1,  id);
			value = psm.executeUpdate();
			
					
		} catch (Exception e) {
			e.printStackTrace();
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
