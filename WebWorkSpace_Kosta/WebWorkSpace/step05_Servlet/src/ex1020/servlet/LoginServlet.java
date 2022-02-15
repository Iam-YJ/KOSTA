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

//����ϱ� �ؾ���
public class LoginServlet extends HttpServlet {
	String dbId = "jang";
	String dbPwd = "1234";
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8"); //post����� �� �ѱ����ڵ� ���� 
		
		HttpSession session = req.getSession();
		
		//���۵Ǵ� ������ �ޱ�
		String id = req.getParameter("userId");
		String pwd = req.getParameter("userPwd");
		
		PrintWriter out = resp.getWriter();
		
		//���������� �ϰ� ��ġ�ϸ� ���ǿ� ������ �����ϰ� LoginOk.jsp���� �̵�
		if(dbId.equals(id) && dbPwd.equals(pwd)) {
			
			//������ ���������ϱ� session ������ ����� ������ �����Ѵ�
			session.setAttribute("id",id);
			out.println("<h1>�α��� �Ǿ����ϴ�.</h1>");
		
			//DB���� �����͸� ������ �������� �����ؾ� �Ѵ� 
			List<String> hobbys = Arrays.asList("���","����","����");
			req.setAttribute("hobbys", hobbys);
			
			//���� ������ �̵��ϱ� ���ؼ��� 
			//forward ��� �̿��ؾ� �Ѵ� 
			req.getRequestDispatcher("session/LoginOK.jsp").forward(req, resp);
			
			//�̵� : request, response�� ���Ӱ� �����ؼ� �̵� 
			//resp.sendRedirect("session/LoginOK.jsp");
		}else {
		
			out.println("<html>");
			out.println("<head><title></title></head>");
			out.println("<body>");
			out.println("<h1 style='color:red'>ȸ�� ������ ��ġ���� �ʽ��ϴ�.</h1>");
			out.println("</body>");
			out.println("</html>");
			
			
			
			resp.sendRedirect("session/LoginOK.jsp");
		}
		
		
		//Ʋ���� �޼��� ����ϰ� �ڷΰ��� �Ѵ� 
	}

}
