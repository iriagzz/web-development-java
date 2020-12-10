package br.com.acme.agenda.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.service.ContatoService;
import br.com.acme.agenda.service.ContatoServiceImpl;
import br.com.acme.agenda.utils.Constantes;

/**
 * PRIMEIRA CAMADA
 */
@WebServlet("/contatoControllerServlet")
public class ContatoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Contato contato;
	private ContatoService service;
	private List<Contato> contatos;

	public ContatoControllerServlet() {
		this.service = new ContatoServiceImpl();
		this.contatos = new ArrayList<Contato>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String id = request.getParameter("id");

		if (id != null) {
			switch (action) {
			case "ativar":
				if (this.service.checkAtivo(Long.parseLong(id))) {
					this.service.ativarDesativarContato(Long.parseLong(id));
					request.setAttribute("ativar_desativar", "Contato desativado com sucesso");
				} else if (!this.service.checkAtivo(Long.parseLong(id))) {
					this.service.ativarDesativarContato(Long.parseLong(id));
					request.setAttribute("ativar_desativar", "Contato ativado com sucesso");
				}
				break;
			case "remover":
				this.service.remover(Long.parseLong(id));
				request.setAttribute("remover", "Contato removido com sucesso");
				break;

			case "editar":
				Contato contato = this.service.buscarPorIdContato(Long.parseLong(id));
				request.setAttribute("id", contato.getId());
				request.setAttribute("nome", contato.getNome());
				request.setAttribute("email", contato.getEmail());
				request.setAttribute("telefone", contato.getTelefone());
				RequestDispatcher rd = request.getRequestDispatcher(Constantes.EDITAR_CONTATOS);
				rd.forward(request, response);
				doPost(request, response);
				break;

			case "visualizar":
				contato = this.service.buscarPorIdContato(Long.parseLong(id));
				request.setAttribute("id", contato.getId());
				request.setAttribute("nome", contato.getNome());
				request.setAttribute("email", contato.getEmail());
				request.setAttribute("telefone", contato.getTelefone());
				rd = request.getRequestDispatcher(Constantes.VISUALIZAR_CONTATOS);
				rd.forward(request, response);
				break;

			}

		}

		this.contatos = this.service.listarContatos();
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.LISTAR_CONTATOS);
		request.setAttribute("contatos", this.contatos);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		switch (action) {

		case "editarServlet":
			String id = request.getParameter("id");
			Contato contato = service.buscarPorIdContato(Long.parseLong(id));

			editarBanco(request, response, contato, Long.parseLong(id));

			doGet(request, response);

			break;

		case "salvar":

			this.contato = new Contato();

			salvarBanco(request, response, this.contato);

			doGet(request, response);
			break;

		}

	}

	public void salvarBanco(HttpServletRequest request, HttpServletResponse response, Contato contato) {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");

		contato.setNome(nome);
		contato.setEmail(email);
		contato.setTelefone(telefone);
		contato.isAtivo();

		if (!this.service.validarEmail(email)) {
			this.service.salvar(contato);
			request.setAttribute("sucesso", "Contato " + nome + " editado com sucesso!");
		} else {
			request.setAttribute("contatoExiste", "Contato com e-mail " + email + " já existe");
		}

	}

	public void editarBanco(HttpServletRequest request, HttpServletResponse response, Contato contato, Long id) {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");

		contato.setNome(nome);
		contato.setEmail(email);
		contato.setTelefone(telefone);

		this.service.editarContato(contato);
		request.setAttribute("sucesso", "Contato " + nome + " editado com sucesso!");

	}

}
