package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("deleteController �Դϴ�");

		// ���� ȣ�� - dao ȣ��
		request.setAttribute("message", "���� ��� �����߾��");
		
		//����� ���������� Redirect ������� select ��û �Ѵ� 
		ModelAndView mv = new ModelAndView("index.jsp", true);
		
		return mv;
	}

}
