package fast_delivery.web.model;

import java.util.List;

import fast_delivery.web.model.dao.JDBCProdutoDAO;
import fast_delivery.web.model.entidades.Produto;

public class ProdutoModel {

	JDBCProdutoDAO prod = new JDBCProdutoDAO();

	public void inserir(Produto p) {
		prod.inserir(p);
	}

	public void alterar(Produto p) {
		prod.alterar(p);

	}

	public Produto recuperar(Integer p) {
		return prod.recuperar(p);
	}

	public Produto recuperarPorCodigo(String str) {
		return prod.recuperarPorCodigo(str);
	}

	public void deletar(Produto p) {
		prod.deletar(p);

	}

	public List<Produto> listarTodos() {
		return prod.listarTodos();
	}

}
