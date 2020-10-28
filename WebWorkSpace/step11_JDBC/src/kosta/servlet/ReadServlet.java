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

/**
 * Servlet implementation class ReadServlet
 */
@WebServlet("/read")
public class ReadServlet extends HttpServlet {
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String url = "read.jsp";
		
		MemberDAO dao = new MemberDAOImpl();
		
		Member member = dao.selectById(id);
				
		if(member == null) {
			request.setAttribute("msg", id + "상세 정보를 불러올 수 없습니다.");
			url = "error.jsp";
		}else {
			request.setAttribute("member", member);  //뷰에서 ${member.속성}으로 각각의 값 출력 
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
