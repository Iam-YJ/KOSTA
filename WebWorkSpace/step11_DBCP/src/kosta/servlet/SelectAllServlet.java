package kosta.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.MemberDAO;
import kosta.dao.MemberDAOImpl;
import kosta.dto.Member;

/**
 * Servlet implementation class SelectAllServlet
 */
@WebServlet("/selectAll")
public class SelectAllServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// DAO �����Ѵ�
		MemberDAO mDao = new MemberDAOImpl();

		// DAO�� selectAll() ȣ���ϰ� �� ����� �޾Ƽ� scope�� �����ϰ� forward �������
		// memberSelect.jsp �̵��Ѵ�.
		List<Member> list = mDao.selectAll();
		request.setAttribute("list", list);

		RequestDispatcher rd = request.getRequestDispatcher("memberSelect.jsp");
		rd.forward(request, response);
		//request.getRequestDispatcher("memberSelect.jsp").forward(request, response);

	}

}
