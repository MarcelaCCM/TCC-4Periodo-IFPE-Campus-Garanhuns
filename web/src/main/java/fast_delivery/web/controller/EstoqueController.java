package fast_delivery.web.controller;

import java.util.List;

import fast_delivery.web.model.ProdutoModel;
import fast_delivery.web.model.entidades.Produto;

public class EstoqueController {

	ProdutoModel pm = new ProdutoModel();

	public void removerProduto(List<Produto> produtos) {
		for (Produto produtoVenda : produtos) {
			Produto produtoAux = pm.recuperarPorCodigo(produtoVenda.getCodProduto());
			
			if (verificarDisponibilidadeProduto(produtoAux, produtoVenda) == true) {
				produtoAux.setQuantProduto(produtoAux.getQuantProduto() - produtoVenda.getQuantProduto());
				pm.alterar(produtoAux);
			} else {
				produtoAux.setQuantProduto(produtoAux.getQuantProduto() + produtoVenda.getQuantProduto());
				System.out.println("Quantidade INDISPONIVEL");
			}
		}
	}

	public void adicionarProduto(List<Produto> produtos) {
		for (Produto produto : produtos) {
			Produto produtoAux = pm.recuperarPorCodigo(produto.getCodProduto());
			produtoAux.setQuantProduto(produtoAux.getQuantProduto() + produto.getQuantProduto());
			pm.alterar(produtoAux);
		}
	}

	public boolean verificarDisponibilidadeProduto(Produto produtoAux, Produto produtoVenda) {
		
		if (produtoAux.getQuantProduto() > 0) {
			if(produtoVenda.getQuantProduto() <= produtoAux.getQuantProduto()) {
				
			return true;
			}
			
		}

		return false;
	}

}
