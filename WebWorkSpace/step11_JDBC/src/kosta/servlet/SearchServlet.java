package kosta.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.MemberDAO;
import kosta.dao.MemberDAOImpl;
import kosta.dto.Member;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// keyField, keyWord 받기
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		String url = "memberSelect.jsp";

		// dao 쪽의 검색 메소드 호출한 후 그 결과를 가지고
		// memberSelect.jsp 이동
		MemberDAO mdao = new MemberDAOImpl();

		List<Member> list = mdao.searchByKeyWord(keyField, keyWord);
		
		if (list.size() == 0) {
			request.setAttribute("msg", keyField + "필드에 해당하는 검색 정보가 없습니다.");
			url = "error.jsp";
		
		} else {
			request.setAttribute("list", list);
		}

		request.getRequestDispatcher(url).forward(request, response);

		// "select * from member where id like '%단어%' "; xx
		// ps.setString(1, keyField);
		// ps.setString(2,"%"+keyWord+"%");

		// "select * from member where " + keyField + " like ?" xx

		// "select * from member where id like ?"
		// "select * from member where name like ?"
		// "select * from member where addr like ?"

		/*
		 * if(keyField.equals("id")) { sql += " id like ? "; }else if() { sql +=
		 * "name like ?"; }
		 */
	}

}
