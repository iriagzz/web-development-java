//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.http.HttpServletResponse;
//
//public abstract class BemVindo {
//	
//	public static void getTelaBemVindo(HttpServletResponse response, String login) throws IOException {
//		//instancia um writer
//		PrintWriter writer = response.getWriter();
//		
//		//escreve o html
//		String htmlResposta = "<html>";
//        htmlResposta += "<h2>Seja Bem-Vindo Sr(a). " + login.toUpperCase() + "</h2>";    
//        htmlResposta += "</html>";
//        
//        //retorna a resposta
//        writer.println(htmlResposta);
//	}
//
//
//}

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/BemVindoServlet")
public class BemVindoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();

		String login = request.getParameter("login");

		// escreve o html
		String htmlResposta = "<html>";
		htmlResposta += "<h2>Seja Bem-Vindo Sr(a). " + login.toUpperCase() + "</h2>";
		htmlResposta += "</html>";

		writer.print(htmlResposta);
	}

}
