package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("SelectController ȣ���");
		// ���(���� -> dao)
		request.setAttribute("message", "���� selectCon �̴�");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("selectResult");

		return mv;
	}

}
