package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("InsertController ȣ���");
		// ���(���� -> dao)
		request.setAttribute("message", "���� insertCon �̴�");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("insertResult.jsp");

		return mv;
	}

}
