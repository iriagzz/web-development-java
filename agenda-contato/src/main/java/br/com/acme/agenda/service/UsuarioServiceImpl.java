package br.com.acme.agenda.service;

import br.com.acme.agenda.dao.UsuarioDao;
import br.com.acme.agenda.dao.UsuarioDaoImpl;
import br.com.acme.agenda.model.Usuario;
import br.com.acme.agenda.utils.Constantes;

public class UsuarioServiceImpl implements UsuarioService{

private UsuarioDao usuarioDao;
	
	public UsuarioServiceImpl() {
		usuarioDao = new UsuarioDaoImpl(); 
	}

	@Override
	public Usuario buscarLogin(String login) {
		return this.usuarioDao.buscarLogin(login);
	}

	@Override
	public String validarAcesso(String login, String senha) {
		Usuario usuario = buscarLogin(login);
		if (usuario == null){
		
			return Constantes.ERRO_LOGIN; 
		}else if (usuario != null) {
			if(!usuario.getSenha().equals(senha)) {
				return Constantes.ERRO_SENHA;
			}else {
				return Constantes.AUTORIZADO;
			}
		}
		return null;
	}
	
	
	
}
