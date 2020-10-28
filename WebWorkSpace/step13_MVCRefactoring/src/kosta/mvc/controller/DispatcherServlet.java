package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 사용자 요청을 중앙집중적으로 관리해줄 FrontController : 사용자 요청을 받아서 그에 해당하는 Controller를 찾아서
 * 호출하고 그 결과를(ModelAndView) 받아서 해당하는 뷰페이지로 이동시킨다
 */
@WebServlet("/front")
public class DispatcherServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("요청됨");

		String key = request.getParameter("key");
		System.out.println(key);
		Controller controller = null;

		if (key.equals("insert")) {
			// 이런식으로 하는 것은 객체를 자꾸 생성하고 사라지고 반복됨..
			// 그래서 우리는 객체를 1번만 생성해서 하고싶다

			// 등록기능
			controller = new InsertController();
		} else if (key.equals("select")) {
			// 검색기능
			controller = new SelectController();
		} else if (key.equals("delete")) {
			// 삭제기능
			controller = new DeleteController();
		} else if (key.equals("update")) {
			// 수정기능
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
