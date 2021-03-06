package fast_delivery.web.model.dao;

import java.util.List;

import org.hibernate.Session;
import fast_delivery.web.conexaobanco.HibernateUtil;
import fast_delivery.web.model.entidades.Cliente;

public class JDBCClienteDAO implements ClienteDao {

	public void inserir(Cliente c) {

		Session session = HibernateUtil.getSession();
		try {
			session.getTransaction().begin();
			session.save(c);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao inserir" + e.toString());
		} finally {
			session.close();

		}
	}

	public void alterar(Cliente c) {
		Session session = HibernateUtil.getSession();
		try {
			session.getTransaction().begin();
			session.update(c);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Erro ao atualizar " + e.toString());
		} finally {
			session.close();
		}

	}

	public Cliente recuperar(Integer c) {
		Cliente cliente = null;

		Session session = HibernateUtil.getSession();
		try {
			cliente = session.find(Cliente.class, c);
			session.close();
		} catch (Exception e) {
			System.out.println("Erro ao recuperar " + e.toString());
		}
		return cliente;
	}

	@Override
	public Cliente recuperarPorCodigo(String codCliente) {
		Cliente cliente = null;

		Session session = HibernateUtil.getSession();
		try {
			cliente = session.find(Cliente.class, codCliente);
			session.close();
		} catch (Exception e) {
			System.out.println("Erro ao recuperar " + e.toString());
		}
		return cliente;

	}

	public void deletar(Cliente c) {
		Session session = HibernateUtil.getSession();
		System.out.println(c.toString());
		try {
			session.getTransaction().begin();
			session.delete(c);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Falha ao remover Cliente. Erro: " + e.toString());
		} finally {
			session.close();
		}
	}

	public List<Cliente> listarTodos() {
		try (Session session = HibernateUtil.getSession()) {
			List<Cliente> clientes = session.createNativeQuery("select * from cliente", Cliente.class).list();
			if (clientes != null) {
				return clientes;
			}

		} catch (Exception e) {
			System.err.println("Erro ao recuperar todos" + e.toString());
		}
		return null;

	}

	@Override
	public boolean verificarClienteCadastrado(Cliente c) {
		Session session = HibernateUtil.getSession();
		Cliente cliente = (Cliente) session.createNativeQuery("select " + c.getCodCliente() + "from cliente",
				Cliente.class);
		if (cliente != null) {
			return true;
		}
		return false;
	}

}
