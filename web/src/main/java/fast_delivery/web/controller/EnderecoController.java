package fast_delivery.web.controller;

import java.util.List;


import fast_delivery.web.model.EnderecoModel;

import fast_delivery.web.model.entidades.Endereco;

public class EnderecoController {

	EnderecoModel em = new EnderecoModel();

	public void inserirEnderecoAction(Endereco e) {
		em.inserirEndereco(e);
	}

	public void alterarEnderecoAction(Endereco e) {
		em.alterarEndereco(e);
	}

	public Endereco recuperarEnderecoAction(Integer e) {

		return em.recuperarEndereco(e);
	}

	public void deletarEnderecoAction(Endereco e) {
		em.deletarEndereco(e);

	}

	public List<Endereco> listarTodosClienteAction() {

		return em.listarTodos();
	}

}
