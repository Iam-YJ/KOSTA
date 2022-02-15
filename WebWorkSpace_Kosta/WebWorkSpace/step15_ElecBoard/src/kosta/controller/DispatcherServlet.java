package kosta.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����� ��û�� �߾����������� �������� FrontController : ����� ��û�� �޾Ƽ� �׿� �ش��ϴ� Controller�� ã�Ƽ�
 * ȣ���ϰ� �� �����(ModelAndView) �޾Ƽ� �ش��ϴ� ���������� �̵���Ų��
 */
@WebServlet(urlPatterns = "/elec", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private Map<String, Controller> map;

	@Override
	public void init() throws ServletException {
		System.out.println("init call");
		map = (Map<String, Controller>) super.getServletContext().getAttribute("map");

	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("��û��");

		String key = request.getParameter("command");
		System.out.println(key);

		if (key == null || key.equals("")) {
			key = "list";
		} // command ���� ������ list.jsp �� ������.
			// ActionMapping ���� �̷��� ��������
			// list=kosta.controller.SelectController

		try {
			ModelAndView mv = map.get(key).handleRequest(request, response);
			if (mv.isRedirect()) {
				response.sendRedirect(mv.getViewName());
			} else {
				request.getRequestDispatcher(mv.getViewName()).forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("errorView/error.jsp").forward(request, response);;
		}
	}

}
