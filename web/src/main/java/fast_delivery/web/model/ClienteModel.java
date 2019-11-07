package fast_delivery.web.model;

import java.util.List;

import fast_delivery.web.model.dao.JDBCClienteDAO;
import fast_delivery.web.model.entidades.Cliente;

public class ClienteModel {

	JDBCClienteDAO cli = new JDBCClienteDAO();

	public void inserirCliente(Cliente c) {
		cli.inserir(c);
	}

	public void alterarCliente(Cliente c) {
		cli.alterar(c);

	}

	public Cliente recuperarCliente(Integer c) {
		return cli.recuperar(c);

	}

	public Cliente recuperarPorCodigo(String codCliente) {
		return cli.recuperarPorCodigo(codCliente);
	}

	public void deletarCliente(Cliente c) {
		cli.deletar(c);

	}

	public List<Cliente> listarTodos() {
		return cli.listarTodos();
	}

}
