package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("SelectController 호출됨");
		// 기능(서비스 -> dao)
		request.setAttribute("message", "나는 selectCon 이다");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("selectResult.jsp");

		return mv;
	}

}
