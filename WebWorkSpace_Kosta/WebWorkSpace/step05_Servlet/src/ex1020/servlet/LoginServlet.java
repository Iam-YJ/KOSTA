package ex1020.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//등록하기 해야함
public class LoginServlet extends HttpServlet {
	String dbId = "jang";
	String dbPwd = "1234";
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8"); //post방식일 때 한글인코딩 설정 
		
		HttpSession session = req.getSession();
		
		//전송되는 데이터 받기
		String id = req.getParameter("userId");
		String pwd = req.getParameter("userPwd");
		
		PrintWriter out = resp.getWriter();
		
		//인증절차를 하고 일치하면 세션에 정보를 저장하고 LoginOk.jsp으로 이동
		if(dbId.equals(id) && dbPwd.equals(pwd)) {
			
			//인증이 성공했으니까 session 영역에 사용자 정보를 저장한다
			session.setAttribute("id",id);
			out.println("<h1>로그인 되었습니다.</h1>");
		
			//DB에서 데이터를 꺼내서 뷰쪽으로 전달해야 한다 
			List<String> hobbys = Arrays.asList("등산","수영","낚시");
			req.setAttribute("hobbys", hobbys);
			
			//정보 가지고 이동하기 위해서는 
			//forward 방식 이용해야 한다 
			req.getRequestDispatcher("session/LoginOK.jsp").forward(req, resp);
			
			//이동 : request, response를 새롭게 생성해서 이동 
			//resp.sendRedirect("session/LoginOK.jsp");
		}else {
		
			out.println("<html>");
			out.println("<head><title></title></head>");
			out.println("<body>");
			out.println("<h1 style='color:red'>회원 정보가 일치하지 않습니다.</h1>");
			out.println("</body>");
			out.println("</html>");
			
			
			
			resp.sendRedirect("session/LoginOK.jsp");
		}
		
		
		//틀리면 메세지 출력하고 뒤로가기 한다 
	}

}
