package kosta.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 사용자 요청을 중앙집중적으로 관리해줄 FrontController : 사용자 요청을 받아서 그에 해당하는 Controller를 찾아서
 * 호출하고 그 결과를(ModelAndView) 받아서 해당하는 뷰페이지로 이동시킨다
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
		System.out.println("요청됨");

		String key = request.getParameter("command");
		System.out.println(key);

		if (key == null || key.equals("")) {
			key = "list";
		} // command 값이 없으면 list.jsp 로 갈꺼다.
			// ActionMapping 에서 이렇게 나와있음
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
