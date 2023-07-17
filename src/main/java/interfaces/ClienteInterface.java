package interfaces;

import entidades.Cliente;

public interface ClienteInterface {

  public int createCliente(Cliente cliente);
  
  public Cliente obtenerCliente(int idCliente);
}