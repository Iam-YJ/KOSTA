package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����� ��û�� �߾����������� �������� FrontController : ����� ��û�� �޾Ƽ� �׿� �ش��ϴ� Controller�� ã�Ƽ�
 * ȣ���ϰ� �� �����(ModelAndView) �޾Ƽ� �ش��ϴ� ���������� �̵���Ų��
 */
@WebServlet("/front")
public class DispatcherServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("��û��");

		String key = request.getParameter("key");
		System.out.println(key);
		Controller controller = null;

		if (key.equals("insert")) {
			// �̷������� �ϴ� ���� ��ü�� �ڲ� �����ϰ� ������� �ݺ���..
			// �׷��� �츮�� ��ü�� 1���� �����ؼ� �ϰ�ʹ�

			// ��ϱ��
			controller = new InsertController();
		} else if (key.equals("select")) {
			// �˻����
			controller = new SelectController();
		} else if (key.equals("delete")) {
			// �������
			controller = new DeleteController();
		} else if (key.equals("update")) {
			// �������
			controller = new UpdateController();
		}

		ModelAndView mv = controller.handleRequest(request, response);
		if (mv.isRedirect()) {
			response.sendRedirect(mv.getViewName());
		} else {
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
		}
	}

}
