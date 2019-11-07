package fast_delivery.web.model.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Cliente implements Serializable {

	private String codCliente;
	private String nomeCliente;
	private String cpfLoginUsuario;
	private String telefoneCliente;
	private String emailCliente;
	private String senhaUsuario;
	private Endereco endereco;

	public Cliente() {
		this.endereco = new Endereco();
	}

	public Cliente(String codCliente, String nomeCliente, String cpfLoginUsuario, String telefoneCliente,
			String emailCliente, String senhaUsuario, Endereco endereco) {

		this.codCliente = codCliente;
		this.nomeCliente = nomeCliente;
		this.cpfLoginUsuario = cpfLoginUsuario;
		this.telefoneCliente = telefoneCliente;
		this.emailCliente = emailCliente;
		this.senhaUsuario = senhaUsuario;
		this.endereco = endereco;
	}

	@Id
	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	@Column(name = "nome", length = 50, nullable = false)
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	@Column(name = "cpf", length = 14, nullable = false)
	public String getCpfLoginUsuario() {
		return cpfLoginUsuario;
	}

	public void setCpfLoginUsuario(String cpfLoginUsuario) {
		this.cpfLoginUsuario = cpfLoginUsuario;
	}

	@Column(length = 20)
	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	@Column(length = 50)
	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	@Column(name = "senha", length = 10, nullable = false)
	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCliente == null) ? 0 : codCliente.hashCode());
		result = prime * result + ((cpfLoginUsuario == null) ? 0 : cpfLoginUsuario.hashCode());
		result = prime * result + ((senhaUsuario == null) ? 0 : senhaUsuario.hashCode());
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
		Cliente other = (Cliente) obj;
		if (codCliente == null) {
			if (other.codCliente != null)
				return false;
		} else if (!codCliente.equals(other.codCliente))
			return false;
		if (cpfLoginUsuario == null) {
			if (other.cpfLoginUsuario != null)
				return false;
		} else if (!cpfLoginUsuario.equals(other.cpfLoginUsuario))
			return false;
		if (senhaUsuario == null) {
			if (other.senhaUsuario != null)
				return false;
		} else if (!senhaUsuario.equals(other.senhaUsuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [codCliente=" + codCliente + ", nomeCliente=" + nomeCliente + ", cpfLoginUsuario="
				+ cpfLoginUsuario + ", telefoneCliente=" + telefoneCliente + ", emailCliente=" + emailCliente
				+ ", senhaUsuario=" + senhaUsuario + ", endereco=" + endereco + "]";
	}

}
