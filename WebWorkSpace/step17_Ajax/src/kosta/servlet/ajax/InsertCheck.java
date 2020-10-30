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
import kosta.dto.CustomerDTO;

@WebServlet("/insert")
public class InsertCheck extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CustomerDTO cdto;
		CustomerDAO cdao = new CustomerDAOImpl();

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");

		cdto = new CustomerDTO(id, name, Integer.parseInt(age), tel, addr);

		PrintWriter out = response.getWriter();

		out.println(cdao.insert(cdto));

	}

}
