/**
 * 
 */
package br.com.acme.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.model.Usuario;
import br.com.acme.agenda.utils.JPAUtil;

/**
 * @author TERCEIRA CAMADA
 *
 */
public class ContatoDaoImpl implements ContatoDao {

	@Override
	public void salvar(Contato contato) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(contato);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public List<Contato> listarContatos() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		Query consulta = entityManager.createQuery("SELECT c FROM Contato c");
		List<Contato> listaDeContatosDoBancoDeDados = consulta.getResultList();
		return listaDeContatosDoBancoDeDados;
	}

	@Override
	public void remover(Long idContato) {

		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Contato contato = entityManager.find(Contato.class, idContato);
		entityManager.remove(contato);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public Contato buscarPorIdContato(Long idContato) {

		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Contato contato = entityManager.find(Contato.class, idContato);
		entityManager.getTransaction().commit();
		entityManager.close();
		return contato;
	}

	@Override
	public void editarContato(Contato contato) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
				
		entityManager.merge(contato);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public Contato buscarContatoPorEmail(String email) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		try {
			Contato contato = entityManager.createNamedQuery("Contato.buscarContatoPorEmail", Contato.class)
					.setParameter("email", email).getSingleResult();
			entityManager.close();
			return contato;

		} catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		}
		return null;

	}

	@Override
	public void ativarDesativarContato(Long id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Contato contatoBD = entityManager.find(Contato.class, id);
		if (contatoBD != null && contatoBD.isAtivo()) {
			contatoBD.setAtivo(false);
		} else if (contatoBD != null && !contatoBD.isAtivo()) {
			contatoBD.setAtivo(true);
		}
		entityManager.merge(contatoBD);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
