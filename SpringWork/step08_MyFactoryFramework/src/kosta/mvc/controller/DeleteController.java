package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DeleteController ȣ���");
		// ���(���� -> dao)
		ModelAndView mv = new ModelAndView();
		mv.setViewName("deleteResult.jsp");
		mv.setRedirect(true); // redirect ������� �̵�����

		return mv;
	}

}
