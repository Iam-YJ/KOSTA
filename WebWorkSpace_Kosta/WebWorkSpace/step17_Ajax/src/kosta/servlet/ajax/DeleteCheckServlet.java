package kosta.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.CustomerDAO;
import kosta.dao.CustomerDAOImpl;

/**
 * Servlet implementation class DeleteCheckServlet
 */
@WebServlet("/delete")
public class DeleteCheckServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		CustomerDAO dao = new CustomerDAOImpl();
		
		int result = dao.delete(id);
	
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
	}

}
