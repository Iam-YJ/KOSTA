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

@WebServlet("/insert")
public class insertServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���۵� ������ �޾Ƽ� Member��ü�� ���
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");

		// ��ȿ�� üũ ������
		if (id == null || id.equals("") || pwd == null || pwd.equals("") || name == null || name.equals("")
				|| age == null || age.equals("") || phone == null || phone.equals("") || addr == null
				|| addr.equals("")) {
			request.setAttribute("msg", "�Է°��� ������� �ʽ��ϴ�.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}

		// ������� id�ߺ�üũ �Ѵ�
		MemberDAO mDao = new MemberDAOImpl();

		// ����, id�� �ߺ��̶�� error.jsp �̵�(�����޼����� ����)
		if (mDao.idCheck(id)) {
			request.setAttribute("msg", "���̵� ������Դϴ�");
			request.getRequestDispatcher("error.jsp").forward(request, response);

		} else {

			Member m = new Member(id, pwd, name, Integer.parseInt(age), phone, addr, null);

			int result = mDao.insert(m);
			// ����ϱ�
			if (result == 0) {
				// ����, ����� �����ϸ� �޼����� ������ error.jsp �̵�
				request.setAttribute("msg", "ȸ�� ��Ͽ� �����߽��ϴ�.");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			} else {
				// �����ϸ� -> index.jsp �̵� or selectAll�� �̵�
				response.sendRedirect("selectAll");
			}

		}

	}

}
