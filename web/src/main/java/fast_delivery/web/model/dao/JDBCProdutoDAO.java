package fast_delivery.web.model.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import fast_delivery.web.conexaobanco.HibernateUtil;
import fast_delivery.web.model.entidades.Produto;


public class JDBCProdutoDAO implements ProdutoDao {

	public void inserir(Produto p) {

		Session session = HibernateUtil.getSession();
		try {
			session.getTransaction().begin();
			session.save(p);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao inserir" + e.toString());
		} finally {
			session.close();
		}
	}

	public void alterar(Produto p) {
		Session session = HibernateUtil.getSession();
		try {
			session.getTransaction().begin();
			session.update(p);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Erro ao atualizar " + e.toString());
		} finally {
			session.close();
		}

	}

	public Produto recuperar(Integer p) {
		Produto produto = null;

		Session session = HibernateUtil.getSession();
		try {
			produto = session.find(Produto.class, p);
			session.close();
		} catch (Exception e) {
			System.out.println("Erro ao recuperar " + e.toString());
		}
		return produto;
	}

	@Override
	public Produto recuperarPorCodigo(String str) {
		try (Session session = HibernateUtil.getSession()) {
			Produto produto = session.createNativeQuery("select * from produto where codproduto = '" + str+"'" , Produto.class).getSingleResult();
			if (produto != null) {
				return produto;
			}

		} catch (Exception e) {
			System.err.println("Erro ao recuperar " + e.toString());
		}
		return null;

		
	}
	
	public void deletar(Produto p) {
		Session session = HibernateUtil.getSession();
		System.out.println(p.toString());
        try {
            session.getTransaction().begin();
            session.delete(p);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao remover Produto. Erro: " + e.toString());
        } finally {
            session.close();
        }
	}

	public List<Produto> listarTodos() {
		try (Session session = HibernateUtil.getSession()) {
			List<Produto> produtos = session.createNativeQuery("select * from produto", Produto.class).list();
			if (produtos != null) {
				return produtos;
			}

		} catch (Exception e) {
			System.err.println("Erro ao recuperar todos" + e.toString());
		}
		return null;

	}

	@Override
	public boolean verificarProdutoCadastrado(Produto p) {
		Session session = HibernateUtil.getSession();
		Produto produto = (Produto) session.createNativeQuery("select " + p.getCodProduto() + "from produto", Produto.class);
		if(produto != null) {
			return true;
		}
		return false;
	}

}
