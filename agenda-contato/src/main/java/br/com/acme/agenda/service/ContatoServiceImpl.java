
package br.com.acme.agenda.service;

import java.util.List;

import br.com.acme.agenda.dao.ContatoDao;
import br.com.acme.agenda.dao.ContatoDaoImpl;
import br.com.acme.agenda.model.Contato;

/**
 * SEUNDA CAMADA
 *
 */
public class ContatoServiceImpl implements ContatoService {

	private ContatoDao contatoDao;

	public ContatoServiceImpl() {
		contatoDao = new ContatoDaoImpl();
	}

	@Override
	public void salvar(Contato contato) {
		this.contatoDao.salvar(contato);
	}

	@Override
	public List<Contato> listarContatos() {
		return this.contatoDao.listarContatos();
	}

	@Override
	public void remover(Long idContato) {
		this.contatoDao.remover(idContato);
	}

	@Override
	public Contato buscarPorIdContato(Long idContato) {
		return this.contatoDao.buscarPorIdContato(idContato);
	}

	@Override
	public void ativarDesativarContato(Long id) {
		this.contatoDao.ativarDesativarContato(id);
	}

	@Override
	public Contato buscarContatoPorEmail(String email) {
		return this.contatoDao.buscarContatoPorEmail(email);
	}
	
	@Override
	public boolean validarEmail(String email) {
		if (buscarContatoPorEmail(email) != null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean checkAtivo(Long id) {
		Contato contato = buscarPorIdContato(id);
		return contato.isAtivo();
	}

	@Override
	public void editarContato(Contato contato) {
		this.contatoDao.editarContato(contato);
		
	}
}
