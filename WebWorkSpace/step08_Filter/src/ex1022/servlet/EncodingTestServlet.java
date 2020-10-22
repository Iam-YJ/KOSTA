package ex1022.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EncodingTestServlet
 */
@WebServlet(urlPatterns = {"/encodingResult.jsp","/encResult"}, loadOnStartup=1)
public class EncodingTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EncodingTestServlet() {

    }

	public void init(ServletConfig config) throws ServletException {

	}


	public void destroy() {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		out.print("</h1>¿Ã∏ß : "+request.getParameter("name")+"</h1>");
		
	}

}
