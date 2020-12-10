package br.com.acme.agenda.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.acme.agenda.service.UsuarioService;
import br.com.acme.agenda.service.UsuarioServiceImpl;
import br.com.acme.agenda.utils.Constantes;

/**
 * Servlet implementation class LoginControllerServlet
 */
@WebServlet("/loginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioService service;

	public LoginControllerServlet() {
		this.service = new UsuarioServiceImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		String validacao = service.validarAcesso(login, senha);
		
		HttpSession session = request.getSession();

		if (validacao.equals(Constantes.ERRO_LOGIN)) {
			request.setAttribute("falha", Constantes.ERRO_LOGIN.toString());
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else if (validacao.equals(Constantes.ERRO_SENHA)) {
			request.setAttribute("falha", Constantes.ERRO_SENHA.toString());
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else if (validacao.equals(Constantes.AUTORIZADO)) {
			session.setAttribute("login",login);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);

		}

	}

}
