package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("updateController �Դϴ�");

		// ���� ȣ�� - dao ȣ��
		request.setAttribute("message", "���� ��� �����߾��");
		
		//����� ���������� Redirect ������� select ��û �Ѵ� 
		ModelAndView mv = new ModelAndView("updateResult.jsp", false );
		
		return mv;
	}

}
