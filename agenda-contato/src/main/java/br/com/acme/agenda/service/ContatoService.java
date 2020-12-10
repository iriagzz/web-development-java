
package br.com.acme.agenda.service;

import java.util.List;

import br.com.acme.agenda.model.Contato;


public interface ContatoService {

	public void salvar(Contato contato);

	public List<Contato> listarContatos();

	public void remover(Long idContato);

	public Contato buscarPorIdContato(Long idContato);
	
	public Contato buscarContatoPorEmail(String email);
	
	public void ativarDesativarContato(Long id);
	
	public boolean validarEmail(String email);
	
	public boolean checkAtivo(Long id);
	
	public void editarContato(Contato contato);
	
	
}