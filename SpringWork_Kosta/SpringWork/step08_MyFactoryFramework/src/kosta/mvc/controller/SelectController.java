package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("SelectController ȣ���");
		// ���(���� -> dao)
		request.setAttribute("message", "���� selectCon �̴�");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("selectResult.jsp");

		return mv;
	}

}
