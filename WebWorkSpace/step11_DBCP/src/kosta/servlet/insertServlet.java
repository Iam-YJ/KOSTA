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
		// 전송된 데이터 받아서 Member객체에 담기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");

		// 유효성 체크 권장함
		if (id == null || id.equals("") || pwd == null || pwd.equals("") || name == null || name.equals("")
				|| age == null || age.equals("") || phone == null || phone.equals("") || addr == null
				|| addr.equals("")) {
			request.setAttribute("msg", "입력값이 충분하지 않습니다.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}

		// 등록전에 id중복체크 한다
		MemberDAO mDao = new MemberDAOImpl();

		// 만약, id가 중복이라면 error.jsp 이동(오류메세지를 전달)
		if (mDao.idCheck(id)) {
			request.setAttribute("msg", "아이디가 사용중입니다");
			request.getRequestDispatcher("error.jsp").forward(request, response);

		} else {

			Member m = new Member(id, pwd, name, Integer.parseInt(age), phone, addr, null);

			int result = mDao.insert(m);
			// 등록하기
			if (result == 0) {
				// 만약, 등록이 실패하면 메세지를 가지고 error.jsp 이동
				request.setAttribute("msg", "회원 등록에 실패했습니다.");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			} else {
				// 성공하면 -> index.jsp 이동 or selectAll로 이동
				response.sendRedirect("selectAll");
			}

		}

	}

}
