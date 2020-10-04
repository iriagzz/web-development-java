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
	private List<Contato> contatos;

	public CadastroContatoServlet() {
		this.contato = new Contato();
		this.contatos = new ArrayList();
	}
	
	

	public Contato getContato() {
		return contato;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	/* Singleton para que apenas um objeto seja instanciado! */
	private static CadastroContatoServlet instancia = null;

	public static CadastroContatoServlet getInstancia() {
		if (instancia == null) {
			instancia = new CadastroContatoServlet();
		}
		return instancia;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String endereco = request.getParameter("endereco");
		String senha = request.getParameter("senha");

		this.contato.setNome(nome);
		this.contato.setEmail(email);
		this.contato.setTelefone(telefone);
		this.contato.setEndereco(endereco);
		this.contato.setSenha(senha);

		this.contatos.add(this.contato);
		this.contato = new Contato();

		request.setAttribute("contatos", this.contatos);
		RequestDispatcher rd = request.getRequestDispatcher("listaContatos.jsp");
		rd.forward(request, response);
	}

	// memoria - para que haja um usuario pre-cadastrado
	public void memoria() {
		CadastroContatoServlet cadastro = CadastroContatoServlet.getInstancia();
		this.contatos.add(new Contato("iria", "iria@gmail.com", "32461852", "rua das flores", "1234"));
	}
	

}
