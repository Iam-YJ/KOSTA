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
 * Servlet �ۼ� 1. �ݵ�� public Ŭ������ ���� 2. HttpServlet ��� 3. �ʿ��� �޼ҵ� ������ 4. ������������
 * ����(����) �� �� �ֵ��� ���� �ʿ��ϴ� - web.xml - @annotation���� ����
 */
public class LifeCycleServlet extends HttpServlet {

	public LifeCycleServlet() {
		System.out.println("LifeCycleServlet�� ������ ȣ��");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("LifeCycleServlet�� init() �޼ҵ� ȣ��");
	}

	/*
	 * @Override public void service(ServletRequest req, ServletResponse res) throws
	 * ServletException, IOException {
	 * System.out.println("LifeCycleServlet�� service() �޼ҵ� ȣ��");
	 * 
	 * }
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//������ ù �ٿ� ���� ������ �ѱ� ���ڵ� ���� �ʿ�
		resp.setContentType("text/html; charset=UTF-8");
		
		System.out.println("LifeCycleServlet�� doGet() �޼ҵ� ȣ��"); //�ܼ� ��� 
		
		//������ ��� -> jsp���� 
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title></title></head>");
		out.println("<body>");
		out.println("<h1 style='color:red'>�ȳ� - hello</h1>");
		
		//request�� ���޵Ǵ� ������ �ޱ�
		String id = req.getParameter("id");
		String age = req.getParameter("age");
		out.println("���̵� : "+id);
		out.println("���� : "+age);
		out.println("<hr>");
		out.println("<a href='test.jsp'> �̵�����</a>");
		
		
		//session �ʿ� - HttpSession
		HttpSession session = req.getSession();
		session.setAttribute("message", "���� �� ����?");
		
		//application �ʿ� - ServletContext
		ServletContext application = req.getServletContext();
		application.setAttribute("addr", "��⵵ �Ǳ�");
		
		//��Ű
		Cookie co = new Cookie("num","100");
		resp.addCookie(co);
		
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		
		System.out.println("LifeCycleServlet�� doPost() �޼ҵ� ȣ��");

	}

	@Override
	public void destroy() {
		System.out.println("LifeCycleServlet�� destroy() �޼ҵ� ȣ��");

	}

}
