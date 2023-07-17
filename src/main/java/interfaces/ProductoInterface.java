package interfaces;

import java.util.List;

import entidades.Producto;

public interface ProductoInterface {

  public List<Producto> obtenerProductos();

  public Producto obtenerProductoById(int idProducto);
}