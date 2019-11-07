package fast_delivery.web.model.dao;

import fast_delivery.web.model.entidades.Cliente;


public interface ClienteDao extends Dao<Cliente> {

	public Cliente recuperarPorCodigo(String codCliente);
	public boolean verificarClienteCadastrado(Cliente c);

}
