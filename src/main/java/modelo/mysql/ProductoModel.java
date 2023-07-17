package modelo.mysql;

import java.util.List;

import db.MysqlConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.Producto;
import interfaces.ProductoInterface;


public class ProductoModel implements ProductoInterface {

  @Override
  public List<Producto> obtenerProductos() {
    List<Producto> listaProductos = new ArrayList<Producto>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlConexion.getConexion();
			String sql = "call ObtenerProductosYCalificacion()";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next() ) {
				Producto producto = new Producto();
				producto.setIdProducto (rs.getInt("id_producto"));
				producto.setNombre(rs.getString("nombre"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setUrlFoto(rs.getString("url_foto"));
				producto.setPromedioRating(rs.getDouble("promedio_rating"));
				producto.setCantidadCalificaciones(rs.getInt("cantidad_calificaciones"));
				
				listaProductos.add(producto);
				
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
		
		return listaProductos;
  }

  @Override
  public Producto obtenerProductoById(int idProducto) {
	  	Producto producto = null;
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String sql = "CALL ObtenerProductoYPromedioCalificaion(?)";
			psm = cn.prepareStatement(sql);
			psm.setInt(1, idProducto);
			rs = psm.executeQuery();
			
			if (rs.next() ) {
				producto = new Producto();
				producto.setIdProducto(rs.getInt("id_producto"));
				producto.setNombre(rs.getString("nombre"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setUrlFoto(rs.getString("url_foto"));
				producto.setPromedioRating(rs.getDouble("promedio_rating"));
				producto.setCantidadCalificaciones(rs.getInt("cantidad_calificaciones"));
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
		return producto;
  }
}