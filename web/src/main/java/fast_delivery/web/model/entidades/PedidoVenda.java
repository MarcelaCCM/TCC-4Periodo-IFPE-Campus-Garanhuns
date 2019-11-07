package fast_delivery.web.model.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@SuppressWarnings("serial")
@Entity
public class PedidoVenda implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPedidoVenda;

	@Column
	private String codPedidoVenda;

	// Não precisa 
	@OneToMany
	private List<Produto> produtosPedido;

	@Column
	private LocalDate DataPedido;

//	@Column
//	private double quantidadeDeProdutosPedido;

//	@OneToOne
//	private FormaDePagamento formaDePagamentoPedido;

	@OneToOne (cascade = {CascadeType.ALL})
	private Cliente cliente;

	@ManyToOne (cascade = {CascadeType.ALL})
	private Produto produto;

	@Column
	private double valorTotalPedido;

	@Column
	private boolean statusPedido = false;

	public int getIdPedidoVenda() {
		return idPedidoVenda;
	}

	public void setIdPedidoVenda(int idPedidoVenda) {
		this.idPedidoVenda = idPedidoVenda;
	}

	public String getCodPedidoVenda() {
		return codPedidoVenda;
	}

	public void setCodPedidoVenda(String codPedidoVenda) {
		this.codPedidoVenda = codPedidoVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutosPedido() {
		return produtosPedido;
	}

	public void setProdutosPedido(List<Produto> produtosPedido) {
		this.produtosPedido = produtosPedido;
	}

	public LocalDate getDataPedido() {
		return DataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		DataPedido = dataPedido;
	}

//	public double getQuantidadeDeProdutosPedido() {
//		return quantidadeDeProdutosPedido;
//	}
//
//	public void setQuantidadeDeProdutosPedido(double quantidadeDeProdutosPedido) {
//		this.quantidadeDeProdutosPedido = quantidadeDeProdutosPedido;
//	}

//	public FormaDePagamento getFormaDePagamentoPedido() {
//		return formaDePagamentoPedido;
//	}
//
//	public void setFormaDePagamentoPedido(FormaDePagamento formaDePagamentoPedido) {
//		this.formaDePagamentoPedido = formaDePagamentoPedido;
//	}

	public double getValorTotalPedido() {
		return valorTotalPedido;
	}

	public void setValorTotalPedido(double valorTotalPedido) {
		this.valorTotalPedido = valorTotalPedido;
	}

	public boolean isStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(boolean statusPedido) {
		this.statusPedido = statusPedido;
	}

	public PedidoVenda(String codPedidoVenda, Cliente cliente, Produto produto, List<Produto> produtosPedido,
			LocalDate dataPedido, FormaDePagamento formaDePagamentoPedido, double valorTotalPedido,
			boolean statusPedido) {
		super();
		this.codPedidoVenda = codPedidoVenda;
		this.cliente = cliente;
		this.produto = produto;
		this.produtosPedido = produtosPedido;
		DataPedido = dataPedido;
//		this.formaDePagamentoPedido = formaDePagamentoPedido;
		this.valorTotalPedido = valorTotalPedido;
		this.statusPedido = statusPedido;
	}

	public PedidoVenda() {

		//this.cliente = new Cliente();
		//this.produto = new Produto();

	}

	@Override
	public String toString() {
		return "PedidoVenda [codPedidoVenda=" + codPedidoVenda + ", produtosPedido=" + produtosPedido + ", DataPedido="
				+ DataPedido + ", cliente=" + cliente + ", produto=" + produto + ", valorTotalPedido="
				+ valorTotalPedido + ", statusPedido=" + statusPedido + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPedidoVenda == null) ? 0 : codPedidoVenda.hashCode());
		result = prime * result + idPedidoVenda;
		result = prime * result + ((produtosPedido == null) ? 0 : produtosPedido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoVenda other = (PedidoVenda) obj;
		if (codPedidoVenda == null) {
			if (other.codPedidoVenda != null)
				return false;
		} else if (!codPedidoVenda.equals(other.codPedidoVenda))
			return false;
		if (idPedidoVenda != other.idPedidoVenda)
			return false;
		if (produtosPedido == null) {
			if (other.produtosPedido != null)
				return false;
		} else if (!produtosPedido.equals(other.produtosPedido))
			return false;
		return true;
	}

}