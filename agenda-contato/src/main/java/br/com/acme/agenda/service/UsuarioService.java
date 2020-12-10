package br.com.acme.agenda.service;

import br.com.acme.agenda.model.Usuario;

public interface UsuarioService {
	
	public Usuario buscarLogin(String login);
	
	public String validarAcesso(String login, String senha);

}
