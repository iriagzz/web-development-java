package br.com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.model.Contato;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		if (validarLogin(login,senha)) {
			request.setAttribute("login", login);
			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("erro", "Login ou senha inválido");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	public Contato validarUsuario(String email) {
		CadastroContatoServlet cadastro = CadastroContatoServlet.getInstancia();
		cadastro.memoria();
		
		
		for (Contato contato : cadastro.getContatos()) {
			if (email.equals(contato.getEmail())) {
				return contato;
			}
		}
		return null;
	}

	public boolean validarLogin(String login, String senha) {
		Contato contato = validarUsuario(login);
		if (contato != null) {
			if (contato.getEmail().equals(login) && contato.getSenha().equals(senha)) {
				return true;
			} else {
				return false;
			}

		}
		return false;

	}

}
