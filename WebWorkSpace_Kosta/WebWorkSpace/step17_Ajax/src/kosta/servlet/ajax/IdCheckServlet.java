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

@WebServlet("/idCheck")
public class IdCheckServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		CustomerDAO cdao = new CustomerDAOImpl();
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");

		if (!cdao.idCheck(id)) {
			out.print("사용가능");
		} else {
			out.print("id가 중복입니다");
		}
	}

}
