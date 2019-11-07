import java.util.ArrayList;
import java.util.List;

import fast_delivery.web.controller.EstoqueController;
import fast_delivery.web.controller.ProdutoController;
import fast_delivery.web.model.entidades.Produto;

public class Teste {

	public static void main(String[] args) {
		
		Produto p = new Produto();
		p.setCodProduto("1");
		p.setMargemLucroProduto(30);
		p.setNomeProduto("feijao");
		p.setPrecoCustoProduto(0.5);
		p.setPrecoVendaProduto(35);
		p.setQuantProduto(5);
		
		ProdutoController pc = new ProdutoController();
		
		
		
		Produto pAux = pc.recuperarPorCodigoAction("feijao1");
		
		pAux.setQuantProduto(-1);
		
		
		
	     //pc.inserirProdutoAction(p);
		//pc.deletarProdutoAction(p);

		//System.out.println(pc.recuperarPorCodigoAction("Produto123Teste"));
		
		List<Produto> lp = new ArrayList<>();
		lp.add(pAux);
		
		EstoqueController ec = new EstoqueController();
		
		//ec.adicionarProduto(lp);
		
		
		ec.removerProduto(lp);
		
		System.out.println("Nova quantidade de: " + pc.recuperarPorCodigoAction("feijao1"));
		
	}

}
