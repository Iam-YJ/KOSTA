package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("selectController �Դϴ�");

		// ���� ȣ�� - dao ȣ�� - �� ��� �޾Ƽ� �ʿ��� ���� ����
		request.setAttribute("message", "�˻� ��� �����߾��");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("selectResult.jsp");//%{message} 
		return mv;
	}

}
