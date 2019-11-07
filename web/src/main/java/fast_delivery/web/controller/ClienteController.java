package fast_delivery.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fast_delivery.web.model.ClienteModel;
import fast_delivery.web.model.entidades.Cliente;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class ClienteController implements Serializable {

	private ClienteModel cm = null;
	private Cliente cliente;
	private Cliente selectedCliente;

	public String editarTeste(Cliente cTeste) {

		this.cliente = cTeste;

		cm.recuperarPorCodigo(cTeste.getCodCliente());

//		System.out.println(cTeste.toString() + "teste");
//		
		return "alterarcliente.xhtml";
	}

	public ClienteController() {

		this.cliente = new Cliente();
		this.cm = new ClienteModel();
		this.selectedCliente = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("clienteLogado");

	}

	public void inserirClienteAction() {
		this.cm.inserirCliente(this.cliente);
		this.cliente = new Cliente();
		FacesMessage faces = new FacesMessage("Cliente salvado com sucesso");
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, faces);
	}

	public Cliente recuperarClienteAction(Integer c) {
		return cm.recuperarCliente(c);
	}

	public Cliente recuperarPorCodigoAction(String codCliente) {
		return cm.recuperarPorCodigo(codCliente);
	}

	public String alterarClienteAction() {
		this.cm.alterarCliente(selectedCliente);
		return "listarclientes.xhtml";

	}

	public void deletarClienteAction(Cliente c) {
		cm.deletarCliente(c);

	}

	public List<Cliente> listarTodosClienteAction() {
		return cm.listarTodos();
	}

	public ClienteModel getCm() {
		return cm;
	}

	public void setCm(ClienteModel cm) {
		this.cm = cm;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getSelectedCliente() {
		return selectedCliente;
	}

	public void setSelectedCliente(Cliente selectedCliente) {
		this.selectedCliente = selectedCliente;
	}

	public String linkAlterar() {
		return "alterarcliente.xhtml?faces-redirect=true";
	}

}
