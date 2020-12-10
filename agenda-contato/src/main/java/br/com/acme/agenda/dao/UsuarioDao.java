package br.com.acme.agenda.dao;

import br.com.acme.agenda.model.Usuario;

public interface  UsuarioDao {
	
	public Usuario buscarLogin(String login);

}
