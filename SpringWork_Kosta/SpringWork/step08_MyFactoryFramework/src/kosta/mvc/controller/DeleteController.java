package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DeleteController 호출됨");
		// 기능(서비스 -> dao)
		ModelAndView mv = new ModelAndView();
		mv.setViewName("deleteResult.jsp");
		mv.setRedirect(true); // redirect 방식으로 이동하자

		return mv;
	}

}
