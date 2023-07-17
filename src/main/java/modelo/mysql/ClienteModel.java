package modelo.mysql;

import entidades.Cliente;
import interfaces.ClienteInterface;

public class ClienteModel implements ClienteInterface{

	@Override
	public int createCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cliente obtenerCliente(int idCliente) {
		Cliente cliente = new Cliente();
		
		cliente.setIdCliente(1);
		cliente.setNombresApellidos("Cliente de Prueba");
		cliente.setEmail("cliente@prueba.com");
		
		return cliente;
	}

}
