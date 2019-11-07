package fast_delivery.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fast_delivery.web.model.PedidoVendaModel;
import fast_delivery.web.model.entidades.PedidoVenda;

@ManagedBean
@SessionScoped
public class PedidoVendaController implements Serializable {

	
	private PedidoVendaModel pvm = null;
	private PedidoVenda pedidoVenda;
	private PedidoVenda selectedPedidoVenda;



	public PedidoVendaController() {

		this.pedidoVenda = new PedidoVenda();
		this.pvm = new PedidoVendaModel();
		this.selectedPedidoVenda = (PedidoVenda) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("pedidoVendaLogado");

	}

	public void inserirPedidoVendaAction() {
		
		this.pvm.inserirPedidoVenda(this.pedidoVenda);
		this.pedidoVenda = new PedidoVenda();
		FacesMessage faces = new FacesMessage("Pedido Venda salvado com sucesso");
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, faces);
	
	}

	public PedidoVenda recuperarPedidoVendaAction(Integer pv) {
		return pvm.recuperarPedidoVenda(pv);
	}

	public PedidoVenda recuperarPorCodigoAction(String codPedidoVenda) {
		return pvm.recuperarPorCodigo(codPedidoVenda);
	}

	public String alterarPedidoVendaAction() {
		this.pvm.alterarPedidoVenda(selectedPedidoVenda);
		return "listarclientes.xhtml";

	}

	public void deletarPedidoVendaAction(PedidoVenda pv) {
		pvm.deletarPedidoVenda(pv);

	}

	public List<PedidoVenda> listarTodosPedidoVendaAction() {
		return pvm.listarTodos();
	}

	// Fazer os getters e setters

	public PedidoVendaModel getPvm() {
		return pvm;
	}

	public void setPvm(PedidoVendaModel pvm) {
		this.pvm = pvm;
	}

	public PedidoVenda getPedidoVenda() {
		return pedidoVenda;
	}

	public void setPedidoVenda(PedidoVenda pedidoVenda) {
		this.pedidoVenda = pedidoVenda;
	}

	public PedidoVenda getSelectedPedidoVenda() {
		return selectedPedidoVenda;
	}

	public void setSelectedPedidoVenda(PedidoVenda selectedPedidoVenda) {
		this.selectedPedidoVenda = selectedPedidoVenda;
	}

}