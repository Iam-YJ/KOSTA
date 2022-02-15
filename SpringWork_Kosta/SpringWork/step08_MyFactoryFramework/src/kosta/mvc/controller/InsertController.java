package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("InsertController 호출됨");
		// 기능(서비스 -> dao)
		request.setAttribute("message", "나는 insertCon 이다");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("insertResult.jsp");

		return mv;
	}

}
