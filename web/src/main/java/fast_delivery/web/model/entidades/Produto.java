package fast_delivery.web.model.entidades;

import java.io.Serializable;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProduto;

	@Column
	private String codProduto;

	@Column
	private String nomeProduto;

	@Column
	private double precoCustoProduto;

	@Column
	private double margemLucroProduto;

	@Column
	private double precoVendaProduto;

	@Column
	private int quantProduto;

	public Produto(String codProduto, String nomeProduto, double precoCustoProduto, double margemLucroProduto,
			double precoVendaProduto, int quantProduto) {
		this.codProduto = codProduto;
		this.nomeProduto = nomeProduto;
		this.precoCustoProduto = precoCustoProduto;
		this.margemLucroProduto = margemLucroProduto;
		this.precoVendaProduto = precoVendaProduto;
		this.quantProduto = quantProduto;
	}

	public Produto() {

	}

	public String getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPrecoCustoProduto() {
		return precoCustoProduto;
	}

	public void setPrecoCustoProduto(double precoCustoProduto) {
		this.precoCustoProduto = precoCustoProduto;
	}

	public double getMargemLucroProduto() {
		return margemLucroProduto;
	}

	public void setMargemLucroProduto(double margemLucroProduto) {
		this.margemLucroProduto = margemLucroProduto;
	}

	public double getPrecoVendaProduto() {
		return precoVendaProduto;
	}

	public void setPrecoVendaProduto(double precoVendaProduto) {
		this.precoVendaProduto = precoVendaProduto;
	}

	public int getQuantProduto() {
		return quantProduto;
	}

	public void setQuantProduto(int quantProduto) {
		this.quantProduto = quantProduto;
	}

	@Override
	public String toString() {
		return "Produto [codProduto=" + codProduto + ", nomeProduto=" + nomeProduto + ", precoCustoProduto="
				+ precoCustoProduto + ", margemLucroProduto=" + margemLucroProduto + ", precoVendaProduto="
				+ precoVendaProduto + ", quantProduto=" + quantProduto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codProduto == null) ? 0 : codProduto.hashCode());
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
		Produto other = (Produto) obj;
		if (codProduto == null) {
			if (other.codProduto != null)
				return false;
		} else if (!codProduto.equals(other.codProduto))
			return false;
		return true;
	}

}
