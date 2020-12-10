package br.com.acme.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.model.Usuario;
import br.com.acme.agenda.utils.JPAUtil;

public class UsuarioDaoImpl implements UsuarioDao {

	@Override
	public Usuario buscarLogin(String login) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		try {
			return entityManager.createNamedQuery("Usuario.buscarLogin", Usuario.class).setParameter("login", login)
					.getSingleResult();

		} catch (NoResultException e) {
			e.getMessage();
		}
		return null;

	}

}
