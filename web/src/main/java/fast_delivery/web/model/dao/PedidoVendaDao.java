package fast_delivery.web.model.dao;

import fast_delivery.web.model.entidades.PedidoVenda;

public interface PedidoVendaDao extends Dao<PedidoVenda> {
	

	public PedidoVenda recuperarPorCodigo(String codPedidoVenda);
	public boolean verificarPedidoVendaCadastrado(PedidoVenda pv);

}