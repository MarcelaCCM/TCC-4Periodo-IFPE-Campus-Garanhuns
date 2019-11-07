package fast_delivery.web.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;

import fast_delivery.web.model.ProdutoModel;
import fast_delivery.web.model.entidades.Produto;

@SessionScoped
@ManagedBean
public class ProdutoController {

	public ProdutoModel pm;
	private List<Produto> produtos;
	private Produto produto;
	private Produto selectedProdut;

	public ProdutoController() {
		this.produto = new Produto();
		this.pm = new ProdutoModel();

	}

	public void inserirProdutoAction() {
		this.pm.inserir(this.produto);
		this.produto = new Produto();
		FacesMessage faces = new FacesMessage("Produto salvado com sucesso");
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, faces);
	}

	public String alterarProdutoAction(Produto produto) {
		this.produto = produto;

		return "produtocadastro.xhtml";
	}

	public Produto recuperarProdutoAction(Integer p) {

		return pm.recuperar(p);
	}

	public Produto recuperarPorCodigoAction(String str) {
		return pm.recuperarPorCodigo(str);
	}

	public void deletarProdutoAction() {

		if (selectedProdut == null) {

			FacesMessage faces = new FacesMessage("objeto vazio");
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, faces);
		} else {
			FacesMessage faces = new FacesMessage("Objeto cheio");
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, faces);
			pm.deletar(selectedProdut);
		}

	}

	public void delet() {
		pm.deletar(this.selectedProdut);
	}

	public void listarTodosProdutoAction() {
		produtos = pm.listarTodos();
	}

	public List<Produto> getProdutos() {
		return produtos = pm.listarTodos();

	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoModel getPm() {
		return pm;
	}

	public void setPm(ProdutoModel pm) {
		this.pm = pm;
	}

	public Produto getSelectedProdut() {
		return selectedProdut;
	}

	public void setSelectedProdut(Produto selectedProdut) {
		this.selectedProdut = selectedProdut;
	}

}