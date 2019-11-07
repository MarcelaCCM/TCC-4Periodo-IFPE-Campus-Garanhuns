package fast_delivery.web.model.dao;

import java.util.List;

import org.hibernate.Session;

import fast_delivery.web.conexaobanco.HibernateUtil;
import fast_delivery.web.model.entidades.PedidoVenda;

public class JDBCPedidoVendaDAO {

	public void inserir(PedidoVenda pv) {

		Session session = HibernateUtil.getSession();
		try {
			session.getTransaction().begin();
			session.save(pv);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao inserir" + e.toString());
		} finally {
			session.close();

		}
	}

	public void alterar(PedidoVenda pv) {
		Session session = HibernateUtil.getSession();
		try {
			session.getTransaction().begin();
			session.update(pv);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Erro ao atualizar " + e.toString());
		} finally {
			session.close();
		}

	}

	public PedidoVenda recuperar(Integer pv) {
		PedidoVenda pedidoVenda = null;

		Session session = HibernateUtil.getSession();
		try {
			pedidoVenda = session.find(PedidoVenda.class, pv);
			session.close();
		} catch (Exception e) {
			System.out.println("Erro ao recuperar " + e.toString());
		}
		return pedidoVenda;
	}

	public PedidoVenda recuperarPorCodigo(String codPedidoVenda) {
		PedidoVenda pedidoVenda = null;

		Session session = HibernateUtil.getSession();
		try {
			pedidoVenda = session.find(PedidoVenda.class, codPedidoVenda);
			session.close();
		} catch (Exception e) {
			System.out.println("Erro ao recuperar " + e.toString());
		}
		return pedidoVenda;

	}

	public void deletar(PedidoVenda pv) {
		Session session = HibernateUtil.getSession();
		System.out.println(pv.toString());
		try {
			session.getTransaction().begin();
			session.delete(pv);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Falha ao remover Cliente. Erro: " + e.toString());
		} finally {
			session.close();
		}
	}

	public List<PedidoVenda> listarTodos() {
		try (Session session = HibernateUtil.getSession()) {
			List<PedidoVenda> pedidos = session.createNativeQuery("select * from pedidoVenda", PedidoVenda.class)
					.list();
			if (pedidos != null) {
				return pedidos;
			}

		} catch (Exception e) {
			System.err.println("Erro ao recuperar todos" + e.toString());
		}
		return null;

	}

	public boolean verificarPedidoVendaCadastrado(PedidoVenda pv) {
		Session session = HibernateUtil.getSession();
		PedidoVenda pedidoVenda = (PedidoVenda) session
				.createNativeQuery("select " + pv.getIdPedidoVenda() + "from pedidoVenda", PedidoVenda.class);
		if (pedidoVenda != null) {
			return true;
		}
		return false;
	}

}