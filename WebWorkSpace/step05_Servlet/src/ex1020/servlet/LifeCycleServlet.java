package ex1020.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet 작성 1. 반드시 public 클래스로 선언 2. HttpServlet 상속 3. 필요한 메소드 재정의 4. 웹브라우져에서
 * 동작(실행) 할 수 있도록 설정 필요하다 - web.xml - @annotation으로 설정
 */
public class LifeCycleServlet extends HttpServlet {

	public LifeCycleServlet() {
		System.out.println("LifeCycleServlet의 생성자 호출");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("LifeCycleServlet의 init() 메소드 호출");
	}

	/*
	 * @Override public void service(ServletRequest req, ServletResponse res) throws
	 * ServletException, IOException {
	 * System.out.println("LifeCycleServlet의 service() 메소드 호출");
	 * 
	 * }
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//문서의 첫 줄에 현재 문서의 한글 인코딩 설정 필요
		resp.setContentType("text/html; charset=UTF-8");
		
		System.out.println("LifeCycleServlet의 doGet() 메소드 호출"); //콘솔 출력 
		
		//브라우저 출력 -> jsp에서 
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title></title></head>");
		out.println("<body>");
		out.println("<h1 style='color:red'>안녕 - hello</h1>");
		
		//request로 전달되는 데이터 받기
		String id = req.getParameter("id");
		String age = req.getParameter("age");
		out.println("아이디 : "+id);
		out.println("나이 : "+age);
		out.println("<hr>");
		out.println("<a href='test.jsp'> 이동하자</a>");
		
		
		//session 필요 - HttpSession
		HttpSession session = req.getSession();
		session.setAttribute("message", "점심 뭐 먹지?");
		
		//application 필요 - ServletContext
		ServletContext application = req.getServletContext();
		application.setAttribute("addr", "경기도 판교");
		
		//쿠키
		Cookie co = new Cookie("num","100");
		resp.addCookie(co);
		
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		
		System.out.println("LifeCycleServlet의 doPost() 메소드 호출");

	}

	@Override
	public void destroy() {
		System.out.println("LifeCycleServlet의 destroy() 메소드 호출");

	}

}
