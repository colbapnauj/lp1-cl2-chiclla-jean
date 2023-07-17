package modelo.mysql;

import java.util.List;

import db.MysqlConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.Calificacion;
import interfaces.CalificacionInterface;

public class CalificacionModel implements CalificacionInterface {

  @Override
  public int calificarProducto(Calificacion calificacion) {
    int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String sql = "INSERT INTO Calificaciones_Productos (id_cliente, id_producto, calificacion, tipo_texto, texto)\n\r" +
                    "VALUES(?, ?, ?, ?, ?)";
			psm = cn.prepareStatement(sql);
			psm.setInt(1, calificacion.getIdCliente());
			psm.setInt(2, calificacion.getIdProducto());
			psm.setInt(3, calificacion.getCalificacion());
			psm.setInt(4, calificacion.getTipoTexto());
			psm.setString(5, calificacion.getTexto());
			
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
	public List<Calificacion> obtenerCalificacionesDeProducto(int idProducto) {
		// CALL ObtenerCalificacionesPorProductoId(2)
		// TODO Auto-generated method stub
		List<Calificacion> listaCalificacion = new ArrayList<Calificacion>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
			
		try {
				
			cn = MysqlConexion.getConexion();
			String sql = "CALL ObtenerCalificacionesPorProductoId(?)";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, idProducto);
			rs = pstm.executeQuery();
				
			while (rs.next() ) {
				Calificacion calificacion = new Calificacion();
				calificacion.setIdCalificacion(rs.getInt("id_calificacion"));
				calificacion.setIdCliente(rs.getInt("id_cliente"));
				calificacion.setIdProducto(rs.getInt("id_producto"));
				calificacion.setCalificacion(rs.getInt("calificacion"));
				calificacion.setTipoTexto(rs.getInt("tipo_texto"));
				calificacion.setTexto(rs.getString("texto"));
				calificacion.setNombreCliente(rs.getString("nombre_cliente"));
				calificacion.setFechaCalificacion(rs.getDate("fecha_calificacion"));
				
				listaCalificacion.add(calificacion);
					
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
			
		return listaCalificacion;
	}
	
	@Override
	public int eliminarCalificacion(int idCalificacion) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String sql = "DELETE FROM Calificaciones_Productos WHERE id_calificacion=?";
			psm = cn.prepareStatement(sql);
			psm.setInt(1,  idCalificacion);
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