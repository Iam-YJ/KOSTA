package kosta.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.MemberDAO;
import kosta.dao.MemberDAOImpl;
import kosta.dto.Member;

@WebServlet("/delete")
public class deleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		MemberDAO mDao = new MemberDAOImpl();

		if (mDao.deleteId(id) == 0) {
			request.setAttribute("msg", id + "에 해당하는 정보를 삭제할 수 없습니다.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		} else {
			response.sendRedirect("selectAll");

		}

	}

}
