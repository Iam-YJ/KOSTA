package kosta.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//keyField, keyWord 받기
		
		//dao 쪽의 검색 메소드 호출한 후 그 결과를 가지고
		//memberSelect.jsp 이동
		
		//"select * from member where id like '%단어%' "; xx
		//ps.setString(1, keyField);
		//ps.setString(2,"%"+keyWord+"%");
		 
		
		//"select * from member where " + keyField + " like ?" xx
		
		
		//"select * from member where id like ?" 
		//"select * from member where name like ?" 
		//"select * from member where addr like ?" 
		
		/*
		 * if(keyField.equals("id")) { 
		 * sql += " id like ? "; 
		 * }else if() { 
		 * sql += "name like ?"; 
		 * }
		 */
	}

}
