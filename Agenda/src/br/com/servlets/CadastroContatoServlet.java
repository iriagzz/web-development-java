package br.com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.model.Contato;

@WebServlet("/CadastroContatoServlet")
public class CadastroContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Contato contato;
	private static List<Contato> contatos = new ArrayList<>();

	public CadastroContatoServlet() {
		this.contato = new Contato();
	}

	public Contato getContato() {
		return contato;
	}

	public static List<Contato> getContatos() {
		return contatos;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String endereco = request.getParameter("endereco");
		String senha = request.getParameter("senha");

		if (validarUsuario(email) != null || validarTelefone(telefone) != null) {
			request.setAttribute("validador", "Contato já Cadastrado! Verifique e-mail ou telefone!");
			RequestDispatcher rd = request.getRequestDispatcher("cadastroContato.jsp");
			rd.forward(request, response);

		} else {
			contatos.add(new Contato(nome, email, telefone, endereco, senha));
			request.setAttribute("contatos", contatos);//vai pra tabela
			request.setAttribute("validador", "Contato Cadastrado com Sucesso!");
			RequestDispatcher rd = request.getRequestDispatcher("listaContatos.jsp");
			rd.forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("contatos", contatos);
		RequestDispatcher rd = request.getRequestDispatcher("listaContatos.jsp");
		rd.forward(request, response);
	}

	public Contato validarUsuario(String email) {
		for (Contato contato : contatos) {
			if (email.equals(contato.getEmail())) {
				return contato;
			}
		}
		return null;
	}

	public Contato validarTelefone(String telefone) {
		for (Contato contato : contatos) {
			if (telefone.equals(contato.getTelefone())) {
				return contato;
			}
		}
		return null;
	}

}
