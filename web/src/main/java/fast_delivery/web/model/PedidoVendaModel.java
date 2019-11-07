package fast_delivery.web.model;

import java.util.List;

import fast_delivery.web.model.dao.JDBCPedidoVendaDAO;
import fast_delivery.web.model.entidades.PedidoVenda;

public class PedidoVendaModel {

	JDBCPedidoVendaDAO vend = new JDBCPedidoVendaDAO();

	public void inserirPedidoVenda(PedidoVenda pv) {
		vend.inserir(pv);
	}

	public void alterarPedidoVenda(PedidoVenda pv) {
		vend.alterar(pv);

	}

	public PedidoVenda recuperarPedidoVenda(Integer pv) {

		return vend.recuperar(pv);

	}

	public void deletarPedidoVenda(PedidoVenda pv) {
		vend.deletar(pv);

	}

	public List<PedidoVenda> listarTodos() {
		return vend.listarTodos();
	}

	public PedidoVenda recuperarPorCodigo(String codPedidoVenda) {
		return vend.recuperarPorCodigo(codPedidoVenda);
		
	
	}

}