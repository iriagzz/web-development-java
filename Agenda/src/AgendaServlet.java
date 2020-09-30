
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AgendaServlet")
public class AgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(">>>>>>>>>>>>>>>>> REQUEST " + request.getProtocol());

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		System.out.println("O nome que veio na requisição é " + login);
		System.out.println("A senha que veio na requisição é " + senha);

		request.setAttribute("login", login);

		if (login.equals("iria") && senha.equals("1234")) {
			RequestDispatcher rd = request.getRequestDispatcher("/BemVindoServlet");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
		}

	}

}
